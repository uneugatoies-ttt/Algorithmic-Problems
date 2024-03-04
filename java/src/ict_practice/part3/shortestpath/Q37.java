package ict_practice.part3.shortestpath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q37 {
	
	private static final int INF = (int) 1e9;
	private static int[][] matrix;
	private static int n, m;
	
	private static void fw() {
		for (int k = 1; k <= n; ++k) {
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					if (i == j)
						matrix[i][j] = 0;
					else
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		matrix = new int[n + 1][n + 1];
		
		for (int i = 0; i <= n; ++i)
			Arrays.fill(matrix[i], INF);
		
		StringTokenizer token;
		int from, to, wei;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(br.readLine());
			from = Integer.parseInt(token.nextToken());
			to = Integer.parseInt(token.nextToken());
			wei = Integer.parseInt(token.nextToken());
			matrix[from][to] = Math.min(matrix[from][to], wei);
		}
		
		fw();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (matrix[i][j] == INF) 
					sb.append("0 ");
				else
					sb.append(String.valueOf(matrix[i][j]) + ' ');
			}
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}


/*
private static final int INF = Integer.MAX_VALUE;
private static List<Integer>[][] matrix;
private static int n, m;

private static void fw() {
	for (int k = 1; k <= n; ++k) {
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (matrix[i][k].isEmpty() || matrix[k][j].isEmpty()) continue;
				
				
			}
		}
	}
}

private static void solve() throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	n = Integer.parseInt(br.readLine());
	m = Integer.parseInt(br.readLine());
	matrix = new ArrayList[n + 1][n + 1];
	
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			matrix[i][j] = new ArrayList<>();
		}
	}
	
	StringTokenizer token;
	int from, to, wei;
	for (int i = 0; i < m; ++i) {
		token = new StringTokenizer(br.readLine());
		from = Integer.parseInt(token.nextToken());
		to = Integer.parseInt(token.nextToken());
		wei = Integer.parseInt(token.nextToken());
		matrix[from][to].add(wei);
	}
	
	fw();
	
	StringBuilder sb = new StringBuilder();
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			if (matrix[i][j].isEmpty()) 
				sb.append("0 ");
			else
				sb.append(String.valueOf(matrix[i][j]) + ' ');
		}
		sb.append('\n');
	}
	
	bw.write(sb.toString());
	bw.flush();
}

public static void main(String[] args) throws IOException {
	solve();
}*/