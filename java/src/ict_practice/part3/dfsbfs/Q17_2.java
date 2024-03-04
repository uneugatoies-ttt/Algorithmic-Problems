package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// More efficient approach
public class Q17_2 {
	
	private static int n, k;
	// "x" refers to the row number and "y" the column number
	private static int s, x, y;
	
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	private static int[][] tube;
	private static List<Virus> list;
	
	private static void search() {
		List<Virus> tempList = new ArrayList<>();
		for (int i = 0; i < s; ++i) 
		{
			tempList.clear();
			for (Virus v : list)
			{
				int yy = v.y;
				int xx = v.x;
				
				for (int j = 0; j < 4; ++j)
				{
					int ny = yy + dir[j][0];
					int nx = xx + dir[j][1];
					if (ny >= n || ny < 0 || nx >= n || nx < 0 || tube[ny][nx] != 0)
						continue;
					tempList.add(new Virus(ny, nx, v.type, v.time + 1));
					tube[ny][nx] = v.type;
				}
			}
			list.clear();
			list.addAll(tempList);
			Collections.sort(list);
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		tube = new int[n][n];
		list = new ArrayList<>();
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j) {
				tube[i][j] = Integer.parseInt(token.nextToken());
				if (tube[i][j] != 0)
					list.add(new Virus(i, j, tube[i][j], 0));
			}
		}
		
		token = new StringTokenizer(reader.readLine());
		s = Integer.parseInt(token.nextToken());
		x = Integer.parseInt(token.nextToken());
		y = Integer.parseInt(token.nextToken());
		
		Collections.sort(list);
		
		search();
		
		System.out.println(tube[x - 1][y - 1]);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
	public static class Virus implements Comparable<Virus> {
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
