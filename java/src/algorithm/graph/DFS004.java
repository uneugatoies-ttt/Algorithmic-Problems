package algorithm.graph;

import java.util.List;

public class DFS004 {
	private static List<Integer>[] adj;
	private static boolean[] visited;
	
	private static void dfs(int curr) {
		visited[curr] = true;
		System.out.print(curr + " ");
		for (int next : adj[curr])
			if (!visited[next])
				dfs(next);
	}
	
	private static void dfsInit() {
		for (int i = 0; i < adj.length; ++i) {
			if (!visited[i])
				dfs(i);
		}
	}
	
	public static void main(String[] args) {
		int sz = 10;
		
		adj = new List[sz];
		visited = new boolean[sz];
		
		adj[0] = List.of(1, 6, 9);
		adj[1] = List.of(0, 8);
		adj[2] = List.of(5);
		adj[3] = List.of(5);
		adj[4] = List.of(5, 8);
		adj[5] = List.of(2, 3, 4, 7);
		adj[6] = List.of(0);
		adj[7] = List.of(5);
		adj[8] = List.of(1, 4);
		adj[9] = List.of(0);
		
		dfsInit();
		System.out.println();
	}
	
}

/*
public class DFS004 {

	private static boolean[] visited;
	
	private static void dfs(int curr, List<Integer> res, List<Integer>[] adj) {
		visited[curr] = true;
		res.add(curr);
		for (int next : adj[curr]) {
			if (!visited[next])
				dfs(next, res, adj);
		}
	}
	
	private static void dfsInit(List<Integer> res, List<Integer>[] adj) {
		for (int i = 0; i < adj.length; ++i) {
			if (!visited[i])
				dfs(i, res, adj);
		}
	}
	
	public static void main(String[] args) {
		int sz = 10;
		
		List<Integer>[] adj = new List[sz];
		visited = new boolean[sz];
		
		adj[0] = List.of(1, 6, 9);
		adj[1] = List.of(0, 8);
		adj[2] = List.of(5);
		adj[3] = List.of(5);
		adj[4] = List.of(5, 8);
		adj[5] = List.of(2, 3, 4, 7);
		adj[6] = List.of(0);
		adj[7] = List.of(5);
		adj[8] = List.of(1, 4);
		adj[9] = List.of(0);
		
		List<Integer> res = new ArrayList<>();
		
		dfsInit(res, adj);
		
		System.out.println(res.toString());

	}

}*/
