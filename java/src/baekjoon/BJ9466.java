package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ9466 {
	public static int total;
	
	public static void search(int start, int[] testClass, boolean[] visited) {
		int count = 0;
		int curr = testClass[start];
		visited[curr] = true;
		while (true) {
			if (testClass[curr] == curr) {
				total += count;
				return;
			}
			if (curr == start)
				return;
			
			curr = testClass[curr];
			visited[testClass[curr]] = true;
			count++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int t = Integer.parseInt(token.nextToken());
		
		for (int i = 0; i < t; ++i) {
			total = 0;
			token = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(token.nextToken());
			int[] testClass = new int[n + 1];
			boolean[] visited = new boolean[n + 1];
			token = new StringTokenizer(reader.readLine());
			
			for (int j = 1; j < n + 1; ++j)
				testClass[j] = Integer.parseInt(token.nextToken());
			
			for (int j = 1; j < n + 1; ++j)
				if (!visited[j])
					search(j, testClass, visited);
			
			builder.append(total).append('\n');
		}
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
