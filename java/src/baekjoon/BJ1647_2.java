package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1647_2 {
	
	private static class Edge implements Comparable<Edge> {
		int dist;
		int nodea, nodeb;
		public Edge(int nodea, int nodeb, int dist) {
			this.nodea = nodea;
			this.nodeb = nodeb;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}
	
	static int n, m;
	static int[] parent;
	static int[] rank;
	static List<Edge> edges;
	static List<Edge> resultingTree;
	
	private static int findParent(int x) {
		if (x != parent[x])
			parent[x] = findParent(parent[x]);
		return parent[x];
	}
	
	private static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if (rank[x] > rank[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		rank = new int[n];
		edges = new ArrayList<>();
		resultingTree = new ArrayList<>();
		
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b, cost));
		}
		
		Collections.sort(edges);
		
		int result = 0;
		for (Edge edge : edges) {
			int a = edge.nodea;
			int b = edge.nodeb;
			int cost = edge.dist;
			
			if (findParent(a) == findParent(b)) continue;
			
			union(a, b);
			
			result += cost;
			resultingTree.add(edge);
		}
		
		int mx = Integer.MIN_VALUE;
		
		for (Edge edge : resultingTree) {
			mx = Math.max(edge.dist, mx);
		}
		
		System.out.println(result - mx);
	}

}
