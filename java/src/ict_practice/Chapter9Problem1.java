package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chapter9Problem1 {
	
	private static final int INF = 999999;
	private static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		
		int[][] matrix = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			Arrays.fill(matrix[i], INF);
			matrix[i][i] = 0;
		}
		
		int from, to;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(reader.readLine());
			from = Integer.parseInt(token.nextToken()) - 1;
			to = Integer.parseInt(token.nextToken()) - 1;
			matrix[from][to] = 1;
			matrix[to][from] = 1;
		}
		
		token = new StringTokenizer(reader.readLine());
		int xx = Integer.parseInt(token.nextToken()) - 1;
		int kk = Integer.parseInt(token.nextToken()) - 1;
		
		for (int k = 0; k < n; ++k)
			for (int i = 0; i < n; ++i)
				for (int j = 0; j < n; ++j)
					if (matrix[i][j] > matrix[i][k] + matrix[k][j])
						matrix[i][j] = matrix[i][k] + matrix[k][j];
		
		if (matrix[0][kk] == INF || matrix[kk][xx] == INF)
			System.out.println(-1);
		else
			System.out.println(matrix[0][kk] + matrix[kk][xx]);
	}

}
