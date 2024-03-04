package ict_practice.part3.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q05 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int[] weight = new int[m + 1];
		
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			weight[Integer.parseInt(token.nextToken())]++;
		
		int cnt = 0, temp1, temp2;
		for (int i = 1; i < weight.length - 1; ++i) {
			temp1 = weight[i];
			while (temp1-- > 0) {
				for (int j = i + 1; j < weight.length; ++j) {
					temp2 = weight[j];
					while (temp2-- > 0) 
						cnt++;
				}
			}
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
