package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BJ11653 {
	// the modified Sieve for prime factorization
	public static void eratosthenes(int[] factorSieve, int n) {
		factorSieve[0] = factorSieve[1] = -1;
		
		for (int i = 2; i <= n; ++i)
			factorSieve[i] = i;
		
		int sqrtn = (int) Math.sqrt(n);
		
		for (int i = 2; i <= sqrtn; ++i)
			if (factorSieve[i] == i)
				for (int j = i * i; j <= n; j += i)
					if (factorSieve[j] == j)
						factorSieve[j] = i;
	}
	
	// prime factorization with Sieve
	public static List<Integer> factor(int[] factorSieve, int n) {
		List<Integer> primeFactors = new ArrayList<>();
		while (n > 1) {
			primeFactors.add(factorSieve[n]);
			n /= factorSieve[n];
		}
		return primeFactors;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		
		int n = Integer.parseInt( reader.readLine() );
		if (n <= 1) return;
		
		int[] factorSieve = new int[n + 1];
		eratosthenes(factorSieve, n);
		for (int i : factor(factorSieve, n))
			builder.append(i).append('\n');
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
