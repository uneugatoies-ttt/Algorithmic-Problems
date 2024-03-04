package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1929 {
	public static void isPrime(boolean[] sieve, int n) {
		// Initialization
		sieve[0] = sieve[1] = false;
		int sqrtn = (int) Math.floor( Math.sqrt(n) );
		
		// Loop
		for (int i = 2; i <= sqrtn; ++i) {
			if (sieve[i]) {
				for (int j = i * i; j <= n; j += i)
					sieve[j] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// Input and initialization
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(token.nextToken());
		int n = Integer.parseInt(token.nextToken());
		boolean[] sieve = new boolean[n + 1];
		for (int i = 0; i <= n; ++i)
			sieve[i] = true;
		
		// Calling a procedure
		isPrime(sieve, n);

		// Output and termination
		for (int i = m; i <= n; i++)
			if (sieve[i]) builder.append(i).append('\n');
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
