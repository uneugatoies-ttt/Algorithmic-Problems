package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10971 {
	
	private static int n;
	private static boolean[] visited;
	private static int[][] map;
	private static long result_min = Integer.MAX_VALUE;
	
	private static boolean allVisited() {
		for (int i = 0; i < n; ++i)
			if (!visited[i]) return false;
		return true;
	}
	
	private static void dfs(int start, int now, long cost) {
		// base case
		if (allVisited()) {
			if (map[now][start] != 0)
				result_min = Math.min(result_min, cost + map[now][0]);
			return;
		}
		
		for (int i = 1; i < n; ++i) {
			if (!visited[i] && map[now][i] != 0) {
				visited[i] = true;
				dfs(start, i, cost + map[now][i]);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		StringTokenizer token = null;
		map = new int[n][n];
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
		for (int i = 0; i < n; ++i) {
			visited = new boolean[n];
			visited[i] = true;
			dfs(i, i, 0);
		}
		
		System.out.println(result_min);
	}
	
	
	
	// failed attempt 002
	/*
	private static int tsp(
			int currNode,
			int mask,
			int n,
			int[][] costMatrix,
			int[][] dp) {
		if (mask == (1 << n) - 1)
			return costMatrix[currNode][0];
		
		if (dp[currNode][mask] != -1)
			return dp[currNode][mask];
		
		int minCost = Integer.MAX_VALUE;
		for (int nextNode = 0; nextNode < n; ++nextNode) {
			if ((mask & (1 << nextNode)) == 0 && costMatrix[currNode][nextNode] > 0) {
				int newMask = mask | (1 << nextNode);
				int cost = costMatrix[currNode][nextNode] + tsp(nextNode, newMask, n, costMatrix, dp);
				minCost = Math.min(minCost, cost);
			}
		}
		
		dp[currNode][mask] = minCost;
		return minCost;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;
		int n = Integer.parseInt(reader.readLine());
		int[][] costMatrix = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j)
				costMatrix[i][j] = Integer.parseInt(token.nextToken());
		}
		
		int[][] dp = new int[n][1 << n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < (1 << n); ++j)
				dp[i][j] = -1;
		}
		
		int result = tsp(0, 1, n, costMatrix, dp);
		writer.write(String.valueOf( result ));
		writer.flush();
		writer.close();
		reader.close();
	}*/

	
	
	
	// failed attempt
	/*
	private static int sumRes = 987654321;
	private static int[][] origMatrix = new int[10][10];
	private static boolean[] visited = new boolean[10];
	private static Stack<Integer> backtrack = new Stack<>();

	public static void solve(int depth, int n, int row, int cost) {
	    if (depth == n) {
	        sumRes = Math.min(sumRes, cost);
	        return;
	    }

	    for (int col = 0; col < n; ++col) {
	        if (origMatrix[row][col] == 0) continue;
	        if (!visited[col]) {
	            visited[col] = true;
	            backtrack.push(col);
	            solve(depth + 1, n, col, cost + origMatrix[row][col]);
	            visited[col] = false;
	            backtrack.pop();
	        }
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer token = null;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j)
				origMatrix[i][j] = Integer.parseInt( token.nextToken() );
		}
		
		solve(0, n, 0, 0);
		
		writer.write(String.valueOf(sumRes));
		writer.flush();
		writer.close();
		reader.close();
	}
	*/
}
