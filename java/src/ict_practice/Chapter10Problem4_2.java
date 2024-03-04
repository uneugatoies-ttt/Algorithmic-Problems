package ict_practice;

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

public class Chapter10Problem4_2 {
	
	private static class Node {
		int ind;
		int cost;
		List<Integer> next;
		List<Integer> depend;
		
		public Node() {
			next = new ArrayList<>();
			depend = new ArrayList<>();
		}
	}
	
	static int n;
	static List<Node> graph;
	static List<Integer> sortResult;
	static int[] indegree;
	static int[] mn;
	static final int MNINF = Integer.MIN_VALUE;
	
	private static void topo() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < n; ++i)
			if (indegree[i] == 0)
				q.add(i);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			sortResult.add(curr);

			for (int next : graph.get(curr).next) {
				indegree[next]--;
				if (indegree[next] == 0)
					q.add(next);
			}
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		sortResult = new ArrayList<>();
		indegree = new int[n];
		mn = new int[n];
		
		for (int i = 0; i < n; ++i)
			graph.add(new Node());
		
		StringTokenizer st;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			graph.get(i).ind = i;
			graph.get(i).cost = Integer.parseInt(st.nextToken());
			int dep = Integer.parseInt(st.nextToken());
			while (dep != -1) {
				dep--;
				graph.get(i).depend.add(dep);
				graph.get(dep).next.add(i);
				dep = Integer.parseInt(st.nextToken());
			}
		}
		
		topo();
		
		for (int i : sortResult) {
			mn[i] = graph.get(i).cost;
			int mx = MNINF;
			for (int j : graph.get(i).depend)
				mx = Math.max(mn[j], mx);
			if (mx == MNINF) continue;
		
			mn[i] += mx;
		}
		
		for (int i : mn)
			bw.write(String.valueOf(i) + '\n');
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
