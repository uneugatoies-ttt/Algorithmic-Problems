package algorithm.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FloydWarshall001 {
	
	private static final int INF = Integer.MAX_VALUE / 2;
	private static int n, m;
	
	private static void fw(List<List<Integer>> matrix) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		m = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < n + 1; ++i) {
			matrix.add(new ArrayList<>(n + 1));
			for (int j = 0; j < n + 1; ++j)
				matrix.get(i).add(INF);
		}
		
		for (int i = 1; i < n + 1; ++i)
			for (int j = 1; j < n + 1; ++j)
				if (i == j)	matrix.get(i).set(j, 0);
		
		int from, to, wei;
		StringTokenizer token;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(reader.readLine());
			from = Integer.parseInt(token.nextToken());
			to = Integer.parseInt(token.nextToken());
			wei = Integer.parseInt(token.nextToken());
			matrix.get(from).set(to, wei);
		}
		
		for (int k = 1; k < n + 1; ++k) {
			for (int i = 1; i < n + 1; ++i) {
				for (int j = 1; j < n + 1; ++j) {
					matrix.get(i).set(j, 
						Math.min(
							matrix.get(i).get(j),
							matrix.get(i).get(k) + matrix.get(k).get(j)
						));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		List<List<Integer>> matrix = new ArrayList<>();
		fw(matrix);
		
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < n + 1; ++j) {
				if (matrix.get(i).get(j) == INF)
					System.out.print("INFINITY ");
				else
					System.out.print(matrix.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
