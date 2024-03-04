package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chapter7Problem2 {
	
	private static int bs2(int[] arr, int target) {
		int start = 0;
		int end = Arrays.stream(arr).max().orElseThrow();
		int result = 0;
		int total = 0;
		int mid;
		
		while (start <= end) {
			total = 0;
			mid = (start + end) / 2;
			for (int x : arr)
				if (x > mid)
					total += (x - mid);
			if (total < target)
				end = mid - 1;
			else {
				result = mid;
				start = mid + 1;
			}
		}
		return result;
	}

	// Failed attempt, I guess; 
	private static int bs1(int[] arr, int target) {
		int left = 0;
		int right = Arrays.stream(arr).max().orElseThrow();
		int mid = 0;
		int sum = 0;
		
		while (left < right) {
			sum = 0;
			mid = (left + right) / 2;
			
			for (int length : arr)
				if (length - mid > 0)
					sum += (length - mid);
			
			if (target == sum)
				return mid;
			else if (target < sum)
				left = mid + 1;
			else
				right = mid - 1;
		}
		
		return mid;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken()), m = Integer.parseInt(token.nextToken());
		int[] rs = new int[n];
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			rs[i] = Integer.parseInt(token.nextToken());
		System.out.println(bs1(rs, m));
		System.out.println(bs2(rs, m));
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
