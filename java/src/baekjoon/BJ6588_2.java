package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ6588_2 {
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
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		StringTokenizer token = null;
		String entry = " ";
		int[] storeArr = new int[100000];
		int max = 0;
		int count;
		for (count = 0; ; ++count) {
			token = new StringTokenizer(reader.readLine());
			entry = token.nextToken();
			if (entry.equals("0")) break;
			storeArr[count] = Integer.parseInt(entry);
			if (max < storeArr[count]) max = storeArr[count];
		}
		
		boolean[] sieve = new boolean[max + 1];
		for (int i = 0; i < max + 1; ++i)
			sieve[i] = true;
		
		isPrime(sieve, max);
		
		for (int i = 0; i < count; ++i) {
			int a;
			for (a = 3; a <= storeArr[i]; ++a) {
				if (sieve[a] && sieve[storeArr[i] - a]) {
					builder.append(storeArr[i] + " = " + a + " + " + (storeArr[i] - a) + "\n");
					break;
				}
			}
			if (a > storeArr[i]) builder.append("Goldbach's conjecture is wrong.\n");
		}
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
