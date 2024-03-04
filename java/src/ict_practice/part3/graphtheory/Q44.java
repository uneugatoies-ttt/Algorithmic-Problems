package ict_practice.part3.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Exceeded the memory constraint
public class Q44 {
	
	private static class Edge implements Comparable<Edge> {
		int dist;
		int nodea, nodeb;
		
		public Edge(int dist, int nodea, int nodeb) {
			this.dist = dist;
			this.nodea = nodea;
			this.nodeb = nodeb;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}
	
	private static class Node {
		int x, y, z;
		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
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
	
	private static int n;
	private static List<Node> nodes;
	private static List<Edge> edges;
	private static int[] parent;
	private static int[] rank;
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		nodes = new ArrayList<>();
		edges = new ArrayList<>();
	
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		StringTokenizer st;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			nodes.add(new Node(x, y, z));
		}
		
		Node nodei, nodej;
		for (int i = 0; i < n - 1; ++i) {
			nodei = nodes.get(i);
			for (int j = i + 1; j < n; ++j) {
				nodej = nodes.get(j);
				int dist = Math.min(Math.abs(nodei.x - nodej.y), Math.min(Math.abs(nodei.y - nodej.y), Math.abs(nodei.z - nodej.z)));
				edges.add(new Edge(dist, i, j));
			}
		}
		
		Collections.sort(edges);
		int result = 0;
		for (int i = 0; i < edges.size(); ++i) {
			int cost = edges.get(i).dist;
			int a = edges.get(i).nodea;
			int b = edges.get(i).nodeb;
			if (findParent(a) != findParent(b)) {
				union(a, b);
				result += cost;
			}
		}
		
		System.out.println(result);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
