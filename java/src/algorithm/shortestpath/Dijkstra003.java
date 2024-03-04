package algorithm.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.AbstractMap.SimpleImmutableEntry;

public class Dijkstra003 {
	
	private static final int INF = Integer.MAX_VALUE - 30;
	private static int n, m, source;
	private static int[] distance;
	
	private static void dijkstra(List<List<Entry<Integer, Integer>>> graph, int start) {
		// We can now put the index to the entry's key.
		Queue<Entry<Integer, Integer>> q = 
			new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));
		q.add(new SimpleImmutableEntry<>(start, 0));
		distance[start] = 0;
		
		int curr, dist, cost;
		while (!q.isEmpty()) {
			curr = q.peek().getKey();
			dist = q.peek().getValue();
			q.poll();
			if (dist > distance[curr]) continue;
			
			for (Entry<Integer, Integer> next : graph.get(curr)) {
				cost = dist + next.getValue();
				if (cost < distance[next.getKey()]) {
					distance[next.getKey()] = cost;
					q.add(new SimpleImmutableEntry<>(next.getKey(), cost));
				}
			}
		}
	}

	
	public static void main(String[] args) throws IOException {
		List<List<Entry<Integer, Integer>>> graph;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		source = Integer.parseInt(reader.readLine());
		
		graph = new ArrayList<>();
		
		for (int i = 0; i < n + 1; ++i)
			graph.add(new ArrayList<>());
		
		distance = new int[n + 1];
		Arrays.fill(distance, INF);
		
		int from, to, wei;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(reader.readLine());
			from = Integer.parseInt(token.nextToken());
			to = Integer.parseInt(token.nextToken());
			wei = Integer.parseInt(token.nextToken());
			graph.get(from).add(new SimpleImmutableEntry<>(to, wei));
		}
		
		dijkstra(graph, source);
		
		for (int i = 1; i < n + 1; ++i) {
			if (distance[i] == INF)
				System.out.println("INFINITY");
			else
				System.out.println(distance[i]);
		}
	}

}
