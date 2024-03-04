package algorithm.sorting;

public class Sort001 {
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	// heap begins
	public static void maxHeapify(int[] arr, int size, int index) {
		int max = index;
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		if (left < size && arr[left] > arr[max])
			max = left;
		if (right < size && arr[right] > arr[max])
			max = right;
		
		if (max != index) {
			swap(arr, max, index);
			maxHeapify(arr, size, max);
		}
	}
	
	public static void heap(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; --i)
			maxHeapify(arr, arr.length, i);
		
		for (int i = arr.length - 1; i > 0; --i) {
			swap(arr, i, 0);
			maxHeapify(arr, i, 0);
		}
	}
	// heap ends
	
	// quick begins
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low;
		for (int j = low; j < high; ++j) {
			if (arr[j] <= pivot) {
				swap(arr, j, i);
				i++;
			}
		}
		swap(arr, i, high);
		return i;
	}
	
	public static void quick(int[] arr, int low, int high) {
		if (low >= high) return;
		int pi = partition(arr, low, high);
		quick(arr, low, pi - 1);
		quick(arr, pi + 1, low);
	}
	// quick ends
	
	public static void insertion(int[] arr) {
		for (int i = 1; i < arr.length; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 57, 699, 6001, 5, 102, 39, 98, 2873 };
		
		heap(arr);
		
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

}


