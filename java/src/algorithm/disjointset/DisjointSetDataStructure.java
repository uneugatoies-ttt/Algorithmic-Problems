package algorithm.disjointset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisjointSetDataStructure {
	
	public static List<List<DSDSNode>> findConnectedComponents(
			DSDSNode[][] edges,
			DSDSNode[] nodes
		) {
			DSDSOperationsWithHeuristics oper = new DSDSOperationsWithHeuristics();
			
			/*
			for (DSDSNode[] edge : edges) {
				
			}*/
			
			for (DSDSNode[] edge : edges) {
				oper.union(edge[0], edge[1]);
			}
			
			Map<DSDSNode, List<DSDSNode>> connectedComponentsMap = new HashMap<>();
			for (DSDSNode vertex : nodes) {
				DSDSNode root = oper.findSet(vertex);
				connectedComponentsMap
					.computeIfAbsent(
						root,
						k -> new ArrayList<>()).add(vertex);
			}
			
			return new ArrayList<>(connectedComponentsMap.values());
		}
		
		public static void main(String[] args) {
			DSDSNode node1 = new DSDSNode(1);
			DSDSNode node2 = new DSDSNode(2);
			DSDSNode node3 = new DSDSNode(3);
			
			DSDSNode node4 = new DSDSNode(4);
			DSDSNode node5 = new DSDSNode(5);
			
			DSDSNode node6 = new DSDSNode(6);
			DSDSNode node7 = new DSDSNode(7);
			
			DSDSNode[][] edges = {
					{node1, node2}, {node2, node3},
					{node4, node5},
					{node6, node7}
			};
			
			DSDSNode[] nodes = {node1, node2, node3, node4, node5, node6, node7};
			
			List<List<DSDSNode>> cc = findConnectedComponents(edges, nodes);
			
			System.out.println("Connected Components: ");
			for (List<DSDSNode> c : cc) {
				System.out.println(c);
			}
		}
		
	
}

class DSDSNode {
	int data;
	DSDSNode parent;
	int rank;
	public DSDSNode(int data) {
		this.data = data;
		this.parent = this;
		this.rank = 0;
	}
}

class DSDSOperationsWithHeuristics {
	public void makeSet(DSDSNode x) {
		x.parent = x;
		x.rank = 0;
	}
	public void union(DSDSNode x, DSDSNode y) {
		link(findSet(x), findSet(y));
	}
	public void link(DSDSNode x, DSDSNode y) {
		if (x.rank > y.rank) {
			y.parent = x;
		} else {
			x.parent = y;
			if (x.rank == y.rank)
				y.rank++;
		}
	}
	public DSDSNode findSet(DSDSNode x) {
		if (x.parent != x)
			x.parent = findSet(x.parent);
		return x.parent;
	}
}



