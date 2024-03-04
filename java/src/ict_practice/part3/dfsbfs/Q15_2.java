package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q15_2 {
	
	private static int n, m, k, x;
	private static List<List<Integer>> adj = new ArrayList<>();
	private static int[] distance;

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(x - 1);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int next : adj.get(curr)) {
				if (distance[next] == -1) {
					q.add(next);
					distance[next] = distance[curr] + 1;
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
		Arrays.fill(distance, -1);
		distance[x - 1] = 0;
		
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