package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19_2 {
	
	private static int n;
	private static int[] operators = new int[4];
	private static int[] nums;
	private static int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
	
	private static void permutation(int cnt, int sum) {
		if (cnt == n)
		{
			mx = Math.max(mx, sum);
			mn = Math.min(mn, sum);
			return;
		}
		
		for (int i = 0; i < 4; ++i)
		{
			if (operators[i] == 0)
				continue;
			operators[i]--;
			if (i == 0)
				permutation(cnt + 1, sum + nums[cnt]);
			else if (i == 1)
				permutation(cnt + 1, sum - nums[cnt]);
			else if (i == 2)
				permutation(cnt + 1, sum * nums[cnt]);
			else if (i == 3)
				permutation(cnt + 1, sum / nums[cnt]);
			operators[i]++;
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		nums = new int[n];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			nums[i] = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < 4; ++i)
			operators[i] = Integer.parseInt(token.nextToken());
		
		permutation(1, nums[0]);
		
		System.out.println(mx);
		System.out.println(mn);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
