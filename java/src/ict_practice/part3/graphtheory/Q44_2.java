package ict_practice.part3.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// not right
public class Q44_2 {
	
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
	private static Node[] nodes;
	private static List<Edge> edges;
	private static int[] parent;
	private static int[] rank;
	private static boolean[] visited;
	private static int res = 0;
	
	private static void formEdges(int curr) {
		visited[curr] = true;
		
		int dist = Integer.MAX_VALUE;
		int thei = -1;
		for (int i = 0; i < n; ++i) {
			if (visited[i] || i == curr) continue;
			
			int temp = Math.min(Math.abs(nodes[i].x - nodes[curr].x), 
					Math.min(
							Math.abs(nodes[i].y - nodes[curr].y),
							Math.abs(nodes[i].z - nodes[curr].z)
					));
			
			if (dist > temp) {
				dist = temp;
				thei = i;
			}
		}
		
		if (thei == -1) return;
		
		edges.add(new Edge(dist, curr, thei));
		res += dist;
		formEdges(thei);
	}
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		nodes = new Node[n];
		edges = new ArrayList<>();
		visited = new boolean[n];
	
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
			nodes[i] = new Node(x,y,z);
		}
		
		formEdges(0);
		
		
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
		System.out.println(res);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}