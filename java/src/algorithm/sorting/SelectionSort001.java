package algorithm.sorting;

public class SelectionSort001 {
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; ++i) {
			int indexLeast = i;
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[j] < arr[indexLeast])
					indexLeast = j;
			}
			if (i != indexLeast) swap(arr, i, indexLeast);
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = { 39, 5, 71, 901, 3, 24, 76, 1 };
		selectionSort(arr);
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
