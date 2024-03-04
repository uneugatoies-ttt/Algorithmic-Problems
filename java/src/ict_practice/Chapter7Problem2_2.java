package ict_practice;

import java.io.IOException;
import java.util.Arrays;

public class Chapter7Problem2_2 {

	private static int bs(int[] arr, int target) {
		int left = 0, right = Arrays.stream(arr).max().orElseThrow();
		int mid, temp, res = Integer.MIN_VALUE;
		while (left <= right) {
			temp = 0;
			mid = (left + right) / 2;
			for (int i : arr)
				if (i > mid)
					temp += (i - mid);
			if (temp < target) {
				right = mid - 1;
			} else {
				left = mid + 1;
				res = Math.max(res, mid);
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		
	}
	
}
