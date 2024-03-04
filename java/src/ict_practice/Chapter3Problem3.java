package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chapter3Problem3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt( token.nextToken() );
		int m = Integer.parseInt( token.nextToken() );
		
		int[][] cards = new int[n][m];
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; ++j)
				cards[i][j] = Integer.parseInt(token.nextToken());
		}
		
		int[] mins = new int[n];
		
		for (int i = 0; i < n; ++i) {
			Arrays.sort(cards[i]);
			mins[i] = cards[i][0];
		}
		
		Arrays.sort(mins);
		
		System.out.println(mins[n - 1]);
	}

}
