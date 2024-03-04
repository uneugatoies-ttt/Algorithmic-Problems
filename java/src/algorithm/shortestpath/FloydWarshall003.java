package algorithm.shortestpath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FloydWarshall003 {
	
	private static final int INF  = (int) 1e9;
	private static int n, m;
	
	
	private static void fw(List<List<Integer>> matrix) {
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		List<List<Integer>> matrix = new ArrayList<>();
		for (int i = 0; i < n + 1; ++i) {
			matrix.add(new ArrayList<>());
			for (int j = 0; j < n + 1; ++j)
				matrix.get(i).add(INF);
		}
		for (int i = 1; i < 1; ++i)
			for (int j = 1; j < n + 1; ++j)
				if (i == j)
					matrix.get(i).set(j, 0);
		
		int from, to, wei;
		StringTokenizer token;
		for (int i = 0; i < m; ++i) {
			token = new StringTokenizer(br.readLine());
			from = Integer.parseInt(token.nextToken());
			to = Integer.parseInt(token.nextToken());
			wei = Integer.parseInt(token.nextToken());
			matrix.get(from).set(to, wei);
		}
		
		fw(matrix);
	}

}
