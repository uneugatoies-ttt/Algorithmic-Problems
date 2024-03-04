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

public class Kruskal001 {
	
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		List<int[]> loe = new ArrayList<>();
		int v = 7;
		int e = 9;
		StringTokenizer token;
		
		for (int i = 0; i < e; ++i) {
			token = new StringTokenizer(reader.readLine());
			loe.add(new int[3]);
			loe.get(i)[0] = Integer.parseInt(token.nextToken());
			loe.get(i)[1] = Integer.parseInt(token.nextToken());
			loe.get(i)[2] = Integer.parseInt(token.nextToken());
		}
		
		// How can you sort "loe" by the weight?
		Collections.sort(loe, (a1, a2) -> (Integer.compare(a1[2], a2[2])));
		
		for (int[] a : loe) {
			System.out.println(a[2]);
		}
	}*/
	
	private static int findParent(int x, int[] parent) {
		if (parent[x] != x) 
			parent[x] = findParent(parent[x], parent);
		return parent[x];
	}
	
	private static void union(int x, int y, int[] parent, int[] rank) {
		x = findParent(x, parent);
		y = findParent(y, parent);
		
		if (parent[x] == parent[y])
			return;
		
		if (rank[x] > rank[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		// [0] and [1] indicate two nodes that are connected.
		// [2] indicates the weight that this edge contains.
		List<int[]> edges = new ArrayList<>();
		
		int v = Integer.parseInt(token.nextToken());
		int e = Integer.parseInt(token.nextToken());
		
		for (int i = 0; i < e; ++i) {
			token = new StringTokenizer(reader.readLine());
			edges.add(new int[3]);
			edges.get(i)[0] = Integer.parseInt(token.nextToken()) - 1;
			edges.get(i)[1] = Integer.parseInt(token.nextToken()) - 1;
			edges.get(i)[2] = Integer.parseInt(token.nextToken());
		}
		
		Collections.sort(edges, (a1, a2) -> (Integer.compare(a1[2], a2[2])));
		
		int[] parent = new int[v];
		int[] rank = new int[v];
		
		for (int i = 0; i < v; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		int res = 0;
		for (int[] edge : edges) {
			if (findParent(edge[0], parent) != findParent(edge[1], parent)) {
				union(edge[0], edge[1], parent, rank);
				res += edge[2];
			}
		}
		
		System.out.println(res);
	}

}
