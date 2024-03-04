package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BJ1167 {
	
	private static boolean[] visited;
	private static int[] distance;
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int nodes = Integer.parseInt(token.nextToken());
		
		List<List<Entry<Integer, Integer>>> adj = new ArrayList<>();
		for (int i = 0; i < nodes; ++i)
			adj.add(new ArrayList<>());
		
		int from, to, wei;
		for (int i = 0; i < nodes; ++i) {
			token = new StringTokenizer(reader.readLine());
			from = Integer.parseInt(token.nextToken()) - 1;
			
			while (true) {
				to = Integer.parseInt(token.nextToken()) - 1;
				if (to == -2) break;
				wei = Integer.parseInt(token.nextToken());
				adj.get(from).add(new SimpleImmutableEntry<>(to, wei));
			}
		}
		
		visited = new boolean[nodes];
		distance = new int[nodes];
		Arrays.fill(distance, 0);
		
		dfs(0, adj);
		
		int mx = -999999;
		int mxInd = -1;
		
		for (int i = 0 ; i < distance.length; ++i) {
			if (distance[i] > mx) {
				mx = distance[i];
				mxInd = i;
			}
		}

		Arrays.fill(visited, false);
		Arrays.fill(distance, 0);
		
		dfs(mxInd, adj);
		
		writer.write(String.valueOf(Arrays.stream(distance).max().orElseThrow()));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	private static void dfs(int curr, List<List<Entry<Integer, Integer>>> adj) {
		visited[curr] = true;
		for (Entry<Integer, Integer> next : adj.get(curr)) {
			if (!visited[next.getKey()]) {
				distance[next.getKey()] += (distance[curr] + next.getValue()); 
				dfs(next.getKey(), adj);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}



	// Using Dijkstra's algorithm works; but it can pass the time constraint.
	/*
	private static final int INF = Integer.MAX_VALUE / 2;
	
	public static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int nodes = Integer.parseInt(token.nextToken());
		
		List<List<Entry<Integer, Integer>>> adj = new ArrayList<>();
		for (int i = 0; i < nodes; ++i)
			adj.add(new ArrayList<>());
		
		int from, to, wei;
		for (int i = 0; i < nodes; ++i) {
			token = new StringTokenizer(reader.readLine());
			from = Integer.parseInt(token.nextToken()) - 1;
			for (int j = 0; j < token.countTokens() - 1; ++j) {
				to = Integer.parseInt(token.nextToken()) - 1;
				wei = Integer.parseInt(token.nextToken());
				adj.get(from).add(new SimpleImmutableEntry<>(to, wei));
			}
		}
		
		int[] maxDist = new int[nodes];
		int[] distance = new int[nodes];
		
		for (int i = 0; i < nodes; ++i) {
			maxDist[i] = dijkstra(i, adj, distance);
		}
		
		writer.write( String.valueOf(Arrays.stream(maxDist).max().orElseThrow()) );
		writer.flush();
		writer.close();
		reader.close();
	}
	
	private static int dijkstra(int start, List<List<Entry<Integer, Integer>>> adj, int[] distance) {
		Arrays.fill(distance, INF);
		Queue<Entry<Integer, Integer>> q = new PriorityQueue<>((e1, e2) -> (
				Integer.compare(e1.getValue(), e2.getValue())
		));
		q.add(new SimpleImmutableEntry<>(start, 0));
		distance[start] = 0;
		
		int curr, dist, cost;
		while (!q.isEmpty()) {
			curr = q.peek().getKey();
			dist = q.peek().getValue();
			q.poll();
			
			if (dist > distance[curr]) continue;
			
			for (Entry<Integer, Integer> next : adj.get(curr)) {
				cost = dist + next.getValue();
				if (cost < distance[next.getKey()]) {
					distance[next.getKey()] = cost;
					q.add(new SimpleImmutableEntry<>(next.getKey(), cost));
				}
			}
		}
		
		int mx = Integer.MIN_VALUE;
		for (int i = 0; i < distance.length; ++i) {
			if (distance[i] != INF && mx < distance[i])
				mx = distance[i];
		}
		return mx;
	}

	public static void main(String[] args) throws IOException {
		solve();
	}
*/

