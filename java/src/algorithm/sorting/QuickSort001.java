package algorithm.sorting;

public class QuickSort001 {
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static int partition(int[] arr, int lo, int hi) {
		int i = lo;
		for (int j = lo; j < hi; ++j) {
			if (arr[j] < arr[hi]) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, hi);
		return i;
	}
	
	public static void quickSort(int[] arr, int lo, int hi) {
		if (lo < hi) {
			int pi = partition(arr, lo, hi);
			quickSort(arr, lo, pi - 1);
			quickSort(arr, pi + 1, hi);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 39, 5, 71, 901, 3, 24, 76, 1 };
		quickSort(arr, 0, arr.length - 1);
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}

}
