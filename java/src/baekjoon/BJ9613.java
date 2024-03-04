package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ9613 {
	public static int euclidean(int a, int b) {
		if (a < b) {
			int swap = a;
			a = b;
			b = swap;
		}
		int r = a % b;
		if (r == 0)
			return b;
		else 
			return euclidean(b, r);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());

		StringTokenizer tokenInner = null;
		int[] arr = null;
		// It has to be the type 'long' because it can be as large as ((10^8 * 99) / 2) which exceeds the extent of 'int'.
		long sum = 0;
		
		for (int i = 0; i < n; i++) {
			tokenInner = new StringTokenizer(reader.readLine());
			int m = Integer.parseInt(tokenInner.nextToken());
			arr = new int[m];
			for (int j = 0; j < m; j++)
				arr[j] = Integer.parseInt(tokenInner.nextToken());

			for (int j = 0; j < m; j++) {
				for (int k = j + 1; k < m; k++) {
					sum += euclidean(arr[j], arr[k]);
				}
			}
			builder.append(sum).append("\n");
			sum = 0;
		}
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
