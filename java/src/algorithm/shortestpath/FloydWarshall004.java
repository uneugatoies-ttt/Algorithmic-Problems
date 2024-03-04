package algorithm.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FloydWarshall004 {
	
	private static final int INF = (int) 1e9;
	private static int n, m;
	private static int[][] distMatrix;
	
	private static void fw() {
		for (int k = 1; k <= n; ++k) {
			for (int j = 1; j <= n; ++j) {
				for (int i = 1; i <= n; ++i)
					distMatrix[i][j] = 
						Math.min(distMatrix[i][j], distMatrix[i][k] + distMatrix[k][j]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		distMatrix = new int[n + 1][n + 1];
		
		for (int i = 0; i < n; ++i)
			Arrays.fill(distMatrix[i], INF);
		
		for (int i = 1; i <= n; ++i) 
			for (int j = 1; j <= n; ++j)
				if (i == j) distMatrix[i][j] = 0;
		
		int from, to, wei;
		StringTokenizer token;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(br.readLine());
			from = Integer.parseInt(token.nextToken());
			to = Integer.parseInt(token.nextToken());
			wei = Integer.parseInt(token.nextToken());
			distMatrix[from][to] = wei;
		}
		
		fw();
	}

}
