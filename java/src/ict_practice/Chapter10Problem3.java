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

public class Chapter10Problem3 {
	
	private static int[] topologicalSort(
			List<Integer>[] adj,
			int[] time,
			int[] indegree
		) {
		int[] result = Arrays.copyOf(time, time.length);
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i = 0; i < indegree.length; ++i) {
			if (indegree[i] == 0)
				q.add(i);
		}
		
		int curr;
		while (!q.isEmpty()) {
			curr = q.poll();
			for (int nei : adj[curr]) {
				result[nei] = Math.max(result[nei], result[curr] + time[nei]);
				indegree[nei]--;
				if (indegree[nei] == 0)
					q.add(nei);
			}
		}
		
		return result;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int v = Integer.parseInt(token.nextToken());
		int[] indegree = new int[v];
		int[] time = new int[v];
		List<Integer>[] adj = new ArrayList[v];
		
		int entry;
		for (int i = 0; i < v; ++i) {
			adj[i] = new ArrayList<>();
			token = new StringTokenizer(reader.readLine());
			time[i] = Integer.parseInt(token.nextToken());
			entry = Integer.parseInt(token.nextToken());
			while (entry != -1) {
				indegree[i]++;
				adj[entry - 1].add(i);
				entry = Integer.parseInt(token.nextToken());
			}
		}
		
		int[] res = topologicalSort(adj, time, indegree);
		
		for (int i = 0; i < res.length; ++i) {
			writer.write(String.valueOf(res[i]));
			writer.write('\n');
		}
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	

	// disastrously failed
	/*
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int v = Integer.parseInt(token.nextToken());
		int[] times = new int[v];
		int[] indegree = new int[v];
		List<Integer>[] adj = new ArrayList[v];
		List<Integer>[] oppadj = new ArrayList[v];
		
		for (int i = 0; i < v; ++i) {
			adj[i] = new ArrayList<>();
			oppadj[i] = new ArrayList<>();
		}
		
		int en;
		for (int i = 0; i < v; ++i) {
			token = new StringTokenizer(reader.readLine());
			times[i] = Integer.parseInt(token.nextToken());
			en = Integer.parseInt(token.nextToken());
			while (en != -1) {
				adj[en - 1].add(i);
				oppadj[i].add(en - 1);
				indegree[i]++;
				en = Integer.parseInt(token.nextToken());
			}
		}
		
		
		List<Integer> resofts = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < v; ++i) {
			if (indegree[i] == 0)
				q.add(i);
		}
		
		int curr;
		while (!q.isEmpty()) {
			curr = q.poll();
			resofts.add(curr);
			for (int next : adj[curr]) {
				indegree[next]--;
				if (indegree[next] == 0)
					q.add(next);
			}
		}
		
		
		boolean[] visited = new boolean[v];
		List<List<Integer>> layers = new ArrayList<>();
		
		layers.add(new ArrayList<>());
		layers.get(0).add(resofts.get(resofts.size() - 1));
		visited[resofts.get(resofts.size() - 1)] = true;
		int cnt = 1;
		int num = 1;
		for (int i = resofts.size() - 1; i >= 0; --i) {
			layers.add(new ArrayList<>());
			
			for (int nei : oppadj[i]) {
				if (!visited[nei]) {
					layers.get(cnt).add(nei);
					visited[nei] = true;
					num++;
				}
			}
			
			if (num == v) break;
		}
		
		int sum = 0, mx;
		for (int i = layers.size(); i >= 0; --i) {
			if (layers.get(i).size() == 0) continue;
			mx = -9999;
			for (int j : layers.get(i)) {
				if (mx < times[j])
					mx = times[j];
			}
			sum += mx;
		}
		
		writer.write(String.valueOf(sum));
		writer.flush();
		writer.close();
		reader.close();
	}

	public static void main(String[] args) throws IOException {
		solve();
	}*/
	
}

