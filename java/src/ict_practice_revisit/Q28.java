package ict_practice_revisit;

import java.io.*;
import java.util.*;

public class Q28 {

    private static int bs(int n, int[] arr) {
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == mid)
                return mid;
            else if (arr[mid] > mid)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return -1;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        int result = bs(n, arr);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }


}
