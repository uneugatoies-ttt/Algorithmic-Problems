package etcetera;

import java.util.Arrays;

public class SortPractice002 {
	
	public static void main(String[] args) {
		int[] arr = {-39875, -77, 3, 6, 8, 18, 19, 20, 59, 72, 283, 9601};
		bubble(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	// mergesort 
	private static void mergesort(int[] arr) {
		if (arr.length <= 1) return;
		
		int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
		int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
		mergesort(left);
		mergesort(right);
		merge(arr, left, right);
	}
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
	
	// quick sort 2
	private static void quicksort2(int[] arr, int low, int high) {
		if (low >= high) return;
		
		int center = partition2(arr, low, high);
		quicksort2(arr, low, center - 1);
		quicksort2(arr, center + 1, high);
	}
	
	private static int partition2(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low;
		
		for (int j = low; j < high; ++j) {
			if (arr[j] > pivot) continue;
			swap(arr, i, j);
			i++;
		}
		swap(arr, i, high);
		
		return i;
	}
	
	// quick sort 1
	private static void quicksort1(int[] arr, int low, int high) {
		if (low >= high) return;
		
		int center = partition1(arr, low, high);
		quicksort1(arr, low, center - 1);
		quicksort1(arr, center, high);
	}
	private static int partition1(int[] arr, int low, int high) {
		int pivot = arr[(low + high) / 2];
		
		while (low <= high) {
			while (arr[low] < pivot) low++;
			while (arr[high] > pivot) high--;
			if (low <= high) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
		
		return low;
	}
	
	// counting sort 
	private static void counting(int[] arr) {
		int[] cntarr = new int[Arrays.stream(arr).max().orElseThrow() + 1];
		for (int i = 0; i < arr.length; ++i)
			cntarr[arr[i]]++;
		
		for (int i = 0; i < cntarr.length; ++i) {
			for (int j = 0; j < cntarr[i]; ++j)
				System.out.print(i + " ");
		}
		System.out.println();
	}
	
	// insertion sort
	private static void insertion(int[] arr) {
		for (int i = arr.length; i >= 1; --i) {
			int key = arr[i];
			int j;
			for (j = i - 1; j >= 0; --j) {
				if (arr[j] <= key) break;
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = key;
		}
	}
	
	// selection sort
	private static void selection(int[] arr) {
		for (int i = 0; i < arr.length - 1; ++i) {
			int mnind = i;
			for (int j = i; j < arr.length; ++j) {
				if (arr[j] < arr[mnind])
					mnind = j;
			}
			swap(arr, mnind, i);
		}
	}
	
	// bubble sort
	private static void bubble(int[] arr) {
		for (int i = arr.length - 1; i >= 0; --i) {
			for (int j = 0; j < i; ++j)
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
