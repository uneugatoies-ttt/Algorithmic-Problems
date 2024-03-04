package ict_practice.part3.binsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q29_2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] houses = new int[n];
		for (int i = 0 ; i < n; ++i)
			houses[i] = Integer.parseInt(br.readLine());
		Arrays.sort(houses);
		
		int l = 1, r = houses[n - 1];
		int mid, currrouternum, lastpos;
		
		while (l <= r) {
			mid = (l + r) / 2;
			currrouternum = 1; lastpos = 0;
			
			for (int i = 0; i < n; ++i) {
				if (houses[i] - houses[lastpos] >= mid) {
					currrouternum++;
					lastpos = i;
				}
			}
			
			if (currrouternum >= c)
				l = mid + 1;
			else
				r = mid - 1;
		}
		
		bw.write(String.valueOf(l - 1));
		bw.flush();
	}

}
