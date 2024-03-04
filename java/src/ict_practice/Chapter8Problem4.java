package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chapter8Problem4 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int[] coin = new int[n];
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			coin[i] = Integer.parseInt(token.nextToken());
		}
		
		int[] dp = new int[m + 1];
		Arrays.fill(dp, 20000);
		dp[0] = 0;
		
		for (int c : coin) {
			for (int i = c; i <= m; ++i)
				if (dp[i - c] != 20000)
					dp[i] = Math.min(dp[i], dp[i - c] + 1);
		}
		
		if (dp[m] == 20000)
			System.out.println(-1);
		else
			System.out.println(dp[m]);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

	
	/*
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int[] coin = new int[n];
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			coin[i] = Integer.parseInt(token.nextToken());
		}
		int init = Arrays.stream(coin).min().orElseThrow();
		
		if (init < m) {
			int[] dp = new int[m + 1];
			
			for (int i = 0; i < init; ++i)
				dp[i] = -1;
			dp[init] = 1;
			
			
			for (int i = init + 1; i <= m; ++i) {
				dp[i] = 999999;
				for (int c : coin) {
					if (i - c == 0)
						dp[i] = 1;
					else if (i - c > 1 && dp[i - c] != -1)
						dp[i] = Math.min(dp[i - c] + 1, dp[i]);
				}
				if (dp[i] == 999999)
					dp[i] = -1;
			}
			
			
			System.out.println(dp[m]);
		} else {
			System.out.println(-1);
		}
	}*/
}
