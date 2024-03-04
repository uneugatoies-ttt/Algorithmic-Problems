package ict_practice.part3.shortestpath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q39_3 {
	
	private static class Node implements Comparable<Node> {
		int y, x;
		int cost;
		public Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static final int INF = (int) 1e9;
	static int[][] distance = new int[125][125];
	static int[][] costs = new int[125][125];
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		int n;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; ++i) {
				Arrays.fill(distance[i], INF);
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; ++j)
					costs[i][j] = Integer.parseInt(st.nextToken());
			}
			
			distance[0][0] = costs[0][0];
			
			Queue<Node> q = new PriorityQueue<>();
			q.add(new Node(0, 0, costs[0][0]));
			
			while (!q.isEmpty()) {
				int y = q.peek().y;
				int x = q.peek().x;
				int cost = q.peek().cost;
				q.poll();
				
				if (cost > distance[y][x]) continue;
				
				for (int i = 0; i < 4; ++i) {
					int yy = y + dir[i][0];
					int xx = x + dir[i][1];
					
					if (yy >= n || yy < 0 || xx >= n || xx < 0) continue;
					
					int ncost = cost + costs[yy][xx];
					if (ncost < distance[yy][xx]) {
						distance[yy][xx] = ncost;
						q.add(new Node(yy, xx, ncost));
					}
				}
			}
			
			sb.append(String.valueOf(distance[n-1][n-1]) + '\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
