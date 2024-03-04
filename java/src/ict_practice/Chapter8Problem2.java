package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chapter8Problem2 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int[] depots = new int[n + 1];
		int[] dp = new int[n + 1];
		token = new StringTokenizer(reader.readLine());
		for (int i = 1; i <= n; ++i) 
			depots[i] = Integer.parseInt(token.nextToken());
		dp[0] = 0;
		dp[1] = depots[1];
		dp[2] = depots[2];
		for (int i = 3; i <= n; ++i)
			dp[i] = Math.max(dp[i - 2] + depots[i], dp[i - 1]);
		
		System.out.println(dp[n]);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
