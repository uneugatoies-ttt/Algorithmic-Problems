package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1967 {
	
	private static void dfs(int curr, boolean[] visited, int[] distance, List<Node>[] adj) {
		visited[curr] = true;
		
		for (Node next : adj[curr]) {
			if (!visited[next.index]) {
				distance[next.index] = distance[curr] + next.weight;
				dfs(next.index, visited, distance, adj);
			}
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(reader.readLine());
		
		List<Node>[] adj = new ArrayList[n];
		for (int i = 0; i < n; ++i)
			adj[i] = new ArrayList<>();
		
		StringTokenizer token;
		int parent, child, weight;
		for (int i = 0; i < n - 1; ++i) {
			token = new StringTokenizer(reader.readLine());
			parent = Integer.parseInt(token.nextToken()) - 1;
			child = Integer.parseInt(token.nextToken()) - 1;
			weight = Integer.parseInt(token.nextToken());
			adj[parent].add(new Node(child, weight));
			adj[child].add(new Node(parent, weight));
		}
		
		boolean[] visited = new boolean[n];
		int[] distance = new int[n];
		Arrays.fill(distance, 0);
		dfs(0, visited, distance, adj);
		
		int mx = -999999;
		int termi = -1;
		
		for (int i = 0; i < n; ++i) {
			if (mx < distance[i]) {
				mx = distance[i];
				termi = i;
			}
		}
		
		Arrays.fill(visited, false);
		Arrays.fill(distance, 0);
		
		dfs(termi, visited, distance, adj);
		
		writer.write(String.valueOf(Arrays.stream(distance).max().orElseThrow()));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

	private static class Node {
		int index;
		int weight;
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}
	
}
