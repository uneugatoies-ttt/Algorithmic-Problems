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

/*
	-> Using Dijkstra's algorithm.
	
	-> Maybe this would be the hint for the reason why the approach of
	the "Q15" class was wrong.
*/
public class Q15_3 {
	
	private static final int INF = Integer.MAX_VALUE;
	private static int n, m, k, x;
	private static List<List<Integer>> adj = new ArrayList<>();
	private static int[] distance;
	
	private static void dijkstra() {
		Queue<Entry<Integer, Integer>> q =
				new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));
		q.add(new SimpleImmutableEntry<>(x - 1, 0));
		distance[x - 1] = 0;
		int curr, dist, cost;
		while (!q.isEmpty()) {
			curr = q.peek().getKey();
			dist = q.peek().getValue();
			q.poll();
			if (dist > distance[curr]) continue;
			
			for (int next : adj.get(curr)) {
				cost = dist + 1;
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
		
		distance = new int[n];
		Arrays.fill(distance, INF);
		
		for (int i = 0; i < n; ++i)
			adj.add(new ArrayList<>());
		
		int a, b;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(reader.readLine());
			a = Integer.parseInt(token.nextToken());
			b = Integer.parseInt(token.nextToken());
			adj.get(a - 1).add(b - 1);
		}
		
		dijkstra();
		
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
