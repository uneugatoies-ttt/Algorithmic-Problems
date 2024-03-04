package ict_practice.part3.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q04 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(token.nextToken());
		
		Arrays.sort(arr);
		
		if (arr[0] != 1) {
			writer.write(String.valueOf(1));
			writer.flush();
			writer.close();
			reader.close();
			return;
		}
		
		int mn = arr[0] + 1;
		
		for (int i = 1; i < n; ++i) {
			if (arr[i] > mn)
				break;
			mn += arr[i];
		}
		
		writer.write(String.valueOf(mn));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
