package ict_practice.part3.shortestpath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q39 {
	private static final int INF = (int) 1e9;
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	private static void dijkstra(List<List<Node>> graph, int[] distance, int n) {
		Queue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0));
		
		Arrays.fill(distance, INF);
		distance[0] = graph.get(1).get(0).dist;
		
		while (!q.isEmpty()) {
			int curr = q.peek().ind;
			int dist = q.peek().dist;
			q.poll();
			
			if (distance[curr] < dist) continue;
			
			for (Node next : graph.get(curr)) {
				int cost = distance[curr] + next.dist;
				if (cost < distance[next.ind]) {
					distance[next.ind] = cost;
					q.add(new Node(next.ind, cost));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		int n; StringTokenizer st;
		List<List<Node>> graph;
		int[] distance;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			graph = new ArrayList<>();
			distance = new int[n * n];
			
			
			for (int i = 0; i < n*n; ++i)
				graph.add(new ArrayList<>());
			
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; ++j) {
					int cost = Integer.parseInt(st.nextToken());
					for (int k = 0; k < 4; ++k) {
						int yy = i + dir[k][0];
						int xx = j + dir[k][1];
						if (yy >= n || yy < 0 || xx >= n || xx < 0) continue;
						graph.get(yy * n + xx).add(new Node(i*n+j, cost));
					}
				}
			}
			
			dijkstra(graph, distance, n);
			
			sb.append(String.valueOf(distance[n * n - 1]) + '\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static class Node implements Comparable<Node> {
		
		int ind;
		int dist;
		
		public Node(int ind, int dist) {
			this.ind = ind;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.dist, other.dist);
		}
		
	}
	
}


/*
public class Q39 {
	
	private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		int n; StringTokenizer st;
		Cell[][] space;
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			space = new Cell[n][n];
			
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; ++j) {
					space[i][j] = new Cell();
					for (int k = 0; k < 4; ++k) {
						int yy = i + dir[k][0];
						int xx = j + dir[k][1];
						
						if (yy >= n || yy < 0 || xx >= n || xx < 0) continue;
						space[i][j].nesw[k] = 
					}
					
				}
			}
		}
		
	}
	
	private static class Cell {
		int[] nesw;
		public Cell() {
			this.nesw = new int[4];
		}
	}

}
*/