package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chapter4Problem1 {
	
	public static int solve(int y, int x) {
		int count = 0;
		
		if (x + 2 < 9) {
			if (y + 1 < 9) count++;
			if (y - 1 > 0) count++;
		}
		
		if (x - 2 > 0) {
			if (y + 1 < 9) count++;
			if (y - 1 > 0) count++;
		}
		
		if (y + 2 < 9) {
			if (x + 1 < 9) count++;
			if (x - 1 > 0) count++;
		}
		
		if (y - 2 > 0) {
			if (x + 1 < 9) count++;
			if (x - 1 > 0) count++;
		}

		return count;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String location = reader.readLine();
		int y = location.charAt(1) - '0';
		int x = location.charAt(0) - 'a' + 1;

		System.out.println(solve(y, x));
	}
}
