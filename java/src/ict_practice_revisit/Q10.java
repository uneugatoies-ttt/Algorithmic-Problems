package ict_practice_revisit;

import java.util.Scanner;

public class Q10 {

    private int[][] turnKey(int[][] key, int m) {
        int[][] newkey = new int[m][m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j)
                newkey[i][j] = key[m-j-1][i];
        }
        return newkey;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        int[][] expanded = new int[3 * n][3 * n];
        for (int i = n; i < 2 * n; ++i) {
            for (int j = n; j < 2 * n; ++j)
                expanded[i][j] = lock[i - n][j - n];
        }

        for (int k = 0; k < 4; ++k) {
            for (int i = 0; i <= 3 * n - m; ++i) {
                for (int j = 0; j <= 3 * n - m; ++j) {
                    for (int y = 0; y < m; ++y) {
                        for (int x = 0; x < m; ++x)
                            expanded[i + y][j + x] += key[y][x];
                    }

                    boolean flag = true;
                    for (int ii = n; ii < 2 * n; ++ii) {
                        for (int jj = n; jj < 2 * n; ++jj) {
                            if (expanded[ii][jj] != 1) {
                                flag = false;
                                break;
                            }
                        }
                        if (!flag) break;
                    }

                    if (flag) return true;

                    for (int ii = n; ii < 2 * n; ++ii) {
                        for (int jj = n; jj < 2 * n; ++jj)
                            expanded[ii][jj] = lock[ii - n][jj - n];
                    }
                }
            }
            key = turnKey(key, m);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] key = new int[m][m];
        int[][] lock = new int[n][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j)
                key[i][j] = sc.nextInt();
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j)
                lock[i][j] = sc.nextInt();
        }

        Q10 q = new Q10();
        System.out.println(q.solution(key, lock));
    }

}
