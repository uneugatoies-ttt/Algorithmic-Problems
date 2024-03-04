package algorithm.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra002 {
	
	private static final int INF = Integer.MAX_VALUE - 30;
	private static int n, m, source;
	private static List<List<Entry<Integer, Integer>>> graph;
	private static int[] distance;
	
	private static void dijkstra(int start) {
		Queue<Entry<Integer, Integer>> q = new PriorityQueue<>(
			(e1, e2) -> Integer.compare(e1.getKey(), e2.getKey())
		);
		q.add(new SimpleImmutableEntry<>(0, start));
		distance[start] = 0;
		int dist, curr, cost;
		while (!q.isEmpty()) {
			dist = q.peek().getKey();
			curr = q.peek().getValue();
			q.poll();
			
			if (distance[curr] < dist)
				continue;
			for (Entry<Integer, Integer> i : graph.get(curr)) {
				cost = dist + i.getValue();
				if (cost < distance[i.getKey()]) {
					distance[i.getKey()] = cost;
					q.add(new SimpleImmutableEntry<>(cost, i.getKey()));
				}
			}
		}
	}
	
	private static void in() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		source = Integer.parseInt(reader.readLine());
		graph = new ArrayList<>();
		distance = new int[n + 1];
		for (int i = 0; i < n + 1; ++i) {
			graph.add(new ArrayList<>());
			distance[i] = INF;
		}
		int from, to, wei;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(reader.readLine());
			from = Integer.parseInt(token.nextToken());
			to = Integer.parseInt(token.nextToken());
			wei = Integer.parseInt(token.nextToken());
			graph.get(from).add(new SimpleImmutableEntry<>(to, wei));
		}
	}
	
	public static void main(String[] args) throws IOException {
		in();
		dijkstra(source);
		for (int i = 1; i < n + 1; ++i) {
			if (distance[i] == INF)
				System.out.println("INFINITY");
			else
				System.out.println(distance[i]);
		}
	}

}
