package ict_practice;

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

public class Chapter9Problem2 {
	
	private static int[] distance;
	private static int n, m, source;
	private static final int INF = Integer.MAX_VALUE / 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		source = Integer.parseInt(token.nextToken()) - 1;
		distance = new int[n];
		List<List<Entry<Integer, Integer>>> adj = new ArrayList<>();
		for (int i = 0 ; i < n; ++i) {
			adj.add(new ArrayList<>());
			distance[i] = INF;
		}
		
		int from, to, wei;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(reader.readLine());
			from = Integer.parseInt(token.nextToken()) - 1;
			to = Integer.parseInt(token.nextToken()) - 1;
			wei = Integer.parseInt(token.nextToken());
			adj.get(from).add(new SimpleImmutableEntry<>(to, wei));
		}
		
		// Dijkstra
		Queue<Entry<Integer, Integer>> q = new PriorityQueue<>((e1, e2) -> (
				Integer.compare(e1.getValue(), e2.getValue())
		));
		q.add(new SimpleImmutableEntry<>(source, 0));
		distance[source] = 0;
		
		int curr, dist, cost;
		while (!q.isEmpty()) {
			curr = q.peek().getKey();
			dist = q.peek().getValue();
			q.poll();
			
			if (distance[curr] < dist) continue;
			
			for (Entry<Integer, Integer> next : adj.get(curr)) {
				cost = dist + next.getValue();
				if (distance[next.getKey()] > cost) {
					distance[next.getKey()] = cost;
					q.add(new SimpleImmutableEntry<>(next.getKey(), cost));
				}
			}
		}
		
		int cnt = 0;
		int mx = Integer.MIN_VALUE + 1000;
		for (int i = 0; i < n; ++i) {
			if (i != source && distance[i] != INF) {
				cnt++;
				mx = Math.max(mx, distance[i]);
			}
		}
		
		System.out.println(cnt + " " + mx);
	}

}
