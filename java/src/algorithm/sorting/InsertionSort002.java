package algorithm.sorting;

public class InsertionSort002 {
	
	private static void insertionSort(int[] arr) {
		if (arr.length < 2) return; 
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
	
	public static void main(String[] args) {
		int[] arr = { 9, 3, 99, 392, -3, 0, -3895, 17, 1 };
		insertionSort(arr);
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

}
