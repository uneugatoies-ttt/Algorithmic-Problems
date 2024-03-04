package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ6588 {
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
		StringBuilder storeBuild = new StringBuilder();
		StringTokenizer token = null;
		String entry = " ";
		int count = 0;
		
		while (!entry.equals("0")) {
			token = new StringTokenizer(reader.readLine());
			entry = token.nextToken();
			storeBuild.append(entry).append(" ");
			count++;
		}
		
		int[] storeArr = new int[--count];
		int max = 0;
		for (int i = 0; i < count; ++i) {
			storeArr[i] = Integer.parseInt(storeBuild.substring(0, storeBuild.indexOf(" ")));
			storeBuild.delete(0, storeBuild.indexOf(" ") + 1);
			if (max < storeArr[i])
				max = storeArr[i];
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
