package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chapter6Problem1 {
	
	private static void takeInputAndSortAndPrint() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(reader.readLine());
		Arrays.sort(arr);
		for (int i = n - 1; i > -1; --i)
			System.out.print(arr[i] + " ");
	}
	
	public static void main(String[] args) throws IOException {
		takeInputAndSortAndPrint();
	}

}
