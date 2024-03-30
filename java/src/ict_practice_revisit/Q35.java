package ict_practice_revisit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Q35 {

    private static void solve() throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int[] ugly = new int[n];

        ugly[0] = 1;
        int ind2 = 0, ind3 = 0, ind5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; ++i) {
            ugly[i] = Math.min(next2, Math.min(next3, next5));
            if (ugly[i] == next2) {
                ind2++;
                next2 = ugly[ind2] * 2;
            }
            if (ugly[i] == next3) {
                ind3++;
                next3 = ugly[ind3] * 3;
            }
            if (ugly[i] == next5) {
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