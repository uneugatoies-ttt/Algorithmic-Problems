package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ10971_2 {
	private static long sumRes = Integer.MAX_VALUE;
	private static int[][] costMatrix;
	private static boolean[] visited;
	
	private static void bf(int start, int depth, int n, int curr, long cost) {
		if (depth == n && start == curr) {
			sumRes = Math.min(sumRes, cost);
			return;
		}
		for (int i = 0; i < n; ++i) {
			if (!visited[i] && costMatrix[curr][i] != 0) {
				visited[i] = true;
				bf(start, depth + 1, n, i, cost + costMatrix[curr][i]);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		costMatrix = new int[n][n];
		visited = new boolean[n];
		StringTokenizer token = null;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j)
				costMatrix[i][j] = Integer.parseInt( token.nextToken() );
		}
		
		for (int i = 0; i < n; ++i) {
			bf(i, 0, n, i, 0);
		}
		
		writer.write(String.valueOf(sumRes));
		writer.flush();
		writer.close();
		reader.close();
	}
}
