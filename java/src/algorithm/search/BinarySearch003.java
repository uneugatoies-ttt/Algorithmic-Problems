package algorithm.search;

import java.util.Arrays;

public class BinarySearch003 {
	
	private static int binarySearch(int[] arr, int target) {
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;
		int mid;
		
		while (left <= right) {
			mid = (left + right) / 2;
			
			if (arr[mid] == target)
				return mid;
			
			if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
	}
	

}
