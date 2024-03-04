package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1647 {
	
	private static int findParent(int x, int[] parent) {
		if (parent[x] != x)
			parent[x] = findParent(parent[x], parent);
		return parent[x];
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
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int v = Integer.parseInt(token.nextToken());
		int e = Integer.parseInt(token.nextToken());
		
		List<int[]> edges = new ArrayList<>();
		
		int a, b, wei;
		for (int i = 0; i < e; ++i) {
			token = new StringTokenizer(reader.readLine());
			edges.add(new int[3]);
			a = Integer.parseInt(token.nextToken()) - 1;
			b = Integer.parseInt(token.nextToken()) - 1;
			wei = Integer.parseInt(token.nextToken());
			edges.get(i)[0] = a;
			edges.get(i)[1] = b;
			edges.get(i)[2] = wei;
		}
		
		Collections.sort(edges, (a1, a2) -> (Integer.compare(a1[2], a2[2])));
		
		int[] parent = new int[v];
		int[] rank = new int[v];
		for (int i = 0; i < v; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		int res = 0;
		int mx = -99999;
		
		for (int[] edge : edges) {
			if (findParent(edge[0], parent) != findParent(edge[1], parent)) {
				union(edge[0], edge[1], parent, rank);
				res += edge[2];
				if (mx < edge[2])
					mx = edge[2];
			}
		}
		
		res -= mx;
		
		writer.write(String.valueOf(res));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
