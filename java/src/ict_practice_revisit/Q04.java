package ict_practice_revisit;

import java.util.Arrays;
import java.util.Scanner;

public class Q04 {
	
	private static void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] coins = new int[n];
		
		for (int i = 0; i < n; ++i)
			coins[i] = sc.nextInt();
		
		Arrays.sort(coins);
		
		int mn = -1;
		if (coins[0] > 1) {
			mn = 1;
		} else {
			mn = coins[0] + 1;
			
			for (int i = 1; i < n; ++i) {
				if (mn < coins[i])
					break;
				mn += coins[i];
			}
		}
		
		System.out.println(mn);
	}
	
	public static void main(String[] args) {
		solve();
	}
	
}



// probably right, but a little bit clumsy.
// the reason is because this code initializes "mn" with coins[0];
// but if we use coins[0] + 1 instead, we can do this more easily.
/*
public class Q04 {
	
	private static void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] coins = new int[n];
		for (int i = 0; i < n; ++i)
			coins[i] = sc.nextInt();
		
		Arrays.sort(coins);
		
		int res = coins[0];
		if (coins[0] == 1) {
			for (int i = 1; i < n; ++i) {
				if (res + 1 < coins[i]) {
					res++;
					break;
				}
				if (i == n - 1) {
					if (res + 1 == coins[i])
						res += 2;
					else
						res++;
					break;
				}
				res = res + coins[i];
			}
		}
		
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		solve();
	}

}*/
