package ict_practice.part3.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class Q09Solution {
	public int solution(String s) {
		int res = s.length();
		int len = s.length();
		StringBuilder compressed = new StringBuilder();
		String curr = null;
		String prev = null;
		int cnt;
		
		for (int step = 1; step <= len / 2; ++step) {
			
			compressed.delete(0, compressed.length());
			prev = s.substring(0, step);
			cnt = 1;
			
			for (int j = step; j < len; j += step) {
				curr = (j + step <= len) ? s.substring(j, j + step) : s.substring(j);
				if (prev.equals(curr)) {
					cnt++;
				} else {
					compressed.append( (cnt > 1) ? String.valueOf(cnt) + prev : prev );
					prev = curr;
					cnt = 1;
				}
			}
			
			compressed.append( (cnt > 1) ? String.valueOf(cnt) + prev : prev );
			res = Math.min(res, compressed.length());
		}
		
		return res;
	}
}



public class Q09_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Q09Solution s = new Q09Solution();
		int res = s.solution(reader.readLine());
		
		System.out.println(res);
		
	}
	
}



/*
class Q09Solution {
	public int solution(String s) {
		int res = s.length();
		int len = s.length();
		StringBuilder compressed = new StringBuilder();
		String prev = null;
		String curr = null;
		int cnt;
		
		for (int step = 1; step <= (len / 2); ++step) {
			compressed.delete(0, compressed.length());
			prev = s.substring(0, step);
			cnt = 1;
			
			for (int j = step; j < len; j += step) {
				curr = (j + step <= len) ? s.substring(j, j + step) : s.substring(j);
				if (prev.equals(curr))
					cnt++;
				else {
					compressed.append( (cnt >= 2) ? String.valueOf(cnt) + prev : prev );
					prev = curr;
					cnt = 1;
				}
			}
			
			compressed.append( (cnt >= 2) ? String.valueOf(cnt) + prev : prev );
			res = Math.min(res, compressed.length());
		}
		
		return res;
	}
}
*/