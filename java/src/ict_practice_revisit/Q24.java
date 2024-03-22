package ict_practice_revisit;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q24 {

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        bw.write(String.valueOf(arr[(arr.length-1)/2]));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
