package algorithm.sorting;

public class InsertionSort001 {
	/*
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; ++i) {
			int temp = arr[i];
			int j = i - 1;
			while ( j >= 0 ) {
				if ( temp >= arr[j] ) break;
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}*/
	
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; ++i) {
			int temp = arr[i];
			int j = i - 1;
			while ( j >= 0 && temp < arr[j] ) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 9, 35, 1, 5, 99, 555, 1, 73 };
		insertionSort(arr);
		
		for (int i : arr)
			System.out.println(i);
	}

}
