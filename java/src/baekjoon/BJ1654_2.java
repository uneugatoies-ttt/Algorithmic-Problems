package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1654_2 {
	
	private static long bs(long[] arr, long target) {
		long left = 0, right = Arrays.stream(arr).max().orElseThrow();
		long mid, temp, res = -10000l;
		while (left <= right) {
			temp = 0;
			mid = (left + right) / 2;
			for (long cable : arr)
				temp += (cable / mid);
			if (temp < target) {
				right = mid - 1;
			} else {
				left = mid + 1;
				res = Math.max(res, mid);
			}
		}
		return res;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int k = Integer.parseInt(token.nextToken());
		int n = Integer.parseInt(token.nextToken());
		long[] cables = new long[k];
		for (int i = 0; i < k; ++i) {
			token = new StringTokenizer(reader.readLine());
			cables[i] = Long.parseLong(token.nextToken());
		}
		System.out.println(bs(cables, n));
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
