package ict_practice;

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

public class Chapter10Problem4 {
	
	static int n;
	static int[] cost;
	static int[] mn;
	static List<List<Integer>> dependencies;
	static List<List<Integer>> graph;
	static List<Integer> sortres;
	static int[] indegree;
	static final int MNINF = Integer.MIN_VALUE;
	
	private static void topo() {
		sortres = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i = 0; i < n; ++i)
			if (indegree[i] == 0)
				q.add(i);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			sortres.add(curr);
			
			for (int next : graph.get(curr)) {
				indegree[next]--;
				if (indegree[next] == 0)
					q.add(next);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		cost = new int[n];
		mn = new int[n];
		indegree = new int[n];
		dependencies = new ArrayList<>();
		graph = new ArrayList<>();
		
		for (int i = 0; i < n; ++i) {
			dependencies.add(new ArrayList<>());
			graph.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			int dep = Integer.parseInt(st.nextToken()) - 1;
			while (dep != -2) {
				dependencies.get(i).add(dep);
				graph.get(dep).add(i);
				indegree[i]++;
				dep = Integer.parseInt(st.nextToken()) - 1;
			}
		}

		topo();
		
		Arrays.fill(mn, MNINF);
		for (int i : sortres) {
			mn[i] = cost[i];
			int mx = MNINF;
			for (int j : dependencies.get(i)) {
				mx = Math.max(mn[j], mx);
			}
			if (mx == MNINF) continue;
			mn[i] += mx;
		}
		
		for (int i = 0; i < n; ++i)
			bw.write(String.valueOf(mn[i]) + '\n');
		bw.flush();
	}

}
