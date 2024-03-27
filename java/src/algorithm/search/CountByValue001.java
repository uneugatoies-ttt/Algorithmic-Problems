package algorithm.search;

import java.util.Arrays;

public class CountByValue001 {

    // This method finds the first index of elements whose value is equal to "target".
    private static int findFirstIndex(int[] arr, int target, int left, int right) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        // The OR condition indicates the case where the "mid" index is the first index in "arr"
        // or the element at the left of "mid" is less than "target".
        if ((mid == 0 || arr[mid - 1] < target) && arr[mid] == target)
            return mid;
        else if (arr[mid] >= target)
            return findFirstIndex(arr, target, left, mid - 1);
        else
            return findFirstIndex(arr, target, mid + 1, right);
    }

    // This method finds the last index of elements whose value is equal to "target"
    private static int findLastIndex(int[] arr, int target, int left, int right) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if ((mid == arr.length - 1 || arr[mid + 1] > target) && arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            return findLastIndex(arr, target, left, mid - 1);
        else
            return findLastIndex(arr, target, mid + 1, right);
    }

    private static int countByValue(int[] arr, int target) {
        int n = arr.length;
        int first = findFirstIndex(arr, target, 0, n - 1);
        if (first == -1) return 0;
        int last = findLastIndex(arr, target, 0, n - 1);
        if (last == -1) return 1;
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 6, 1, 5, 5, 5, 3, 5, 2, 6, 8, 9, 10, 2, 3, 2, 1, 5, 7, 6, 9, 2, 10, 10 };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(countByValue(arr, 5));

    }

}
