package ict_practice_revisit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q26 {

    private static int n;
    private static int[] bundles;

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; ++i)
            q.add(Integer.parseInt(br.readLine()));
        int mn1, mn2, temp;
        int result = 0;
        while (q.size() > 1) {
            mn1 = q.poll();
            mn2 = q.poll();
            temp = mn1 + mn2;
            result += temp;
            q.add(temp);
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}


// Completely incorrect; my idea was so naive and stupid. Although I already know,
// it's worth to remind myself that more profound contemplation is required to solve
// problems in general. Superficiality must be dismissed.
/*
public class Q26 {

    private static int n;
    private static int[] bundles;

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bundles = new int[n];
        for (int i = 0; i < n; ++i) {
            bundles[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(bundles[0]);
            return;
        }
        Arrays.sort(bundles);
        int result = bundles[0] * (n-1);
        for (int i = 1; i < n; ++i) {
            result += (bundles[i] * (n-i));
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
*/