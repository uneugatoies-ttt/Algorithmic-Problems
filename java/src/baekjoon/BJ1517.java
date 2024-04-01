package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    -> The merging process is always done with the two arrays:
    "left" and "right" that represent the left half and the right half, respectively.

    In this case, if the element at "r" is less than the element at "l", it would mean
    that the swapping operation will be done "left.length - l" times so that the element
    at "r" will be placed on the left side of the element at "l".

    And since the merging process is always done when the sorting process on the both
    sides was finished, the elements in the "left" that are on the right of "l" will
    naturally be greater than the element at "r".


    -> Beware of the possible condition of the numbers used in the problem;
    the data type of the "result" and other smaller parts of the "result" must be "long".
*/
public class BJ1517 {

    private static long merge(int[] arr, int[] left, int[] right) {
        int l = 0;
        int r = 0;
        long invCount = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (r >= right.length || (l < left.length && left[l] <= right[r])) {
                arr[i] = left[l];
                l++;
            } else {
                arr[i] = right[r];
                r++;
                invCount += left.length - l;
            }
        }

        return invCount;
    }
    private static long mergeSort(int[] arr) {
        if (arr.length <= 1) return 0;

        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        long invLeft = mergeSort(left);
        long invRight = mergeSort(right);
        long invMerge = merge(arr, left, right);

        return invLeft + invRight + invMerge;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        long result = mergeSort(arr);

        System.out.println(result);

    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
