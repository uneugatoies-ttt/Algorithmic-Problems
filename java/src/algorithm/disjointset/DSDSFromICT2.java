package algorithm.disjointset;

import java.io.IOException;
import java.util.Scanner;

public class DSDSFromICT2 {
	
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
		
		if (rank[x] > rank[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		parent = new int[v];
		rank = new int[v];
		
		for (int i = 0; i < v; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		boolean cycle = false;
		
		for (int i = 0; i < e; ++i) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			if (findParent(a) == findParent(b)) {
				cycle = true;
				break;
			} else {
				unionByRank(a, b);
			}
		}
		
		if (cycle)
			System.out.println("A cycle has been detected");
		else 
			System.out.println("There is no cycle in the graph");
	}
	
}
