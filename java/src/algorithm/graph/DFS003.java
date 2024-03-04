package algorithm.graph;

import java.util.List;

public class DFS003 {
	
	private static List<List<Integer>> adj;
	
	private static void dfsInit(int start) {
		boolean[] visited = new boolean[adj.size()];
		dfs(start, visited);
	}
	
	private static void dfs(int curr, boolean[] visited) {
		System.out.print(curr + " ");
		visited[curr] = true;
		for (int next : adj.get(curr))
			if (!visited[next])
				dfs(next, visited);
	}
	
	public static void main(String[] args) {
		
	}

}
