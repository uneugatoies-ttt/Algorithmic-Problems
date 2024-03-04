package algorithm.search;

import java.util.Arrays;

public class BinarySearch001 {
	
	private static int binarySearch02(int[] arr, int target) {
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;
		int mid;
		
		while (true) {
			if (left > right) return -1;
			
			mid  = (left + right) / 2;
			if (arr[mid] == target) break;
			if (arr[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		return mid;
	}
	
	private static int binarySearch(int[] arr, int target) {
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;
		int mid;
		
		while (left <= right) {
			mid = (left + right) / 2;
			if (arr[mid] == target) 
				return mid;
			else if (arr[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18 };
		int i = binarySearch(arr, 4);
		System.out.println(i);
	}

}
