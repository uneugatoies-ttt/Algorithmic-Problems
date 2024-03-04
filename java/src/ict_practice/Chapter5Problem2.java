package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chapter5Problem2 {
	
	// using BFS
	private static boolean[][] visited;
	private static int[][] maze;
	private static int minimum = 100000;
	private static int n, m;
	
	public static void solve() {
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		maze = new int[n][m];
		visited = new boolean[n][m];
		String entry;
		for (int i = 0; i < n; ++i) {
			entry = reader.readLine();
			for (int j = 0; j < m; ++j)
				maze[i][j] = entry.charAt(j) - '0';
		}
		solve();
		
		System.out.println(minimum);
	}
	
	// my attempt (probably valid)
	/*
	private static boolean[][] visited;
	private static int[][] maze;
	private static int minimum = 100000;
	private static int n, m;
	
	private static void solve(int y, int x, int cnt) {
		if (y == n - 1 && x == m - 1) {
			if (cnt < minimum)
				minimum = cnt;
		}
		
		visited[y][x] = true;
		
		if (y + 1 < n && !visited[y + 1][x] && maze[y + 1][x] == 1)
			solve(y + 1, x, cnt + 1);
		if (x + 1 < m && !visited[y][x + 1] && maze[y][x + 1] == 1)
			solve(y, x + 1, cnt + 1);
		if (y - 1 > -1 && !visited[y - 1][x] && maze[y - 1][x] == 1)
			solve(y - 1, x, cnt + 1);
		if (x - 1 > -1 && !visited[y][x - 1] && maze[y][x - 1] == 1)
			solve(y, x - 1, cnt + 1);
		
		visited[y][x] = false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		maze = new int[n][m];
		visited = new boolean[n][m];
		String entry;
		for (int i = 0; i < n; ++i) {
			entry = reader.readLine();
			for (int j = 0; j < m; ++j)
				maze[i][j] = entry.charAt(j) - '0';
		}
		solve(0, 0, 1);
		
		System.out.println(minimum);
	}
	*/

}
