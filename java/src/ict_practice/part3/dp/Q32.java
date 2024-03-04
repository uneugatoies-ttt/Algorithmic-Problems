package ict_practice.part3.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q32 {
	
	private static int n;
	private static int[][] tri;
	private static int[][] dp;
	
	private static int performDP() {
		dp[0][0] = tri[0][0];
		
		for (int i = 1; i < n; ++i) {
			dp[i][0] = dp[i - 1][0] + tri[i][0];
			for (int j = 1; j <= i; ++j)
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j];
		}
		
		int mx = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i)
			mx = Math.max(mx, dp[n - 1][i]);
		return mx;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		tri = new int[n][n];
		dp = new int[n][n];
		StringTokenizer st;
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; ++j)
				tri[i][j] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(String.valueOf(performDP()));
		bw.flush();
	}

}
