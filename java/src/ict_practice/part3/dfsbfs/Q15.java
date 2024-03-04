package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.AbstractMap.SimpleImmutableEntry;

public class Q15 {
	
	private static int INF = Integer.MAX_VALUE;
	private static int n, m, k, x;
	private static List<List<Integer>> adj = new ArrayList<>();
	private static int[] distance;

	private static void bfs() {
		distance = new int[n];
		Arrays.fill(distance, INF);
		distance[x - 1] = 0;
		
		Queue<Entry<Integer, Integer>> q = 
			new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));	
			
		q.add(new SimpleImmutableEntry<>(x - 1, 0));
		
		while (!q.isEmpty()) {
			int curr = q.peek().getKey();
			int dist = q.peek().getValue();
			q.poll();
			
			if (dist > distance[curr]) continue;
			
			for (int next : adj.get(curr)) {
				int cost = dist + 1;
				if (cost < distance[next]) {
					distance[next] = cost;
					q.add(new SimpleImmutableEntry<>(next, cost));
				}
			}
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		x = Integer.parseInt(token.nextToken());
		
		for (int i = 0; i < n; ++i)
			adj.add(new ArrayList<>());
		
		int a, b;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(reader.readLine());
			a = Integer.parseInt(token.nextToken());
			b = Integer.parseInt(token.nextToken());
			adj.get(a - 1).add(b - 1);
		}
		
		bfs();
		
		boolean check = false;
		
		for (int i = 0; i < n; ++i) {
			if (distance[i] == k) {
				writer.write(String.valueOf(i + 1));
				writer.write('\n');
				check = true;
			}
		}
		
		if (!check) {
			writer.write("-1");
			writer.write('\n');
		}
		
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}








/* 
	-> It seems that something is wrong with this approach since it couldn't
	get through the test, but I really don't know what it is.
	
	-> The approach that is written in the class "Q15_2" has got passed the
	test; the only difference is that it uses "int[] distance" instead of 
	the value of the Queue's Entry and "visited".
 
 
*/
/*
public class Q15 {
	
	private static int n, m, k, x;
	private static List<List<Integer>> adj = new ArrayList<>();
	private static List<Integer> res = new ArrayList<>();
	private static boolean[] visited;

	private static void bfs() {
		Queue<Entry<Integer, Integer>> q = new ArrayDeque<>();
		
		q.add(new SimpleImmutableEntry<>(x - 1, 0));
		
		while (!q.isEmpty()) {
			int curr = q.peek().getKey();
			int dist = q.peek().getValue();
			q.poll();
			
			if (dist == k)
				res.add(curr + 1);
			
			for (int next : adj.get(curr)) {
				if (!visited[next]) {
					q.add(new SimpleImmutableEntry<>(next, dist + 1));
					visited[next] = true;
				}
			}
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		x = Integer.parseInt(token.nextToken());
		
		visited = new boolean[n];
		
		for (int i = 0; i < n; ++i)
			adj.add(new ArrayList<>());
		
		int a, b;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(reader.readLine());
			a = Integer.parseInt(token.nextToken());
			b = Integer.parseInt(token.nextToken());
			adj.get(a - 1).add(b - 1);
		}
		
		bfs();
		
		if (res.size() == 0) {
			writer.write("-1\n");
		} else {
			Collections.sort(res);
			for (int i : res) {
				writer.write(String.valueOf(i));
				writer.write('\n');
			}
		}
		
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}

*/

/*
private static void dfs(int curr, int depth) {
	visited[curr] = true;
	if (depth == k) {
		res.add(curr + 1);
		return;
	}
	
	for (int next : adj.get(curr)) {
		if (!visited[next])
			dfs(next, depth + 1);
	}
}*/
