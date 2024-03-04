package ict_practice.part3.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q44_4 {
	
	private static class Edge implements Comparable<Edge> {
	    int distance;
	    int nodeA;
	    int nodeB;

	    public Edge(int distance, int nodeA, int nodeB) {
	        this.distance = distance;
	        this.nodeA = nodeA;
	        this.nodeB = nodeB;
	    }

	    @Override
	    public int compareTo(Edge other) {
	        if (this.distance < other.distance) {
	            return -1;
	        }
	        return 1;
	    }
	}
	
	// 
	private static class Projection implements Comparable<Projection> {
		int xyz;
		int index;
		public Projection(int xyz, int index) {
			this.xyz = xyz;
			this.index = index;
		}
		
		@Override
		public int compareTo(Projection o) {
			if (this.xyz == o.xyz)
				return Integer.compare(this.index, o.index);
			return Integer.compare(this.xyz, o.xyz);
		}
	}
	
	private static int n;
	private static int[] parent;
	private static int[] rank;
	private static List<Edge> edges = new ArrayList<>();
	private static int result = 0;
	
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
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		parent = new int[n];
		rank = new int[n];
		
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		List<Projection> x = new ArrayList<>();
		List<Projection> y = new ArrayList<>();
		List<Projection> z = new ArrayList<>();
		
		StringTokenizer st;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			x.add(new Projection(a, i));
			y.add(new Projection(b, i));
			z.add(new Projection(c, i));
		}
		
		Collections.sort(x);
		Collections.sort(y);
		Collections.sort(z);
		
		for (int i = 0; i < n - 1; ++i) {
			edges.add(new Edge(x.get(i + 1).xyz - x.get(i).xyz, x.get(i).index, x.get(i + 1).index));
			edges.add(new Edge(y.get(i + 1).xyz - y.get(i).xyz, y.get(i).index, y.get(i + 1).index));
			edges.add(new Edge(z.get(i + 1).xyz - z.get(i).xyz, z.get(i).index, z.get(i + 1).index));
		}
		
		Collections.sort(edges);
		
		for (int i = 0; i < edges.size(); ++i) {
			int cost = edges.get(i).distance;
			int a = edges.get(i).nodeA;
			int b = edges.get(i).nodeB;
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
