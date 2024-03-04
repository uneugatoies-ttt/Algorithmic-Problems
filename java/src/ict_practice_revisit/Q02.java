package ict_practice_revisit;

import java.util.Scanner;

public class Q02 {
	
	private static void solve() {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] entry = new int[str.length()];
		for (int i = 0; i < str.length(); ++i)
			entry[i] = str.charAt(i) - '0';
		
		int res = entry[0];
		for (int i = 0; i < str.length() - 1; ++i) {
			if (entry[i] == 0 || entry[i + 1] == 0)
				res += entry[i + 1];
			else
				res *= entry[i + 1];
		}
		
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		solve();
	}

}
