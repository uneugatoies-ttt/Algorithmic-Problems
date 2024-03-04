package ict_practice.part3.shortestpath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q38_2 {
	
	private static int INF = (int) 1e9;
	private static int n, m;
	private static int[][] matrix;
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new int[n + 1][n + 1];
		
		for (int i = 0; i <= n; ++i)
			Arrays.fill(matrix, INF);
		
		for (int i = 1; i <= n; ++i)
			for (int j = 1; j <= n; ++j)
				if (i == j)
					matrix[i][j] = 0;
		
		StringTokenizer token;
		int from, to;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(br.readLine());
			from = Integer.parseInt(token.nextToken());
			to = Integer.parseInt(token.nextToken());
			matrix[from][to] = 1;
		}
		
		for (int k = 1; k <= n; ++k) {
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j)
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
			}
		}
		
		int result = 0;
		int cnt;
		for (int i = 1; i <= n; ++i) {
			cnt = 0;
			for (int j = 1; j <= n; ++j) {
				if (matrix[i][j] == INF && matrix[j][i] == INF)
					continue;
				cnt++;
			}
			if (cnt == n)
				result++;
		}
		bw.write(String.valueOf(result) + "\n");
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
}
