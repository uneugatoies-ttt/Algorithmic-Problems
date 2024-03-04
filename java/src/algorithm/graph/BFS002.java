package algorithm.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS002 {
	private static List<List<Integer>> adj;
	private static boolean[] visited;
	
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");
			for (int next : adj.get(curr)) {
				if (!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
	
	private static void addEdge(int v, int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);
	}
	
	public static void main(String[] args) {
		adj = new ArrayList<List<Integer>>();
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		adj.add(new ArrayList<>());
		
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(0, 3);
		addEdge(0, 4);
		addEdge(1, 5);
		addEdge(2, 3);
		addEdge(2, 8);
		addEdge(2, 5);
		addEdge(3, 4);
		addEdge(6, 7);
		addEdge(6, 8);
		
		visited = new boolean[9];
		
		bfs(0);
		
		System.out.println();
	}
}
