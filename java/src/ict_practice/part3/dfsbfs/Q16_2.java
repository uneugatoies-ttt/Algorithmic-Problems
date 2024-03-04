package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16_2 {
	
	private static int n, m;
	private static int[][] map;
	private static List<Position> emptypos;
	private static List<Position> virus;
	
	private static List<List<Position>> combs;
	
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	private static int res = Integer.MIN_VALUE;
	
	private static void search(List<Position> pos) {
		for (int i = 0; i < 3; ++i)
			map[pos.get(i).y][pos.get(i).x] = 1;
		
		int[][] tempmap = new int[n][m];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j)
				tempmap[i][j] = map[i][j];
		}
		
		for (Position v : virus) {
			Queue<Position> q = new ArrayDeque<>();
			q.add(v);
		
			while (!q.isEmpty()) {
				int y = q.peek().y;
				int x = q.peek().x;
				q.poll();
				
				for (int i = 0; i < 4; ++i) {
					int yy = y + dir[i][0];
					int xx = x + dir[i][1];
					
					if (yy < 0 || yy >= n || xx < 0 || xx >= m ||
						tempmap[yy][xx] == 2 || tempmap[yy][xx] == 1
					)
					{
						continue;
					}
					
					tempmap[yy][xx] = 2;
					q.add(new Position(yy, xx));
				}
			}
		}
		
		int tempres = 0;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j)
				if (tempmap[i][j] == 0)
					tempres++;
		}
		
		res = Math.max(res, tempres);
		
		for (int i = 0; i < 3; ++i)
			map[pos.get(i).y][pos.get(i).x] = 0;
	}
	
	public static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		map = new int[n][m];
		emptypos = new ArrayList<>();
		combs = new ArrayList<>();
		virus = new ArrayList<>();
		
		for (int i = 0; i < n; ++i)
		{
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(token.nextToken());
				if (map[i][j] == 0)
					emptypos.add(new Position(i, j));
				else if (map[i][j] == 2)
					virus.add(new Position(i, j));
			}
		}
		
		Q16Comb comb = new Q16Comb(emptypos.size(), 3);
		
		comb.generateCombinations(emptypos, 0, 0, 0);
		
		combs = comb.res;
		
		for (List<Position> lp : combs)
			search(lp);
		
		System.out.println(res);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
}

class Q16Comb {
	int n;
	int r;
	int[] curr;
	List<List<Position>> res;
	
	public Q16Comb(int n, int r) {
		this.n = n;
		this.r = r;
		this.curr = new int[r];
		this.res = new ArrayList<>();
	}
	
	public void generateCombinations(List<Position> orig, int index, int depth, int target) {
		if (depth == r)
		{
			List<Position> temp = new ArrayList<>();
			for (int i = 0; i < r; ++i)
				temp.add(orig.get(curr[i]));
			res.add(temp);
			return;
		}
		
		if (target == n)
			return;
		
		curr[index] = target;
		
		generateCombinations(orig, index + 1, depth + 1, target + 1);
		generateCombinations(orig, index, depth, target + 1);
	}
	
}

class Position {
	int y;
	int x;
	
	public Position(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

