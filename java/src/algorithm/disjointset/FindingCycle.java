package algorithm.disjointset;

public class FindingCycle {
	
	public static void main(String[] args) {
		/*
		int[][] edges = 
			{
				{1,2},{1,4},{1,5},
				{2,6},{2,5},
				{3,5},{3,4}
			};
		*/
		
		int[][] edges2 = {{1,2},{2,3}};
		int n = 3;
		
		int[] parent = new int[n];
		int[] rank = new int[n];
		
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		int flag = 0;
		for (int[] e : edges2) {
			flag = union(e[0] - 1, e[1] - 1, parent, rank);
			if (flag == -1)
				break;
		}
		if (flag == -1) {
			System.out.println("Cycle");
		} else {
			System.out.println("No Cycle");
		}
	}
	
	private static int union(int a, int b, int[] parent, int[] rank) {
		a = findParent(a, parent);
		b = findParent(b, parent);
		if (parent[a] == parent[b]) return -1;
		
		if (rank[a] > rank[b]) {
			parent[b] = a;
		} else {
			parent[a] = b;
			if (rank[a] == rank[b])
				rank[b]++;
		}
		return 0;
	}
	
	private static int findParent(int a, int[] parent) {
		if (parent[a] != a)
			parent[a] = findParent(parent[a], parent);
		return parent[a];
	}

}
