package algorithm.sorting;

public class QuickSort002 {
	
	private static void swap(int[] arr, int ind1, int ind2) {
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
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
				swap(arr, right, pivot);
			else 
				swap(arr, left, right);
		}
		quickSort(arr, low, right - 1);
		quickSort(arr, right + 1, high);
	}
	
	public static void main(String[] args) {
		int[] arr = { 5, 7, 9, 0, 3, 1, 6, 2, 4, 8 };
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

}
