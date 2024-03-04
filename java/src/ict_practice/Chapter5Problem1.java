package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chapter5Problem1 {

	private static boolean[][] visited;
	private static int[][] frame;
	private static int n, m;
	
	public static void solve(int y, int x) {
		visited[y][x] = true;
		if (y - 1 > -1 && !visited[y - 1][x] && frame[y - 1][x] == 0)
			solve(y - 1, x);
		if (y + 1 < n && !visited[y + 1][x] && frame[y + 1][x] == 0)
			solve(y + 1, x);
		if (x - 1 > -1 && !visited[y][x - 1] && frame[y][x - 1] == 0)
			solve(y, x - 1);
		if (x + 1 < m && !visited[y][x + 1] && frame[y][x + 1] == 0)
			solve(y, x + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		
		int count = 0;
		visited = new boolean[n][m];
		frame = new int[n][m];
		
		String entry;		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			entry = token.nextToken();
			for (int j = 0; j < m; ++j ) 
				frame[i][j] = entry.charAt(j) - '0';
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (!visited[i][j] && frame[i][j] == 0) {
					count++;
					solve(i, j);
				}
			}
		}
		
		System.out.println(count);
	}

}
