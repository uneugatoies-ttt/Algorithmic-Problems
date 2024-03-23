package ict_practice_revisit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q32 {

    private static int[][] tri;
    private static int[][] dp;

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tri = new int[n][n];
        dp = new int[n][n];
        tri[0][0] = Integer.parseInt(br.readLine());
        dp[0][0] = tri[0][0];
        StringTokenizer st;
        for (int i = 1; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; ++j)
                tri[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i-1][0] + tri[i][0];
            for (int j = 1; j < i; ++j) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
            }
            dp[i][i] = dp[i-1][i-1] + tri[i][i];
        }

        int result = -1;
        for (int i = 0; i < n; ++i) {
            result = Math.max(result, dp[n-1][i]);
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
