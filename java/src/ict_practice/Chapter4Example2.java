package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chapter4Example2 {
	public static int solve2(int n) {
		String digits;
		int count = 0;
		for (int h = 0; h <= n; ++h) {
			for (int m = 0; m < 60; ++m) {
				for (int s = 0; s < 60; ++s) {
					digits = String.valueOf(h) + String.valueOf(m) + String.valueOf(s);
					for (int i = 0; i < digits.length(); ++i) {
						if (digits.charAt(i) == '3') {
							count++;
							break;
						}
					}
				}
			}
		}
		
		return count;
	}
	
	public static int solve(int n) {
		int s = 0, m = 0, h = 0;
		int count = 0;
		String digits;
		while (h < n + 1) {
			digits = String.valueOf(h);
			digits += String.valueOf(m);
			digits += String.valueOf(s);
			
			for (int i = 0; i < digits.length(); ++i) {
				if (digits.charAt(i) == '3') {
					count++;
					break;
				}
			}
			s++;
			if (s == 60) {
				s = 0;
				m++;
				if (m == 60) {
					m = 0;
					h++;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( reader.readLine() );
		System.out.println(solve(n));
		System.out.println(solve2(n));
	}
}
