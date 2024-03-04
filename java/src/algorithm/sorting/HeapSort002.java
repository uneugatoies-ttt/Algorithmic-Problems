package algorithm.sorting;

import java.util.Arrays;

public class HeapSort002 {

    private static void heapify(int[] h, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && h[left] > h[largest]) {
            largest = left;
        }

        if (right < size && h[right] > h[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(h, i, largest);
            heapify(h, size, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void heapSort(int[] arr) {
        int size = arr.length;

        // Build max heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }

        // Extract elements one by one from the heap
        for (int i = size - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
    	int[] arr = { 4, -3, 4, 1, 9, 79, 2, -38, 6, 0, 18 };
        heapSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}