package ict_practice.part3.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q31 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer token;
		int n, m;
		int[][] mine;
		int[][] gold;
		StringBuilder builder = new StringBuilder();
		while (--t >= 0) {
			token = new StringTokenizer(br.readLine());
			n = Integer.parseInt(token.nextToken());
			m = Integer.parseInt(token.nextToken());
			mine = new int[n][m];
			gold = new int[n][m];
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j)
					mine[i][j] = Integer.parseInt(token.nextToken());
			}
			
			for (int i = 0; i < n; ++i)
				gold[i][0] = mine[i][0];

			int mx;
			for (int i = 1; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (j + 1 >= n)
						mx = Math.max(gold[j - 1][i - 1], gold[j][i - 1]);
					else if (j - 1 < 0)
						mx = Math.max(gold[j + 1][i - 1], gold[j][i - 1]);
					else
						mx = Math.max(gold[j + 1][i - 1], Math.max(gold[j - 1][i - 1], gold[j][i - 1]));
					gold[j][i] = mx + mine[j][i];
				}
			}
			
			mx = Integer.MIN_VALUE;
			for (int i = 0; i < n; ++i)
				mx = Math.max(mx, gold[i][m - 1]);
			builder.append(mx).append('\n');
		}
		
		bw.write(builder.toString());
		bw.flush();
	}

}
