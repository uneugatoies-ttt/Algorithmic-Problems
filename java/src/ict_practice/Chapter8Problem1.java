package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chapter8Problem1 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int x = Integer.parseInt(token.nextToken());
		int[] dp = new int[x + 1];
		dp[0] = 0;
		dp[1] = 0;
		if (x > 1) dp[2] = 1;
		for (int i = 3; i <= x; ++i) {
			dp[i] = dp[i - 1] + 1;
			if (i % 5 == 0)
				dp[i] = Math.min(dp[i], dp[i / 5] + 1);
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
		}
		
		System.out.println(dp[x]);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
