package algorithm.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologicalSort001 {
	
	private static List<Integer> topologicalSort(
			List<Integer>[] adj,
			int[] indegree,
			boolean[] visited
	) {
		List<Integer> result = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i = 0; i < adj.length; ++i) {
			if (indegree[i] == 0)
				q.add(i);
		}
		
		int curr;
		while (!q.isEmpty()) {
			curr = q.poll();
			result.add(curr + 1);
			visited[curr] = true;
			for (int next : adj[curr]) {
				indegree[next]--;
				if (indegree[next] == 0)
					q.add(next);
			}
		}
		
		for (int i = 0; i < adj.length; ++i)
			if (!visited[i])
				return null;
		
		return result;
	}
	
	private static void solveAndIo() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int v = Integer.parseInt(token.nextToken());
		int e = Integer.parseInt(token.nextToken());
		int[] indegree = new int[v];
		boolean[] visited = new boolean[v];
		List<Integer>[] adj = new ArrayList[v];
		
		/* initializing all elements with 0 and false in an integer
		and boolean array, but I did it anyway to make the initial
		value explicit. */
		Arrays.fill(indegree, 0);
		Arrays.fill(visited, false);
		
		/* Apprently, you cannot use "Arrays.fill(adj, new ArrayList<>())"
		to initialize "adj", since it would make every element in "adj"
		reference the same ArrayList object. */
		for (int i = 0; i < v; ++i)
			adj[i] = new ArrayList<>();
		
		int from, to;
		for (int i = 0; i < e; ++i) {
			token = new StringTokenizer(reader.readLine());
			from = Integer.parseInt(token.nextToken()) - 1;
			to = Integer.parseInt(token.nextToken()) - 1;
			adj[from].add(to);
			indegree[to]++;
		}
		
		List<Integer> res = topologicalSort(adj, indegree, visited);
		
		writer.write(res.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solveAndIo();
	}

}
