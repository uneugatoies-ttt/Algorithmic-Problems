package algorithm.shortestpath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Dijkstra005 {
	
	private static final int INF = (int) 1e9;
	private static int n, m, start;
	private static List<List<Node>> graph = new ArrayList<>();
	private static int[] distance = new int[100001];
	
	private static void dijkstra() {
		Queue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		while (!q.isEmpty()) {
			int curr = q.peek().ind;
			int dist = q.peek().dist;
			q.poll();
			
			if (distance[curr] < dist) continue;
			
			for (Node n : graph.get(curr)) {
				int cost = distance[curr] + n.dist;
				if (cost < distance[n.ind]) {
					distance[n.ind] = cost;
					q.add(new Node(n.ind, cost));
				}
			}
		}
	}
	
	private static class Node implements Comparable<Node> {
		
		int ind;
		int dist;
		
		public Node(int ind, int dist) {
			this.ind = ind;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.dist, other.dist);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n + 1; ++i)
			graph.add(new ArrayList<>());
		
		int from, to, cost;
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to, cost));
		}
		
		dijkstra();
		
		StringBuilder s = new StringBuilder();
		for (int i = 1; i <= n; ++i) {
			if (distance[i] == INF)
				s.append("INFINITY\n");
			else
				s.append(String.valueOf(distance[i]) + "\n");
		}
		
		bw.write(s.toString());
		bw.flush();
	}
	
}