package algorithm.sorting;

import java.util.Arrays;

public class MergeSort002 {

	private static void merge(int[] res, int[] left, int[] right) {
		int l = 0;
		int r = 0;
		for (int i = 0; i < res.length; ++i) {
			if (r >= right.length || (l < left.length && left[l] <= right[r])) {
				res[i] = left[l];
				l++;
			} else {
				res[i] = right[r];
				r++;
			}
		}
	}
	
	private static void mergeSort(int[] arr) {
		if (arr.length > 1) {
			int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
			int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
			mergeSort(left);
			mergeSort(right);
			merge(arr, left, right);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 9, 2, 1, 39, -5, 1, 0, 9935, 3, 33, 3 };
		mergeSort(arr);
		for (int i = 0; i < arr.length; ++i)
			System.out.print(arr[i] + " ");
		
	}
    
}