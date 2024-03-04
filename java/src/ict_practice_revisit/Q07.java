package ict_practice_revisit;

import java.util.Scanner;

public class Q07 {

    private static void solve() {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int len = n.length();
        int left = 0, right = 0;
        for (int i = 0; i < len / 2; ++i) {
            left += (n.charAt(i) - '0');
            right += (n.charAt(len - i - 1) - '0');
        }

        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }

    public static void main(String[] args) {
        solve();
    }

}
