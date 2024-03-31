package ict_practice_revisit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    -> I still don't understand this thing.
    The given explanation accounts that the 3 parameters that are passed to
    the "min" function indicate the insertion, deletion, and replacement operation,
    respectively. The original recurrence relation is as follows:

    1) If two corresponding characters are the same:
        dp[i][j] = dp[i-1][j-1]
    2) Otherwise:
        dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])

    But I really couldn't understand this. How can those parameters
    indicate those operations?

    -> I can see the fact that it works by some experiment with test cases,
    but I don't understand HOW it works; as of now, this solution feels like
    some kind of black box to me.

    The bewilderment that I've got from this explanation is tremendously great;
    I think it is among the greatest of all similar feelings that I've got
    from other problems that I've encountered.
*/
public class Q36 {

    private static int moddist(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; ++i)
            dp[i][0] = i;
        for (int j = 1; j < m + 1; ++j)
            dp[0][j] = j;

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < m + 1; ++j) {
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
            }
        }

        return dp[n][m];
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        System.out.println(moddist(A, B));
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
