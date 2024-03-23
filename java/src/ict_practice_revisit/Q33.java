package ict_practice_revisit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q33 {

    private static int[] dp;
    private static int[] time;

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        time = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.parseInt(st.nextToken());
            if (time[i] + i > n + 1)
                dp[i] = 0;
        }

        for (int i = 2; i <= n; ++i) {
            int temp = 0;

            for (int j = i - 1; j > 0; --j) {
                if (time[j] + j <= i)
                    temp = Math.max(temp, dp[j]);
            }
            dp[i] += temp;
        }

        int mx = -1;
        for (int i = 1; i <= n; ++i)
            mx = Math.max(mx, dp[i]);
        System.out.println(mx);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
