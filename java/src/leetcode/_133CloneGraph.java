package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _133CloneGraph {
	
	
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class SolutionBFS {
	Node cloneGraph(Node node) {
		if (node == null) return null;
		
		Queue<Node> q = new LinkedList<>();
		Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
		
		q.add(node);
		adjList.put(node.val, new ArrayList<>());
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (Node nei : cur.neighbors) {
				adjList.get(cur.val).add(nei.val);
				if (adjList.get(nei.val) == null) {
					adjList.put(nei.val, new ArrayList<>());
					q.add(nei);
				}
			}
		}
		
		int count = adjList.size();
		List<Node> newNodes = new ArrayList<>();
		newNodes.add(new Node(0));
		
		for (int i = 1; i <= count; ++i)
			newNodes.add(new Node(i));
		
		for (int i = 1; i <= count; ++i)
			for (int nei : adjList.get(i))
				newNodes.get(i).neighbors.add(newNodes.get(nei));
		
		return newNodes.get(1);
	}
}

class SolutionBFS2 {
	public Node cloneGraph(Node node) {
		Map<Node, Node> map = new HashMap<>();
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(node);
		map.put(node, new Node(node.val, new ArrayList<>()));
		
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			for (Node nei : curr.neighbors) {
				if (!map.containsKey(nei)) {
					map.put(nei, new Node(nei.val, new ArrayList<>()));
					queue.offer(nei);
				}
				map.get(curr).neighbors.add(map.get(nei));
			}
		}
		
		return map.get(node);
	}
}

class SolutionDFS {
	Map<Node, Node> copies = new HashMap<>();
	
	public Node cloneGraph(Node node) {
		if (node == null) return null;
		
		if (!copies.containsKey(node)) {
			copies.put(node, new Node(node.val, new ArrayList<>()));
			for (Node nei : node.neighbors)
				copies.get(node).neighbors.add(cloneGraph(nei));
		}
		
		return copies.get(node);
	}
	
	/*
	public Node cloneGraph(Node node) {
		Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
		
		
		
		for (Node nei : node.neighbors) {
			
			if (!adj.containsKey(nei.val)) {
				adj.put(nei.val, new ArrayList<>());
				
			}
		}
		
	}*/
}










