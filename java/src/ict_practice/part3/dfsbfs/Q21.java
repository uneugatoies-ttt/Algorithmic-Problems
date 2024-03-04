package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q21 {
	
	private static int n, l, r;
	private static int[][] map;
	
	private static List<List<Pos>> mig;
	
	private static int res = 0;
	
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	private static boolean[][] dis;
	
	private static boolean bfs() {
		for (int i = 0; i < n; ++i)
			Arrays.fill(dis[i], false);
		mig.clear();
		Queue<Pos> q = new ArrayDeque<>();
		
		for (int ii = 0; ii < n; ++ii) {
			for (int jj = 0; jj < n; ++jj) {
				if (dis[ii][jj]) continue;

				mig.add(new ArrayList<>());
				
				dis[ii][jj] = true;
				Pos initp = new Pos(ii, jj);
				mig.get(mig.size()-1).add(initp);
				q.add(initp);
				
				while (!q.isEmpty()) {
					int yy = q.peek().y;
					int xx = q.peek().x;
					q.poll();
					
					for (int i = 0; i < 4; ++i) {
						int ny = yy + dir[i][0];
						int nx = xx + dir[i][1];
						
						if (ny < 0 || ny >= n || nx < 0 || nx >= n || dis[ny][nx])
							continue;
						
						if (Math.abs(map[yy][xx]-map[ny][nx]) > r || Math.abs(map[yy][xx]-map[ny][nx]) < l)
							continue;
						
						dis[ny][nx] = true;
						Pos p = new Pos(ny, nx);
						mig.get(mig.size()-1).add(p);
						q.add(p);
					}
				}
				
				if (mig.get(mig.size() - 1).size() == 1)
					mig.remove(mig.size() - 1);
			}
		}
		
		if (mig.isEmpty())
			return false;
		else
			return true;
	}
	
	private static void search() {
		mig = new ArrayList<>();
		
		while (bfs()) {
			++res;

			for (List<Pos> m : mig)
			{
				int population = 0;
				
				for (Pos p : m)
					population += map[p.y][p.x];
				
				population /= m.size();
				
				for (Pos p : m)
					map[p.y][p.x] = population; 
			}
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(token.nextToken());
		l = Integer.parseInt(token.nextToken());
		r = Integer.parseInt(token.nextToken());
		map = new int[n][n];
		dis = new boolean[n][n];
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
		
		search();
		
		System.out.println(res);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
	private static class Pos {
		int y; int x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
