package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1654 {
	
	private static long bs(long[] arr, long target) {
		long mx = Arrays.stream(arr).max().orElseThrow();
		long left = 1;
		long right = mx;
		long mid;
		long temp;
		long res = Long.MIN_VALUE;
		while (left <= right) {
			temp = 0;
			mid = (left + right) / 2;
			for (long i : arr)
				temp += (i / mid);
			
			if (temp >= target) {
				left = mid + 1;
				res = Math.max(res, mid);
			} else 
				right = mid - 1;
		}
		
		return res;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int k = Integer.parseInt(token.nextToken());
		long n = Long.parseLong(token.nextToken());
		long[] lans = new long[k];
		for (int i = 0; i < k; ++i)
			lans[i] = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
		System.out.println(bs(lans, n));
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
