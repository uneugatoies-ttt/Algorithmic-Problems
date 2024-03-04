package algorithm.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort002 {
	
	static int v, e;
	static int[] indegree;
	static List<List<Integer>> graph;
	
	public static void topologicalSort() {
		List<Integer> result = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i = 0; i < v; ++i)
			if (indegree[i] == 0)
				q.add(i);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			result.add(curr);
			
			for (int next : graph.get(curr)) {
				indegree[next]--;
				if (indegree[next] == 0) 
					q.add(next);
			}
		}
		
		for (int i = 0; i < result.size(); ++i)
			System.out.print((result.get(i) + 1) + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		graph = new ArrayList<>();
		indegree = new int[v];
		
		for (int i = 0; i < v; ++i)
			graph.add(new ArrayList<>());
		
		for (int i = 0; i < e; ++i) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		topologicalSort();
	}

}
