package ict_practice.part3.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q01 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer token = new StringTokenizer(reader.readLine());
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(token.nextToken());
		
		Arrays.sort(arr, (c1, c2) -> (Integer.compare(c2, c1)));
		
		boolean flag = false;
		int temp = 0, cnt = 0, j = n - 1;
		
		for (int i = 0; i < n; ++i) {
			temp = arr[i] - 1;
			while (true) {
				if (j <= i) {
					flag = true;
					if (temp == 0) cnt++;
					break;
				}
				if (temp <= 0)
					break;
				temp--;
				j--;
			}
			if (flag) break;
			cnt++;
		}
		
		writer.write(String.valueOf(cnt));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
