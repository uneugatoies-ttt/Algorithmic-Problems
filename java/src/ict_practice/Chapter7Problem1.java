package ict_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chapter7Problem1 {
	
	private static void solveWithCountingSort() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int[] parts = new int[1000001];
		
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i) {
			parts[Integer.parseInt(token.nextToken())]++;
		}
		
		token = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(token.nextToken());
		StringBuilder builder = new StringBuilder();
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < m; ++i) {
			if (parts[Integer.parseInt(token.nextToken())] > 0)
				builder.append("yes ");
			else 
				builder.append("no ");
		}
		builder.deleteCharAt(builder.length() - 1);
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int[] parts = new int[n];
		
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			parts[i] = Integer.parseInt(token.nextToken());
		Arrays.sort(parts);
		
		token = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(token.nextToken());
		StringBuilder builder = new StringBuilder();
		
		token = new StringTokenizer(reader.readLine());
		int order;
		for (int i = 0; i < m; ++i) {
			order = Integer.parseInt(token.nextToken());
			if (Arrays.binarySearch(parts, order) > -1)
				builder.append("yes ");
			else 
				builder.append("no ");
		}
		builder.deleteCharAt(builder.length() - 1);
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solveWithCountingSort();
	}

}
