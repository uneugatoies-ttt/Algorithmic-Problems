package ict_practice.part3.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// I don't know whether this is throughly correct or not;
// it can pass the test case.
public class Q41 {
	
	static int n, m;
	static int[][] graph;
	static int[] parent, rank;
	static int[] sites;
	
	private static int findParent(int x) {
		if (x != parent[x])
			parent[x] = findParent(parent[x]);
		return parent[x];
	}
	
	private static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if (parent[x] == parent[y]) return;
		
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][n];
		parent = new int[n];
		rank = new int[n];
		sites = new int[m];
		
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j)
				graph[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; ++i) 
			sites[i] = Integer.parseInt(st.nextToken()) - 1;
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (graph[i][j] == 1)
					union(i, j);
			}
		}
		
		boolean flag = true;
		for (int i = 0; i < m - 1; ++i) {
			for (int j = i + 1; j < m; ++j) {
				if (findParent(sites[i]) != findParent(sites[j]))
					flag = false;
			}
		}
		
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
