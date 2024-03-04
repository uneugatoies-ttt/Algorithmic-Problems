package ict_practice.part3.binsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q29 {
	
	private static int[] houses;
	private static int n, c;
	
	private static int bs() {
		int l = 1, r = houses[n - 1];
		int mid;
		int temp, pos;
		while (l <= r) {
			mid = (l + r) / 2;
			temp = 1; pos = 0;
			for (int i = 1; i < n; ++i) {
				if (houses[i] - houses[pos] >= mid) {
					temp++;
					pos = i;
				}
			}
			
			if (temp >= c)
				l = mid + 1;
			else
				r = mid - 1;
		}
		
		return l - 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		houses = new int[n];
		for (int i = 0; i < n; ++i)
			houses[i] = Integer.parseInt(br.readLine());
		Arrays.sort(houses);
		
		bw.write(String.valueOf(bs()));
		bw.flush();
	}
}

