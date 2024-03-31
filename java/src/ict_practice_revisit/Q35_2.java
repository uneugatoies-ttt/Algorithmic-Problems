package ict_practice_revisit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q35_2 {

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ugly = new int[n];

        ugly[0] = 1;
        int ind2 = 0, ind3 = 0, ind5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; ++i) {
            ugly[i] = Math.min(next2, Math.min(next3, next5));

            // All condition statements must exclusively be composed of "if";
            // there must not be "else if" or else".
            // By doing this, you can prevent the same numbers from being inserted
            // into "ugly" more than once.
            if (next2 == ugly[i]) {
                ind2++;
                next2 = ugly[ind2] * 2;
            }

            if (next3 == ugly[i]) {
                ind3++;
                next3 = ugly[ind3] * 3;
            }

            if (next5 == ugly[i]) {
                ind5++;
                next5 = ugly[ind5] * 5;
            }
        }

        System.out.println(ugly[n - 1]);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
