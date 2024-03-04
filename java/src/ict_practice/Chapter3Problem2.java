package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chapter3Problem2 {
	
	// slightly more advanced
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt( token.nextToken() );
		int m = Integer.parseInt( token.nextToken() );
		int k = Integer.parseInt( token.nextToken() );
		
		token = new StringTokenizer(reader.readLine());
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(token.nextToken());
		
		Arrays.sort(arr);
		int fir = arr[arr.length - 1];
		int sec = arr[arr.length - 2];
		
		int firstNum = (Math.floorDiv(m, k + 1) * k) + (m % (k + 1));
		int secondNum = Math.floorDiv(m, k + 1);
		
		int res = (fir * firstNum) + (sec * secondNum);
		
		System.out.println(res);
	}
	
	
	
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt( token.nextToken() );
		int m = Integer.parseInt( token.nextToken() );
		int k = Integer.parseInt( token.nextToken() );
		
		token = new StringTokenizer(reader.readLine());
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(token.nextToken());
		
		Arrays.sort(arr);
		int max = arr[arr.length - 1];
		int secondMax = 0;
		int i = arr.length - 2;
		while (arr[i] == max) i--;
		
		if (i < 0)
			secondMax = max;
		else
			secondMax = arr[i];
		
		int res = 0;
		int jj = 0;
		for (int j = 0; j < m; ++j) {
			if (jj == k) {
				jj = 0;
				res += secondMax;
			} else {
				jj++;
				res += max;
			}
		}
		
		System.out.println(res);
	}*/
	
	
}

