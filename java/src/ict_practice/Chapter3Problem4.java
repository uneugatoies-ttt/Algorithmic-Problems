package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chapter3Problem4 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 0;
		
		for (int i = 2; i <= n; ++i) {
			dp[i] = dp[i - 1] + 1;
			if (i % k == 0) dp[i] = Math.min(dp[i], dp[i / k] + 1);
		}
		
		System.out.println(dp[n]);
	}
}
