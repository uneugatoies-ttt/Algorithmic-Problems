package algorithm.sorting;

public class BubbleSort001 {
	public static void bubbleSortFromTheLeast(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			for (int j = arr.length-1; j > i; --j) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}
	
	public static void bubbleSortFromTheGreatest(int[] arr) {
		for (int i = arr.length-1; i > 1; --i) {
			for (int j = 0; j < i; ++j) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = { 9, 35, 1, 5, 99, 555, 1, 73 };
		int[] arr1 = { 9, 35, 1, 5, 99, 555, 1, 73 };

		bubbleSortFromTheLeast(arr);
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println("\n\n\n");
		
		bubbleSortFromTheGreatest(arr1);
		for (int i : arr1)
			System.out.print(i + " ");
		
	}
}
