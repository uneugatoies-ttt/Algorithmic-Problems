package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chapter4Problem2_2 {
	
	private static int d;
	private static int[][] ds = {{-1,0},{0,1},{1,0},{0,-1}};
	private static int[][] map = new int[50][50];
	private static boolean[][] visited = new boolean[50][50];
	private static int n, m;
	private static int y, x;
	
	private static void turnLeft() {
		if (--d < 0) d = 3;
	}
	
	private static int move() {
		int cnt = 1;
		int turnCnt = 0;
		int yy, xx;
		visited[y][x] = true;
		while (true) {
			turnLeft();
			turnCnt++;
			if (turnCnt < 4) {
				yy = y + ds[d][0];
				xx = x + ds[d][1];
				if (yy > -1 && yy < n && xx > -1 && xx < m) {
					if (!visited[yy][xx] && map[yy][xx] == 0) {
						y = yy;
						x = xx;
						visited[y][x] = true;
						cnt++;
						turnCnt = 0;
					}
				} 
				continue;
			} else {
				turnLeft();
				turnLeft();
				yy = y + ds[d][0];
				xx = x + ds[d][1];
				if (yy > -1 && yy < n && x > -1 && xx < m && map[yy][xx] == 0) {
					y = yy;
					x = xx;
					turnCnt = 0;
					turnLeft();
					turnLeft();
					continue;
				} else break;
			}
		}
		
		return cnt;
	}
	
	private static void in() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(reader.readLine());
		y = Integer.parseInt(token.nextToken());
		x = Integer.parseInt(token.nextToken());
		d = Integer.parseInt(token.nextToken());
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; ++j)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
	}
	
	public static void main(String[] args) throws IOException {
		in();
		System.out.println(move());
		
	}

}
