package ict_practice_revisit;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q29_3 {

    private static int n, c;
    private static int[] houses;

    private static int bs() {
        int left = 1, right = houses[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            int routerCnt = 1;
            int prev = 0;
            for (int i = 1; i < n; ++i) {
                if (houses[i] - houses[prev] >= mid) {
                    routerCnt++;
                    prev = i;
                }
            }

            if (routerCnt >= c)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left - 1;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        houses = new int[n];
        for (int i = 0; i < n; ++i)
            houses[i] = Integer.parseInt(br.readLine());

        Arrays.sort(houses);
        int result = bs();

        bw.write(String.valueOf(result));
        bw.write('\n');
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
