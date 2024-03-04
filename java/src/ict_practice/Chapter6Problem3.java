package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Chapter6Problem3 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		int[] A = new int[n];
		int[] B = new int[n];
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			A[i] = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			B[i] = Integer.parseInt(token.nextToken());
		
		Arrays.sort(A);
		Arrays.sort(B);
		int[] descendingB = Arrays.stream(B)
								.boxed()
								.sorted(Collections.reverseOrder())
								.mapToInt(i -> i.intValue())
								.toArray();
		
		for (int i = 0; i < k; ++i)
			A[i] = descendingB[i];
		
		int sum = 0;
		
		for (int i = 0; i < n; ++i)
			sum += A[i];
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
