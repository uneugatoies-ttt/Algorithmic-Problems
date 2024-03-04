package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chapter4Example1 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(reader.readLine());
		String entry = "";
		char c;
		while (token.hasMoreElements()) {
			c = token.nextToken().charAt(0);
			entry += c;
		}

		int y = 1, x = 1;
		
		for (int i = 0; i < entry.length(); ++i) {
			if (entry.charAt(i) == 'L' && x > 1)
				x--;
			if (entry.charAt(i) == 'R' && x < n)
				x++;
			if (entry.charAt(i) == 'U' && y > 1)
				y--;
			if (entry.charAt(i) == 'D' && y < n)
				y++;
		}
		
		System.out.print(y);
		System.out.print(' ');
		System.out.println(x);
	}
}
