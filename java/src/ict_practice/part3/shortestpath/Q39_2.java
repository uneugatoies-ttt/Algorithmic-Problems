package ict_practice.part3.shortestpath;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q39_2 {
	
	private static class Node implements Comparable<Node> {
		int y, x;
		int dist;
		
		public Node (int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			if (this.dist < other.dist)
				return -1;
			return 1;
		}
	}
	
	static final int INF = (int) 1e9;
	static int[][] graph = new int[125][125];
	static int[][] distance = new int[125][125];
	static int testCase, n;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		
		while (testCase-- > 0) {
			n = sc.nextInt();
			
			for (int i = 0; i < n; ++i)
				for (int j = 0; j < n; ++j)
					graph[i][j] = sc.nextInt();
			
			for (int i = 0; i < n; ++i)
				Arrays.fill(distance[i], INF);
			
			int y = 0, x = 0;
			
			Queue<Node> q = new PriorityQueue<>();
			q.offer(new Node(0, 0, graph[y][x]));
			distance[y][x] = graph[y][x];
			
			while (!q.isEmpty()) {
				Node node = q.poll();
				int dist = node.dist;
				y = node.y;
				x = node.x;
				if (distance[y][x] < dist) continue;
				for (int i = 0; i < 4; ++i) {
					int yy = y + dir[i][0];
					int xx = x + dir[i][1];
					if (yy < 0 || yy >= n || xx < 0 || xx >= n) continue;
					
					int cost = dist + graph[yy][xx];
					if (cost < distance[yy][xx]) {
						distance[yy][xx] = cost;
						q.add(new Node(yy, xx, cost));
					}
				}
			}
			
			System.out.println(distance[n - 1][n - 1]);
		}
		
	}
	

}
