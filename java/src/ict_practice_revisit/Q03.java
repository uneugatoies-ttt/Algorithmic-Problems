package ict_practice_revisit;

import java.util.Scanner;

public class Q03 {
	
	private static void solve() {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int conszeros = 0;
		int consones = 0;
		
		if (str.charAt(0) == '0')
			conszeros++;
		else 
			consones++;
		
		for (int i = 1; i < str.length(); ++i) {
			if (str.charAt(i) == '0') {
				if (str.charAt(i - 1) == '0')
					continue;
				else
					conszeros++;
			} else {
				if (str.charAt(i - 1) == '1')
					continue;
				else
					consones++;
			}
		}
		
		System.out.println(Math.min(conszeros, consones));
	}
	
	public static void main(String[] args) {
		solve();
	}

}
