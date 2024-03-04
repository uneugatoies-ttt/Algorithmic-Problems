package ict_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Chapter6Problem2 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		
		Map<Integer, String> map = new HashMap<>();
		int[] keyArr = new int[n];
		String s;
		int k;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			s = token.nextToken();
			k = Integer.parseInt(token.nextToken());
			map.put(k, s);
			keyArr[i] = k;
		}
		
		Arrays.sort(keyArr);
		
		for (int i = 0; i < n; ++i) {
			builder.append(map.get(keyArr[i])).append(" ");
		}
		builder.append('\n');
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
