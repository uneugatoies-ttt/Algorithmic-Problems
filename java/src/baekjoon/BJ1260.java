package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// correct answer:
//		After I modified the 'visited' as a list from an array,
//		I could pass the judge. But I'm not particularly sure
//		on what change does that make.
public class BJ1260 {
	private static List<List<Integer>> adj = new ArrayList<>();
	
	private static void dfsRecur(int curr, List<Boolean> visited) {
		visited.set(curr, true);
		System.out.print(curr + 1);
		System.out.print(" ");
		for (int i = 0; i < adj.get(curr).size(); ++i) {
			int next = adj.get(curr).get(i);
			if (!visited.get(next))
				dfsRecur(next, visited);
		}
	}
	
	private static void dfs(int start, int nodes) {
		List<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < nodes; ++i)
			visited.add(false);
		dfsRecur(start, visited);
	}
	
	private static void bfs(int start, int nodes) {
		List<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < nodes; ++i)
			visited.add(false);
		Queue<Integer> vertexQueue = new ArrayDeque<>();
		visited.set(start, true);
		vertexQueue.add(start);
		while (!vertexQueue.isEmpty()) {
			int curr = vertexQueue.poll();
			System.out.print(curr + 1);
			System.out.print(" ");
			for (int neighbor : adj.get(curr)) {
				if (!visited.get(neighbor)) {
					visited.set(neighbor, true);
					vertexQueue.add(neighbor);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		token = new StringTokenizer(reader.readLine());
		int nodes = Integer.parseInt(token.nextToken());
		int edges = Integer.parseInt(token.nextToken());
		int start = Integer.parseInt(token.nextToken());
		for (int i = 0; i < nodes; ++i) {
			List<Integer> oneRow = new ArrayList<>();
			adj.add(oneRow);
		}
		int node1, node2;
		for (int i = 0; i < edges; ++i) {
			token = new StringTokenizer(reader.readLine());
			node1 = Integer.parseInt(token.nextToken());
			node2 = Integer.parseInt(token.nextToken());
			adj.get(node1 - 1).add(node2 - 1);
			adj.get(node2 - 1).add(node1 - 1);
		}
		for (int i = 0; i < adj.size(); ++i) {
			Collections.sort(adj.get(i));
		}
		
		dfs(start - 1, nodes);
		System.out.println();
		bfs(start - 1, nodes);
		
		reader.close();
	}
}


// somehow failed attempt
/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1260 {
	private static List<List<Integer>> adj = new ArrayList<>();
	private static int[] result;
	
	private static void dfsRecur(int curr, boolean[] visited, int ind) {
		visited[curr] = true;
		result[ind] = curr + 1;
		for (int i = 0; i < adj.get(curr).size(); ++i) {
			int next = adj.get(curr).get(i);
			if (!visited[next])
				dfsRecur(next, visited, ind + 1);
		}
	}
	
	private static void dfs(int start, int nodes) {
		boolean[] visited = new boolean[nodes];
		for (int i = 0; i < nodes; ++i)
			visited[i] = false;
		dfsRecur(start, visited, 0);
	}
	
	private static void bfs(int start, int nodes) {
		int ind = nodes;
		boolean[] visited = new boolean[nodes];
		for (int i = 0; i < nodes; ++i)
			visited[i] = false;
		Queue<Integer> vertexQueue = new ArrayDeque<>();
		
		visited[start] = true;
		vertexQueue.add(start);
		
		while (!vertexQueue.isEmpty()) {
			int curr = vertexQueue.poll();
			result[ind] = curr + 1;
			ind++;
			
			for (int neighbor : adj.get(curr)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					vertexQueue.add(neighbor);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		StringTokenizer token = null;
		token = new StringTokenizer(reader.readLine());
		int nodes = Integer.parseInt(token.nextToken());
		int edges = Integer.parseInt(token.nextToken());
		int start = Integer.parseInt(token.nextToken());
		for (int i = 0; i < nodes; ++i) {
			List<Integer> oneRow = new ArrayList<>();
			adj.add(oneRow);
		}
		int node1, node2;
		for (int i = 0; i < edges; ++i) {
			token = new StringTokenizer(reader.readLine());
			node1 = Integer.parseInt(token.nextToken());
			node2 = Integer.parseInt(token.nextToken());
			adj.get(node1 - 1).add(node2 - 1);
			adj.get(node2 - 1).add(node1 - 1);
		}
		for (int i = 0; i < adj.size(); ++i) {
			Collections.sort(adj.get(i));
		}
		
		result = new int[nodes * 2];
		dfs(start - 1, nodes);
		bfs(start - 1, nodes);
		
		for (int i = 0; i < nodes; ++i) {
			if (result[i] == 0) continue;
			builder.append(result[i]).append(" ");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append('\n');
		for (int i = nodes; i < (nodes * 2); ++i) {
			if (result[i] == 0) continue;
			builder.append(result[i]).append(" ");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append('\n');
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}*/