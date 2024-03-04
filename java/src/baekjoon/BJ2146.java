package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2146 {
	
	private static List<Map.Entry<Integer, Integer>> edges = new ArrayList<Map.Entry<Integer,Integer>>();
	private static int[][] ds = {{1,0},{0,1},{-1,0},{0,-1}};
	private static int[][] map = new int[100][100];
	private static int n;
	private static int yy, xx, ny, nx;
	private static int res = 10000;
	
	public static void calDist() {
		int temp;
		for (int i = 0; i < edges.size() - 1; ++i) {
			yy = edges.get(i).getKey();
			xx = edges.get(i).getValue();
			for (int j = i + 1; j < edges.size(); ++j) {
				ny = edges.get(j).getKey();
				nx = edges.get(j).getValue();
				if (map[yy][xx] != map[ny][nx]) {
					temp = Math.abs(yy - ny) + Math.abs(xx - nx) - 1;
					if (res > temp) res = temp;
				}
			}
		}
	}
	
	public static void label(int y, int x, int ind) {
		Queue<Map.Entry<Integer, Integer>> q = new ArrayDeque<>();
		q.add(new AbstractMap.SimpleImmutableEntry<>(y, x));
		boolean isEdge = false;
		while (!q.isEmpty()) {
			isEdge = false;
			yy = q.peek().getKey();
			xx = q.peek().getValue();
			q.poll();
			map[yy][xx] = ind;
			for (int i = 0; i < 4; ++i) {
				ny = yy + ds[i][0];
				nx = xx + ds[i][1];
				if (ny > -1 && ny < n && nx > -1 && nx < n && map[ny][nx] == 1) {
					map[ny][nx] = ind;
					q.add(new AbstractMap.SimpleImmutableEntry<>(ny, nx));
				}
				else if (ny > -1 && ny < n && nx > -1 && nx < n && map[ny][nx] == 0)
					isEdge = true;
			}
			if (isEdge) edges.add(new AbstractMap.SimpleImmutableEntry<>(yy, xx));
		}
	}
	
	public static void in() throws IOException {
		int label = 2;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		n = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
		
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				if (map[i][j] == 1)
					label(i, j, label++);
	}
	
	public static void main(String[] args) throws IOException {
		in();
		calDist();
		System.out.println(res);
	}
	
}
