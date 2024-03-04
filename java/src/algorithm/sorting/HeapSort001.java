package algorithm.sorting;

public class HeapSort001 {
	
	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	private static void heapify(int[] h, int i, int size) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if (left < size && h[left] > h[largest])
			largest = left;
		if (right < size && h[right] > h[largest])
			largest = right;
		
		if (largest != i) {
			swap(h, i, largest);
			heapify(h, largest, size);
		}
	}
	
	private static void heapSort(int[] arr) {
		int size = arr.length;
		
		for (int i = size / 2 - 1; i >= 0; --i)
			heapify(arr, i, size);
		
		for (int i = size - 1; i >= 0; --i) {
			swap(arr, 0, i);
			heapify(arr, 0, i);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 4, -3, 4, 1, 9, 79, 2, -38, 6, 0, 18 };
		int[] arr2 = { 12, 11, 13, 5, 6, 7 };
		heapSort(arr);
		for (int i : arr)
			System.out.print(i + " ");
	}

	
	
	// Initial attempt
	// Wrong because heapify procedure is incorrect;
	// it must know the largest among the three, and ensure 
	// the largest value is placed at the parent.
	/*
	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	private static void heapify(int[] h, int size) {
		if (size <= 1) return;
		int p;
		for (int i = size - 1; i > 0; --i) {
			p = (i - 1) / 2;
			if (h[p] < h[i])
				swap(h, p, i);
		}
	}
	
	private static void heapSort(int[] arr) {
		int size = arr.length;
		int[] h = Arrays.copyOf(arr, size);
		while (size > 0) {
			heapify(h, size);
			swap(h, 0, size - 1);
			arr[size - 1] = h[size - 1];
			size--;
		}
	}*/

}
