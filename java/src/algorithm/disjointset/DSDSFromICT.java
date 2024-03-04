package algorithm.disjointset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DSDSFromICT {
	
	static int v, e;
	static int[] parent;
	static int[] rank;
	
	private static int findParent(int x) {
		if (x != parent[x])
			parent[x] = findParent(parent[x]);
		return parent[x];
	}
	
	private static void unionByRank(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		if (parent[x] == parent[y]) return;
		
		if (rank[x] > rank[y]) {
			parent[y] = x;
		} else if (rank[x] < rank[y]){
			parent[x] = y;
		} else {
			if (x >= y) {
				parent[x] = y;
				rank[y]++;
			} else {
				parent[y] = x;
				rank[x]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		
		parent = new int[v];
		rank = new int[v];
		
		for (int i = 0; i < v; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		StringTokenizer st;
		for (int i = 0; i < e; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			unionByRank(a, b);
		}
		
		System.out.print("Sets in which each element is contained: ");
		for (int i = 0; i < v; ++i) {
			System.out.print(findParent(i) + " ");
		}
		System.out.println();
		
		System.out.print("The parent tables: ");
		for (int i = 0; i < v; ++i) {
			System.out.print(parent[i] + " ");
		}
		System.out.println();
		
	}

}
