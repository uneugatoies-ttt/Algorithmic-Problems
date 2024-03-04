package ict_practice.part3.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q23_2 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		String[][] arr = new String[n][4];
		StringTokenizer token;
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < 4; ++j) 
				arr[i][j] = token.nextToken();
		}
	
		Comparator<String[]> comparator = 
			(a1, a2) -> {
				if (a1[1].equals(a2[1])) {
					if (a1[2].equals(a2[2])) {
						if (a1[3].equals(a2[3]))
							return a1[0].compareTo(a2[0]);
						return Integer.parseInt(a2[3]) - Integer.parseInt(a1[3]);
					}
					return Integer.parseInt(a1[2]) - Integer.parseInt(a2[2]);
				}
				return Integer.parseInt(a2[1]) - Integer.parseInt(a1[1]);
			};
		
		Arrays.sort(arr, comparator);
		
		for (int i = 0; i < n; ++i)
			writer.write(arr[i][0] + "\n");
		writer.flush();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
}
