package algorithm.spanningtree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Kruskal002 {
	
	private static class Edge implements Comparable<Edge> {
		int dist;
		int node1;
		int node2;
		
		public Edge(int dist, int node1, int node2) {
			this.dist = dist;
			this.node1 = node1;
			this.node2 = node2;
		}
		
		@Override
		public int compareTo(Edge o) {
			if (this.dist < o.dist)
				return -1;
			return 1;
		}
	}
	
	static int v, e;
	static int[] parent;
	static int[] rank;
	static List<Edge> edges;
	static int result = 0;
	
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		parent = new int[v];
		rank = new int[v];
		edges = new ArrayList<>();
		for (int i = 0; i < v; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		for (int i = 0; i < e; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(cost, a, b));
		}
		
		Collections.sort(edges);
		
		for (int i = 0; i < edges.size(); ++i) {
			int cost = edges.get(i).dist;
			int a = edges.get(i).node1;
			int b = edges.get(i).node2;
			if (findParent(a) != findParent(b)) {
				union(a, b);
				result += cost;
			}
		}
		
		System.out.println(result);
	}

}
