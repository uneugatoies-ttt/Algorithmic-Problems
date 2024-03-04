package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11725 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			adj.add(new ArrayList<>());
		}
		StringTokenizer token;
		int a = 0, b = 0;
		for (int i = 0; i < n - 1; ++i) {
			token = new StringTokenizer(reader.readLine());
			a = Integer.parseInt(token.nextToken()) - 1;
			b = Integer.parseInt(token.nextToken()) - 1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		boolean[] visited = new boolean[n];
		int[] parents = new int[n];
		StringBuilder builder = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		visited[0] = true;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int next : adj.get(curr)) {
				if (!visited[next]) {
					q.add(next);
					parents[next] = curr + 1;
					visited[curr] = true;
				}
			}
		}
		
		for (int i = 1; i < n; ++i) {
			builder.append(parents[i]).append('\n');
		}
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
	
	
	
	/*
	private static final int MAGIC = Integer.MIN_VALUE + 99999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		
		List<List<Integer>> adj = new ArrayList<>();
		
		int[] heights = new int[n];
		Arrays.fill(heights, MAGIC);
		heights[0] = 0;
		for (int i = 0; i < n; ++i) {
			adj.add(new ArrayList<>());
		}
		StringTokenizer token;
		int a = 0, b = 0;
		for (int i = 0; i < n - 1; ++i) {
			token = new StringTokenizer(reader.readLine());
			a = Integer.parseInt(token.nextToken()) - 1;
			b = Integer.parseInt(token.nextToken()) - 1;
			adj.get(a).add(b);
			adj.get(b).add(a);
			
			if (heights[a] != MAGIC)
				heights[b] = heights[a] + 1;
			else if (heights[b] != MAGIC)
				heights[a] = heights[b] + 1;
		}
		
		for (int i = 0; i < n; ++i) {
			if (heights[i] == MAGIC) {
				for (int j : adj.get(i)) {
					if (heights[j] != MAGIC) {
						a = heights[j];
						break;
					}
				}
				for (int j : adj.get(i)) {
					if (heights[j] != a && heights[j] != MAGIC) {
						b = heights[j];
						break;
					}
				}
				heights[i] = (a + b) / 2;
			}
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < n; ++i) {
			for (int j : adj.get(i)) {
				if (heights[j] < heights[i]) {
					builder.append(j + 1).append('\n');
					break;
				}
			}
		}
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}*/

}
