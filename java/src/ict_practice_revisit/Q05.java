package ict_practice_revisit;

import java.util.Scanner;

public class Q05 {
	
	private static void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] balls = new int[n];
		
		for (int i = 0; i < n; ++i)
			balls[i] = sc.nextInt();
		
		int cnt = 0;
		for (int i = 0; i < n - 1; ++i) {
			for (int j = i + 1; j < n; ++j)
				if (balls[i] != balls[j])
					cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) {
		solve();
	}

}
