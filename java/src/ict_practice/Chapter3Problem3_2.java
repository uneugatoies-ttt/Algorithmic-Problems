package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chapter3Problem3_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken()), m = Integer.parseInt(token.nextToken());
		int max = 0;
		int minEachRow;
		int k;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			k = Integer.parseInt(token.nextToken());
			minEachRow = k;
			for (int j = 1; j < m; ++j) {
				k = Integer.parseInt(token.nextToken());
				if (minEachRow > k) minEachRow = k;
			}
			if (minEachRow > max) max = minEachRow;
		}
		System.out.println(max);
	}
}
