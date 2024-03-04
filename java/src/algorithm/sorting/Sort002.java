package algorithm.sorting;

public class Sort002 {
	
	private static void swap(int[] arr, int ind1, int ind2) {
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	
	private static void doSelectionSort(int[] arr) {
		int minimum;
		
		for (int i = 0; i < arr.length; ++i) {
			minimum = i;
			
			for (int j = i + 1; j < arr.length; ++j)
				if (arr[minimum] > arr[j])
					minimum = j;

			if (i != minimum)
				swap(arr, i, minimum);
		}
	}
	
	private static void doInsertionSort(int[] arr) {
		int key, j;
		for (int i = 1; i < arr.length; ++i) {
			key = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low;
		for (int j = low; j < high; ++j) {
			if (arr[j] <= pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, high);
		return i;
	}
	
	private static void doQuickSort(int[] arr, int low, int high) {
		if (low >= high) return;
		int pi = partition(arr, low, high);
		doQuickSort(arr, low, pi - 1);
		doQuickSort(arr, pi + 1, high);
	}
	
	private static void doBubbleSort(int[] arr) {
		for (int i = arr.length - 1; i >= 0; --i) {
			for (int j = 0; j < i; ++j) 
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };
		doQuickSort(arr, 0, arr.length - 1);
		
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
	
}
