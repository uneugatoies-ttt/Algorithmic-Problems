package ict_practice.part3.shortestpath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q40 {
	
	private static class Node implements Comparable<Node> {
		int ind; int dist;
		public Node(int ind, int dist) {
			this.ind = ind;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	static final int INF = (int) 1e9;
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Node>> adj = new ArrayList<>();
		int[] distance = new int[n];
		
		Arrays.fill(distance, INF);
		distance[0] = 0;
		
		for (int i = 0; i < n; ++i)
			adj.add(new ArrayList<>());

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			adj.get(a).add(new Node(b, 1));
			adj.get(b).add(new Node(a, 1));
		}
		
		Queue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0));
		
		while (!q.isEmpty()) {
			int curr = q.peek().ind;
			int dist = q.peek().dist;
			q.poll();
			
			for (Node node : adj.get(curr)) {
				int cost = node.dist + dist;
				if (cost < distance[node.ind]) {
					distance[node.ind] = cost;
					q.add(new Node(node.ind, cost));
				}
			}
		}
		
		int mxind = -1;
		int mxdist = INF * -1;
		for (int i = 1; i < n; ++i) {
			if (distance[i] > mxdist) {
				mxind = i;
				mxdist = distance[i];
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			if (distance[i] == mxdist)
				cnt++;
		}
		
		bw.write(String.valueOf(mxind + 1) + ' ');
		bw.write(String.valueOf(mxdist) + ' ');
		bw.write(String.valueOf(cnt) + '\n');
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	

}
