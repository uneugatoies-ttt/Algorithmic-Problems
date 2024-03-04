package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chapter8Problem3 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		if (n > 1) dp[2] = dp[1] + 2;
		for (int i = 3; i <= n; ++i)
			dp[i] = (dp[i - 1] + 2 * dp[i - 2] % 796796) % 796796 ;
		System.out.println(dp[n]);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
