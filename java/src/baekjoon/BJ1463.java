package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1463 {
	
	public static int minOper(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 0;
		
		for (int i = 2; i <= n; ++i) {
			dp[i] = 1 + dp[i - 1];
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt(token.nextToken());
		
		System.out.println(minOper(n));

		reader.close();
	}

}
