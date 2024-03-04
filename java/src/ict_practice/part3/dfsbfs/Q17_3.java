package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


// Approach given by the textbook
public class Q17_3 {
	
	private static int n, k;
	private static int s, x, y;
	private static int[][] virus;
	
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	private static List<Virus> list;
	
	private static void solve() throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		
		virus = new int[n][n];
		list = new ArrayList<>();
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j) {
				virus[i][j] = Integer.parseInt(token.nextToken());
				if (virus[i][j] > 0)
					list.add(new Virus(i, j, virus[i][j], 0));
			}
		}
		
		Collections.sort(list);
		
		token = new StringTokenizer(reader.readLine());
		s = Integer.parseInt(token.nextToken());
		x = Integer.parseInt(token.nextToken()) - 1;
		y = Integer.parseInt(token.nextToken()) - 1;
		
		int result = bfs();
		
		System.out.println(result > 0 ? result : 0);
	}
	
	public static int bfs() {
		Queue<Virus> q = new ArrayDeque<>();
		boolean[][] discovered = new boolean[n][n];
		for (Virus v : list) {
			q.add(v);
			discovered[v.y][v.x] = true; 
		}
		
		while (!q.isEmpty()) {
			Virus temp = q.poll();
			if (temp.x == y && temp.y == x) {
				if (temp.time <= s)
					return temp.type;
				else 
					break;
			}
			
			if (temp.time > s)
				break;
			
			for (int i = 0; i < 4; ++i) {
				int ny = temp.y + dir[i][0];
				int nx = temp.x + dir[i][1];
				
				if (ny >= n || ny < 0 || nx >= n || nx < 0 || discovered[ny][nx])
					continue;
				
				discovered[ny][nx] = true;
				virus[ny][nx] = temp.type;
				q.add(new Virus(ny, nx, temp.type, temp.time + 1));
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
	static class Virus implements Comparable<Virus> {
		int y;
		int x;
		int type;
		int time;
		
		public Virus(int y, int x, int type, int time) {
			this.y = y;
			this.x = x;
			this.type = type;
			this.time = time;
		}
		
		
		@Override
		public int compareTo(Virus o) {
			return this.type - o.type;
		}
	}
	
}

