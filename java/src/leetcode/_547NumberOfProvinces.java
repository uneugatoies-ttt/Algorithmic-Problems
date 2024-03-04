package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _547NumberOfProvinces {
	
	public static void main(String[] args) {
		_547Solution s = new _547Solution();
		
		//int[][] isc = {{1,1,0},{1,1,0},{0,0,1}};
		
		int[][] isc = {{1,0,0},{0,1,0},{0,0,1}};
		
		System.out.println(s.findCircleNum(isc));
	}
	
	
}

class _547Solution {
	public int findCircleNum(int[][] isConnected) {
		_547DSDSOperations oper = new _547DSDSOperations();
		List<_547DSDSNode> nodes = new ArrayList<>();
		for (int i = 0; i < isConnected.length; ++i)
			nodes.add(new _547DSDSNode(i));
		
		for (int i = 0; i < isConnected.length; ++i) {
			for (int j = 0; j < isConnected[i].length; ++j) {
				if (isConnected[i][j] == 1)
					nodes.get(i).adj.add(nodes.get(j));
			}
		}
		
		for (_547DSDSNode node : nodes) {
			for (_547DSDSNode nei : node.adj)
				oper.union(nei, node);
		}
		
		Map<_547DSDSNode, List<_547DSDSNode>> connected = new HashMap<>();
		_547DSDSNode root;
		for (_547DSDSNode node : nodes) {
			root = oper.findSet(node);
			connected.computeIfAbsent(root, k -> new ArrayList<>()).add(node);
		}
		
		return (new ArrayList<>(connected.values())).size();
	}
}

class _547DSDSNode {
	_547DSDSNode parent;
	List<_547DSDSNode> adj;
	int rank;
	int data;
	public _547DSDSNode(int data) {
		this.parent = this;
		this.rank = 0;
		this.data = data;
		this.adj = new ArrayList<>();
	}
}

class _547DSDSOperations {
	public void makeSet(_547DSDSNode x) {
		x.parent = x;
		x.rank = 0;
	}
	public void union(_547DSDSNode x, _547DSDSNode y) {
		link(findSet(x), findSet(y));
	}
	private void link(_547DSDSNode x, _547DSDSNode y) {
		if (x.rank > y.rank) {
			y.parent = x;
		} else {
			x.parent = y;
			if (x.rank == y.rank)
				y.rank++;
		}
	}
	public _547DSDSNode findSet(_547DSDSNode x) {
		if (x.parent != x)
			x.parent = findSet(x.parent);
		return x.parent;
	}
}