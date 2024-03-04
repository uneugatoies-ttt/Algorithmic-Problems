package ict_practice.part3.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q24_2 {
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] houses = new int[n];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			houses[i] = Integer.parseInt(token.nextToken());
		
		Arrays.sort(houses);
		
		System.out.println(houses[(n - 1) / 2]);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
}