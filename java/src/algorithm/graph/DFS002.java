package algorithm.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class DFS002 {
	
	private static List<List<Integer>> adj;
	
	/*
	private static void dfsInit(int start, int nodes) {
		List<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < nodes; ++i)
			visited.add(false);
		dfs(start, visited);
	}
	
	private static void dfs(int curr, List<Boolean> visited) {
		visited.set(curr, true);
		System.out.println(curr + " ");
		for (int i = 0; i < adj.get(curr).size(); ++i) {
			int next = adj.get(curr).get(i);
			if (!visited.get(next))
				dfs(next, visited);
		}
	}*/
	
	
	public static void dfsInit(int start, int vertices) {
		boolean[] visited = new boolean[vertices];
		dfs(start, visited);
	}
	
	private static void dfs(int curr, boolean[] visited) {
		visited[curr] = true;
		System.out.print(curr + " ");
		
		for (int nei : adj.get(curr)) {
			if (!visited[nei])
				dfs(nei, visited);
		}
	}
	
	private static void addEdge(int v, int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);
	}

	public static void main(String[] args) {
		adj = new ArrayList<>();
		
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(0, 3);
		addEdge(1, 3);
		addEdge(2, 4);
		addEdge(3, 4);
		
		dfsInit(0, 5);
		
		
	}
	
}

class MyGraph {
	private List<List<Integer>> adj;
	private int nodeNum;
	
	public MyGraph(int nodeNum) {
		adj = new LinkedList<List<Integer>>();
	}
	
	public int size() {
		return nodeNum;
	}
	
	
	
	
}
