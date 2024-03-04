package ict_practice.part3.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q34 {
	
	private static int lds(int[] seq) {
		int n = seq.length;
		int[] lds = new int[n];
		Arrays.fill(lds, 1);
		
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (seq[i] < seq[j] && lds[i] < lds[j] + 1)
					lds[i] = lds[j] + 1;
			}
		}
		
		return Arrays.stream(lds).max().orElseThrow();
	}
	
	static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(st.nextToken());

		bw.write(String.valueOf(n - lds(arr)));
		bw.flush();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
