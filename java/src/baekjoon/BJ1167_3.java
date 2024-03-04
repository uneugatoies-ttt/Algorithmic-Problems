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

public class BJ1167_3 {
	
	private static void dfs(int curr, boolean[] visited, List<Node>[] adj, int[] distance) {
		visited[curr] = true;
		
		for (Node next : adj[curr]) {
			if (!visited[next.index]) {
				distance[next.index] = distance[curr] + next.weight;
				dfs(next.index, visited, adj, distance);
			}
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		
		List<Node>[] adj = new ArrayList[n];
		
		for (int i = 0; i < n; ++i)
			adj[i] = new ArrayList<>();
		
		int from, to, wei;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			from = Integer.parseInt(token.nextToken()) - 1;
			while (true) {
				to = Integer.parseInt(token.nextToken()) - 1;
				if (to == -2) break;
				wei = Integer.parseInt(token.nextToken());
				adj[from].add(new Node(to, wei));
			}
		}
		
		boolean[] visited = new boolean[n];
		int[] distance = new int[n];
		Arrays.fill(distance, 0);
		dfs(0, visited, adj, distance);
		
		int mx = -999999;
		int termi = -1;
		
		for (int i = 0; i < n; ++i) {
			if (distance[i] > mx) {
				mx = distance[i];
				termi = i;
			}
		}
		
		Arrays.fill(distance, 0);
		Arrays.fill(visited, false);
		dfs(termi, visited, adj, distance);
		
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






	