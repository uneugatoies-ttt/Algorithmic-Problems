package ict_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Chapter10Problem1 {
	
	private static void union(int x, int y, int[] parent, int[] rank) {
		x = findParent(x, parent);
		y = findParent(y, parent);
		if (parent[x] == parent[y]) return;
		
		if (rank[x] > rank[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}
	
	private static int findParent(int x, int[] parent) {
		if (parent[x] != x)
			parent[x] = findParent(parent[x], parent);
		return parent[x];
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder(); 
		
		int n = Integer.parseInt(token.nextToken()) + 1;
		int m = Integer.parseInt(token.nextToken());
		
		int[] parent = new int[n];
		int[] rank = new int[n];
		
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		int x, a, b;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(reader.readLine());
			x = Integer.parseInt(token.nextToken());
			a = Integer.parseInt(token.nextToken());
			b = Integer.parseInt(token.nextToken());
			if (x == 0)
				union(a, b, parent, rank);
			else {
				if (findParent(a, parent) == findParent(b, parent))
					builder.append("YES").append('\n');
				else
					builder.append("NO").append('\n');
			}
		}
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}

/* This is okay, but it seems that there's no need to set a separate
method "checkParent"; you can just use findParent() instead. */

/* If you think about it more, then it is obvious that you don't need to 
define a separate method: whether it assigns something to something or not,
findParent() and checkParent() return the root of the tree that the node "x"
is included. Assignment doesn't change anything with that functionality. */

/*
public class Chapter10Problem1 {
	
	private static int checkParent(int x, int[] parent) {
		if (parent[x] != x)
			return checkParent(parent[x], parent);
		return x;
	}
	
	private static void union(int x, int y, int[] parent, int[] rank) {
		x = findParent(x, parent);
		y = findParent(y, parent);
		if (parent[x] == parent[y]) return;
		
		if (rank[x] > rank[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}
	
	private static int findParent(int x, int[] parent) {
		if (parent[x] != x)
			parent[x] = findParent(parent[x], parent);
		return parent[x];
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder(); 
		
		int n = Integer.parseInt(token.nextToken()) + 1;
		int m = Integer.parseInt(token.nextToken());
		
		int[] parent = new int[n];
		int[] rank = new int[n];
		
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		int x, a, b;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(reader.readLine());
			x = Integer.parseInt(token.nextToken());
			a = Integer.parseInt(token.nextToken());
			b = Integer.parseInt(token.nextToken());
			if (x == 0)
				union(a, b, parent, rank);
			else {
				if (checkParent(a, parent) == checkParent(b, parent))
					builder.append("YES").append('\n');
				else
					builder.append("NO").append('\n');
			}
		}
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}*/
