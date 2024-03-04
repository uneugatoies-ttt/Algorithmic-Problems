package ict_practice.part3.shortestpath;

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

// Although I think the idea for this code was correct, 
// but I don't know whether this is thoroughly valid.
// Besides, I didn't use the Floyd-Warshall algorithm, which was the problem's intention.
public class Q38 {
	
	private static int n, m;
	
	private static void bfs(int start, boolean[] reached, List<List<Integer>> grade) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			reached[curr] = true;
			
			for (int next : grade.get(curr)) {
				if (!reached[next])
					q.add(next);
			}
		}
	}
	
	private static void bfsFromTheBottom(int start, int target, boolean[] reached, List<List<Integer>> grade) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		
		boolean[] visited = new boolean[n];
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			if (curr == target) {
				reached[start] = true;
				return;
			}
			
			visited[curr] = true;
			for (int next : grade.get(curr)) {
				if (!visited[next])
					q.add(next);
			}
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		List<List<Integer>> grade = new ArrayList<>();
		
		for (int i = 0; i < n; ++i)
			grade.add(new ArrayList<>());
		
		int studa, studb;
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			studa = Integer.parseInt(st.nextToken()) - 1;
			studb = Integer.parseInt(st.nextToken()) - 1;
			// studa's grade < studb's grade
			grade.get(studa).add(studb);
		}
		
		boolean[] reached = new boolean[n];
		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			Arrays.fill(reached, false);
			bfs(i, reached, grade);

			boolean flag = true;
			for (int j = 0; j < n; ++j) {
				if (!reached[j])
					bfsFromTheBottom(j, i, reached, grade);
				if (!reached[j]) {
					flag = false;
					break;
				}
			}
			
			if (flag) cnt++;
		}
		
		bw.write(String.valueOf(cnt) + "\n");
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
