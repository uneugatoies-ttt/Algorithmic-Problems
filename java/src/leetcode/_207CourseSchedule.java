package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class _207CourseSchedule {
	public static void main(String[] args) {
		_207SolutionDFS solDFS = new _207SolutionDFS();
		_207SolutionBFS solBFS = new _207SolutionBFS();
		int numCourses = 2;
		int[][] pre = new int[2][2];
		pre[0][0] = 1;
		pre[0][1] = 0;
		pre[1][0] = 0;
		pre[1][1] = 1;
		
		System.out.println(solDFS.canFinish(numCourses, pre));
		System.out.println(solBFS.canFinish(numCourses, pre));
	}
}

class _207SolutionDFS {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean[] visited = new boolean[numCourses];
		boolean[] recurStack = new boolean[numCourses];
		
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int i = 0; i < numCourses; ++i)
			adj.put(i, new ArrayList<>());
		for (int[] pre : prerequisites)
			adj.get(pre[1]).add(pre[0]);
		
		for (int i = 0; i < numCourses; ++i)
			if (!visited[i])
				if (hasCycleDFS(i, visited, recurStack, adj))
					return false;
		
		return true;
	}
	
	
	public boolean hasCycleDFS(
		int curr,
		boolean[] visited,
		boolean[] recurStack,
		Map<Integer, List<Integer>> adj
	) {
		visited[curr] = true;
		recurStack[curr] = true;
		for (int next : adj.get(curr)) {
			if (!visited[next]) {
				if (hasCycleDFS(next, visited, recurStack, adj)) 
					return true;
			} else if (recurStack[next]) {
				return true;
			}
		}
		recurStack[curr] = false;
		return false;
	}
}

class _207SolutionBFS {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int i = 0; i < numCourses; ++i)
			adj.put(i, new ArrayList<>());
		for (int[] pre : prerequisites)
			adj.get(pre[1]).add(pre[0]);
		
		for (int i = 0; i < numCourses; ++i)
			if (hasCycleBFS(i, adj))
				return false;
		
		return true;
	}
	
	public boolean hasCycleBFS(int start, Map<Integer, List<Integer>> adj) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] discovered = new boolean[adj.size()];
		
		q.add(start);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int nei : adj.get(curr)) {
				if (nei == start)
					return true;
				
				if (!discovered[nei]) {
					discovered[nei] = true;
					q.add(nei);
				}
			}
		}
		
		return false;
	}
}






























/*

class _207SolutionDFS {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean[] visited = new boolean[numCourses];
		boolean[] recurStack = new boolean[numCourses];
		
		boolean hasCycle = false;
		
		Map<Integer, List<Integer>> edges = new HashMap<>();
		for (int i = 0; i < numCourses; ++i)
			edges.put(i, new ArrayList<>());
		
		for (int[] pre : prerequisites) {
			edges.get(pre[1]).add(pre[0]);
		}
		
		for (int i = 0; i < numCourses; ++i) {
			if (!visited[i]) {
				if (isCyclicUtil(i, edges, visited, recurStack)) {
					hasCycle = true;
					break;
				}
			}
		}
		
		return !hasCycle;
	}
	
	
	public boolean isCyclicUtil(
		int curr,
		Map<Integer, List<Integer>> edges,
		boolean[] visited,
		boolean[] recurStack
	) {
		visited[curr] = true;
		recurStack[curr] = true;
		
		for (int nei : edges.get(curr)) {
			if (!visited[nei]) {
				if (isCyclicUtil(nei, edges, visited, recurStack))
					return true;
			} else if (recurStack[nei]) {
				return true;
			}
		}
		
		recurStack[curr] = false;

		return false;
	}
}
*/
	
	
/*
	POSTSCRIPT: The reason it was failed is because I used
	a ponderous data structure, List - one time as an adjacent list,
	and the other time as 'visited' whose role is indicating
	if a node was visited.
	
	I could pass the time limit after I changed them to 
	Map<Integer, List<Integer>> and boolean[], respectively.
 */
// failed attempt: it exceeded the time limit
/*
public class _207CourseSchedule {
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] pre = {{1, 0}, {0, 1}};

		Solution s = new Solution();
		
		System.out.println(s.canFinish(numCourses, pre));
		
	}
}


class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < numCourses; ++i) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i < prerequisites.length; ++i) {
			adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		
		for (int i = 0; i < numCourses; ++i) {
			if (hasCycleBFS(i, adj))
				return false;
		}
		
		return true;
	}
	
	public boolean hasCycleBFS(int start, List<List<Integer>> adj) {
		Queue<Integer> q = new ArrayDeque<>();
		List<Integer> discovered = new ArrayList<>();
		
		q.add(start);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int nei : adj.get(curr)) {
				if (nei == start) {
					return true;
				}
				
				if (!discovered.contains(nei)) {
					discovered.add(nei);
					q.add(nei);
				}
			}
		}
		
		return false;
	}
}*/