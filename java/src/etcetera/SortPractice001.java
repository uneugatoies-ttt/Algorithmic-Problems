package etcetera;

import java.util.Arrays;

public class SortPractice001 {
	
	//static int[] arr = { 18, 6, 3, 72, 59, 19, 20, 8 };
	
	// merge sort
	/*
	private static void merge(int[] res, int[] left, int[] right) {
		int l = 0;
		int r = 0;
		for (int i = 0; i < res.length; ++i) {
			if (r >= right.length || (l < left.length && left[l] <= right[r]))
			{
				res[i] = left[l];
				l++;
			}
			else
			{
				res[i] = right[r];
				r++;
			}
		}
	}
	private static void mergeSort(int[] arr) {
		if (arr.length <= 1) return;
		
		int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
		int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
		mergeSort(left);
		mergeSort(right);
		merge(arr, left, right);
	}
	
	public static void main(String[] args) {
		int[] arr = { 18, 6, 9601, 3, 283, -39875, 72, 59, 19, -77, 20, 8 };
		
		mergeSort(arr);

		System.out.println(Arrays.toString(arr));
	}*/
	
	// counting sort
	/*
	public static void main(String[] args) {
		int[] arr = { 18, 6, 3, 72, 59, 19, 20, 8 };
		int mx = Arrays.stream(arr).max().orElseThrow();
		int[] cntarr = new int[mx + 1];
		
		for (int i = 0; i < arr.length; ++i)
			cntarr[arr[i]]++;
		
		for (int i = 0; i < mx + 1; ++i) {
			for (int j = 0; j < cntarr[i]; ++j)
				System.out.print(i + " ");
		}
		System.out.println();
	}*/
	
	// quick sort 2
	/*
	private static void quicksort(int arr[], int low, int high) {
		if (low >= high) return;
		int center = partition(arr, low, high);
		quicksort(arr, low, center - 1);
		quicksort(arr, center, high);
	}
	private static int partition(int arr[], int low, int high) {
		int pivot = arr[(low + high) / 2];
		while (low <= high) {
			while (pivot > arr[low]) low++;
			while (pivot < arr[high]) high--;
			if (low <= high) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		int[] arr = { 18, 6, 3, 72, 59, 19, 20, 8 };
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}*/

	// quick sort 1
	/*
	private static void quicksort(int low, int high) {
		if (low >= high) {
			return;
		}
		
		int center = partition(low, high);
		quicksort(low, center - 1);
		quicksort(center + 1, high);
	}
	
	private static int partition(int low, int high) {
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
	
	public static void main(String[] args) {
		quicksort(0, arr.length - 1);
		
		System.out.println(Arrays.toString(arr));
	}*/
	
	// bubble sort
	/*
	public static void main(String[] args) {
		int n = arr.length;
		
		for (int i = n - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	*/
	
	// insertion sort
	/*
	public static void main(String[] args) {
		
		int key;
		for (int i = 1; i < arr.length; ++i) {
			key = arr[i];
			int j;
			for (j = i - 1; j >= 0; --j) {
				if (key >= arr[j]) break;
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = key;
		}
		
		System.out.println(Arrays.toString(arr));
	}*/
	
	// selection sort
	/*
	public static void main(String[] args) {
		
		
		int n = arr.length;
		int ind;
		for (int i = 0; i < n; ++i) {
			ind = i;
			for (int j = i; j < n; ++j) {
				if (arr[j] < arr[ind])
					ind = j;
			}
			
			swap(arr, ind, i);
		}
		
		System.out.println(Arrays.toString(arr));
	}
*/
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
