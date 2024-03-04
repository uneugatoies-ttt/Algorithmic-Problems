package ict_practice.part3.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// This approach worked, but I couldn't get the full grasp over the problem.
public class Q33 {
	
	static int n;
	static int[] tt, pp;
	// dp[i]: 	the greatest profit you can earn at "i"th day,
	// 			when you must perform the councelling of "i"th day 
	// 			(unless it would exceed the day limit).
	static int[] dp;
	
	private static int perform() {
		if (tt[1] <= n)
			dp[1] = pp[1];
		
		for (int i = 2; i <= n; ++i) {
			if (i + tt[i] - 1 <= n)
				dp[i] += pp[i];
			
			int mx = 0;
			for (int j = 1; j <= i; ++j) {
				if (j + tt[j] <= i)
					mx = Math.max(mx, dp[j]);
			}
			if (mx > 0)
				dp[i] += mx;
		}
		
		
		int mx = Integer.MIN_VALUE;
		for (int i = 1; i <= n; ++i)
			mx = Math.max(mx, dp[i]);
		
		return mx;
		//return dp[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		tt = new int[n + 1];
		pp = new int[n + 1];
		dp = new int[n + 1];
		
		StringTokenizer st;
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			tt[i] = Integer.parseInt(st.nextToken());
			pp[i] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(String.valueOf(perform()));
		bw.write('\n');
		bw.flush();
	}

}
