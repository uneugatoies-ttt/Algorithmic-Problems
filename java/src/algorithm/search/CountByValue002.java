package algorithm.search;

public class CountByValue002 {

    private int findLastIndex(int[] arr, int target, int left, int right) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if ((mid == arr.length - 1 || arr[mid + 1] > target) && arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            return findLastIndex(arr, target, left, mid - 1);
        else
            return findLastIndex(arr, target, mid + 1, right);
    }

    private int findFirstIndex(int[] arr, int target, int left, int right) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if ((mid == 0 || arr[mid - 1] < target) && arr[mid] == target)
            return mid;
        else if (arr[mid] >= target)
            return findFirstIndex(arr, target, left, mid - 1);
        else
            return findFirstIndex(arr, target, mid + 1, right);
    }

    private int countByValue(int[] arr, int target) {
        int first = findFirstIndex(arr, target, 0, arr.length - 1);
        if (first == -1) return 0;
        int last = findLastIndex(arr, target, 0, arr.length - 1);
        if (last == -1) return 1;
        return last - first + 1;
    }

}
