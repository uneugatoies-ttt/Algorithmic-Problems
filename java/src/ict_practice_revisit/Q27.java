package ict_practice_revisit;

import java.io.*;
import java.util.*;


public class Q27 {

    // This method finds the first index of elements whose value is equal to "target".
    private static int findFirstIndex(int[] arr, int target, int left, int right) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
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

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int result = countByValue(arr, target);

        if (result == 0)
            result = -1;

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}



// Not sure whether this is right or wrong.
/*
public class Q27 {

    private static int n, target;
    private static int[] array;
    private static int result = -1;

    private static void bs() {
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == array[mid]) {
                result = 1;
                int temp = mid - 1;
                while (temp >= 0 && array[temp] == target) {
                    result++;
                    temp--;
                }
                temp = mid + 1;
                while (temp < n && array[temp] == target) {
                    result++;
                    temp++;
                }
                return;
            }

            if (target < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            array[i] = Integer.parseInt(st.nextToken());

        bs();

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}*/