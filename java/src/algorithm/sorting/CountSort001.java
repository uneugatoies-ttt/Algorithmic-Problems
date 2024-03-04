package algorithm.sorting;

import java.util.Arrays;

public class CountSort001 {
	
	private static int[] countSort(int[] arr) {
		// Premised on the assumption that all elements are greater than or equal to 0
		int maxi = Arrays.stream(arr).max().orElseThrow();
		int[] res = new int[maxi + 1];
		for (int i = 0; i < arr.length; ++i)
			res[arr[i]]++;
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2 };
		int[] res = countSort(arr);
		int k;
		for (int i = 0; i < res.length; ++i) {
			k = res[i];
			while (k-- > 0)
				System.out.print(i + " ");
		}
	}
	
	

}
