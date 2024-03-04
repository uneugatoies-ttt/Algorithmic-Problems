package ict_practice.part3.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q33_2 {
	
	static int n;
	static int[] t = new int[15], p = new int[15];
	static int[] dp = new int[16];
	static int mx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer token;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(token.nextToken());
			p[i] = Integer.parseInt(token.nextToken());
		}
		
		for (int i = n - 1; i >= 0; --i) {
			int time = t[i] + i;
			
			if (time <= n) {
				dp[i] = Math.max(p[i] + dp[time], mx);
				mx = dp[i];
			}
			else
				dp[i] = mx;
		}
		
		bw.write(String.valueOf(mx) + "\n");
		bw.flush();
	}
	

}
