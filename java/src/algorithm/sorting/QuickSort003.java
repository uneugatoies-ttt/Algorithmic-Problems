package algorithm.sorting;

public class QuickSort003 {
	
	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low >= high) return;
		int pivot = low;
		int left = low + 1;
		int right = high;
		while (left <= right) {
			while (left <= high && arr[left] <= arr[pivot])
				left++;
			while (right > low && arr[right] >= arr[pivot])
				right--;
			if (left > right)
				swap(arr, pivot, right);
			else
				swap(arr, left, right);
		}
		quickSort(arr, low, right - 1);
		quickSort(arr, right + 1, high);
	}
	
	public static void main(String[] args) {
		int[] arr = { 9, 3, 99, 392, -3, 0, -3895, 17, 1 };
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
	
}
