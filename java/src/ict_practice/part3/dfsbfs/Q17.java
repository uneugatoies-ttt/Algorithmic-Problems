package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17 {
	private static int n, k;
	private static int s, x, y;
	
	private static Queue<VirusPosition>[] q;
	private static int[][] tube;
	
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	private static void search(List<VirusPosition> tempList) {
		for (int i = 0; i < k; ++i)
		{
			tempList.clear();
			int size = q[i].size();
			for (int j = 0; j < size; ++j)
				tempList.add(q[i].poll());
			
			for (VirusPosition v : tempList) 
			{
				int yy = v.y;
				int xx = v.x;
				for (int j = 0; j < 4; ++j)
				{
					int ny = yy + dir[j][0];
					int nx = xx + dir[j][1];
					
					if (ny >= n || ny < 0 || nx >= n || nx < 0 ||
						tube[ny][nx] != -1) continue;
					
					tube[ny][nx] = i;
					q[i].add(new VirusPosition(ny, nx));
				}
			}
		}
	}
	
	public static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		
		tube = new int[n][n];
		q = new ArrayDeque[k];
		
		for (int i = 0; i < k; ++i)
			q[i] = new ArrayDeque<VirusPosition>();
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j)
			{
				tube[i][j] = Integer.parseInt(token.nextToken()) - 1;
				if (tube[i][j] != -1)
					q[tube[i][j]].add(new VirusPosition(i, j));
			}
		}
		
		token = new StringTokenizer(reader.readLine());
		s = Integer.parseInt(token.nextToken());
		x = Integer.parseInt(token.nextToken());
		y = Integer.parseInt(token.nextToken());
		
		List<VirusPosition> tempList = new ArrayList<>();
		
		for (int i = 0; i < s; ++i) {
			search(tempList);
		}
		if (tube[x - 1][y - 1] == -1)
			System.out.println("0");
		else
			System.out.println(tube[x - 1][y - 1] + 1);
		
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
}

class VirusPosition {
	int y;
	int x;
	public VirusPosition(int y, int x) {
		this.y = y;
		this.x = x;
	}
}