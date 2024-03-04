package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _547NumberOfProvinces_2 {
	
	public static void main(String[] args) {
		_547Solution s = new _547Solution();
		
		int[][] isc = {{1,1,0},{1,1,0},{0,0,1}};
		
		//int[][] isc = {{1,0,0},{0,1,0},{0,0,1}};
		
		System.out.println(s.findCircleNum(isc));
	}
	
}

class _547Solution2 {
	public int findCircleNum(int[][] isConnected) {
		int numberofnodes = isConnected.length;
		int[] parent = new int[numberofnodes];
		int[] rank = new int[numberofnodes];
		
		for (int i = 0; i < numberofnodes; ++i) {
			parent[i] = i;
			rank[i] = i;
		}
		
		for (int i = 0; i < numberofnodes; ++i) {
			for (int j = 0; j < numberofnodes; ++j) {
				if (isConnected[i][j] == 1)
					union(i, j, parent, rank);
			}
		}
		
		Map<Integer, List<Integer>> connected = new HashMap<>();
		int root;
		for (int i = 0; i < numberofnodes; ++i) {
			root = findParent(i, parent);
			connected.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
		}
		
		return (new ArrayList<>(connected.values())).size();
	}
	
	// method for finding the connected 
	// component that the "i"th node belongs to
	private int findParent(int i, int[] parent) {
		if (parent[i] != i)
			parent[i] = findParent(parent[i], parent);
		return parent[i];
	}
	
	// to merge the connected components of nodes a and b
	private void union(int a, int b, int[] parent, int[] rank) {
		a = findParent(a, parent);
		b = findParent(b, parent);
		
		if (parent[a] == parent[b]) return;
		
		if (rank[a] > rank[b]) {
			parent[b] = a;
		} else {
			parent[a] = b;
			if (rank[a] == rank[b])
				rank[b]++;
		}
	}

}