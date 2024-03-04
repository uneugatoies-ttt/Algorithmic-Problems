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

public class Kruskal003 {
	
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
	
	private static int findParent(int x) {
		if (x != parent[x]) 
			parent[x] = findParent(parent[x]);
		return parent[x];
	}
	
	private static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if (rank[x] < rank[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}
	
	static int n, e;
	static int mnCost;
	static List<Edge> edgeList;
	static int[] parent;
	static int[] rank;
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		edgeList = new ArrayList<>();
		
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		for (int i = 0; i < e; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int dist = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(a, b, dist));
		}
		
		Collections.sort(edgeList);
		
		mnCost = 0;
		
		for (Edge edge : edgeList) {
			int cost = edge.dist;
			int a = edge.nodea;
			int b = edge.nodeb;
			
			if (findParent(a) != findParent(b)) {
				union(a, b);
				mnCost += cost;
			}
		}
		
		bw.write(String.valueOf(mnCost));
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
