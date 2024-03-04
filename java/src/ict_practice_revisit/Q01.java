package ict_practice_revisit;

import java.util.Arrays;
import java.util.Scanner;

public class Q01 {
	
	private static void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int res = 0;
		int curr = 0;
		
		for (int i : arr) {
			curr++;
			if (curr >= i) {
				res++;
				curr = 0;
			}
		}
			
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		solve();
	}

}
