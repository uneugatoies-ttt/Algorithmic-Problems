package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1654_3 {
	
	private static int k, n;
	private static int[] cables;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		k = Integer.parseInt(token.nextToken());
		n = Integer.parseInt(token.nextToken());
		cables = new int[k];
		long left = 1;
		long right = 0;
		for (int i = 0; i < k; ++i) {
			cables[i] = Integer.parseInt((reader.readLine()));
			right = Math.max(right, cables[i]);
		}
		long mid;
		long temp, res = -99999l;
		while (left <= right) {
			temp = 0;
			mid = (left + right) / 2;
			for (int c : cables)
				temp += (c / mid);
			
			if (temp >= n) {
				res = Math.max(res, mid);
				left = mid + 1;
			} else 
				right = mid - 1;
		}
		
		writer.write(String.valueOf(res));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	
	/*
	private static long bs(long[] cables, int target) {
		long left = 1;
		long right = Arrays.stream(cables).max().orElseThrow();
		long mid;
		long temp, res = -99999l;
		while (left <= right) {
			temp = 0;
			mid = (left + right) / 2;
			for (long c : cables)
				temp += c / mid;
			
			if (temp >= target) {
				res = Math.max(res, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return res;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int k = Integer.parseInt(token.nextToken());
		int n = Integer.parseInt(token.nextToken());
		long[] cables = new long[k];
		for (int i = 0; i < k; ++i)
			cables[i] = Long.parseLong(
					(new StringTokenizer(reader.readLine())).nextToken()
				);
		
		long res = bs(cables, n);
		
		writer.write(String.valueOf(res));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}*/

}
