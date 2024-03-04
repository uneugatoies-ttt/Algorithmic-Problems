package ict_practice;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Chapter10Problem4_3 {
	
	static int v;
	static int[] indegree;
	static List<List<Integer>> graph;
	static int[] times;
	
	private static int[] topologicalSort() {
		// "result[i]" represents the minimum amount of time for taking the "i"th class
		int[] result = new int[v];
		for (int i = 0; i < v; ++i)
			result[i] = times[i];
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i = 0; i < v; ++i)
			if (indegree[i] == 0)
				q.add(i);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int next : graph.get(curr)) {
				/*
				It can be a little bit confusing about the logic of the below line,
				but this isn't that convoluted; think about the first example that is
				given from the problem:
					-> "result[3]" will have the value of "70".
					-> And then the logic will ignore about the 2nd class since
					its required time (result[2] + times[3]) is less than "70"
					that is already assigned to "result[3]".
				*/
				result[next] = Math.max(result[next], result[curr] + times[next]);
				indegree[next]--;
				if (indegree[next] == 0)
					q.add(next);
			}
		}
		
		return result;
	}
	
	private static void solve() throws IOException {
		
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
