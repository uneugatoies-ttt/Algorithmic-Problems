package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11728 {

	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int[] res = new int[n + m];

		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			res[i] = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(reader.readLine());
		for (int i = n; i < n + m; ++i)
			res[i] = Integer.parseInt(token.nextToken());

		Arrays.sort(res);
		
		for (int i = 0; i < res.length; ++i) {
			writer.write(String.valueOf(res[i]));
			writer.write(' ');
		}
		writer.write('\n');
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}

// Just did the task; this one is faster than using Arrays.sort().
/*
private static void solve() throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer token = new StringTokenizer(reader.readLine());
	int n = Integer.parseInt(token.nextToken());
	int m = Integer.parseInt(token.nextToken());
	int[] arr1 = new int[n];
	int[] arr2 = new int[m];
	
	token = new StringTokenizer(reader.readLine());
	for (int i = 0; i < n; ++i)
		arr1[i] = Integer.parseInt(token.nextToken());
	token = new StringTokenizer(reader.readLine());
	for (int i = 0; i < m; ++i)
		arr2[i] = Integer.parseInt(token.nextToken());

	int[] res = new int[n + m];
	int ind1 = 0;
	int ind2 = 0;
	
	for (int i = 0; i < n + m; ++i) {
		if (arr1[ind1] > arr2[ind2]) {
			res[i] = arr2[ind2];
			ind2++;
		} else {
			res[i] = arr1[ind1];
			ind1++;
		}
		if (ind1 >= n) {
			i++;
			while (ind2 < m) {
				res[i] = arr2[ind2];
				ind2++;
				i++;
			}
			break;
		}
		if (ind2 >= m) {
			i++;
			while (ind1 < n) {
				res[i] = arr1[ind1];
				ind1++;
				i++;
			}
			break;
		}
	}
	
	for (int i = 0; i < res.length; ++i) {
		writer.write(String.valueOf(res[i]));
		writer.write(' ');
	}
	writer.write('\n');
	writer.flush();
	writer.close();
	reader.close();
}*/