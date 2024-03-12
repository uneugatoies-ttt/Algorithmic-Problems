package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// reference: https://st-lab.tistory.com/235
public class BJ1780_3 {

    private static int n;
    private static int[][] orig;
    private static int minus = 0;
    private static int zero = 0;
    private static int one = 0;

    private static boolean checkColor(int row, int col, int size) {
        int color = orig[row][col];

        for (int i = row; i < row + size; ++i) {
            for (int j = col; j < col + size; ++j)
                if (color != orig[i][j])
                    return false;
        }

        return true;
    }

    private static void divide(int row, int col, int size) {
        if (checkColor(row, col, size)) {
            if (orig[row][col] == - 1)
                minus++;
            else if (orig[row][col] == 0)
                zero++;
            else
                one++;
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < size; i += newSize) {
            for (int j = 0; j < size; j += newSize)
                divide(row + i, col + j, newSize);
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        orig = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j)
                orig[i][j] = Integer.parseInt(st.nextToken());
        }

        divide(0, 0, n);

        bw.write(String.valueOf(minus));
        bw.write("\n");
        bw.write(String.valueOf(zero));
        bw.write("\n");
        bw.write(String.valueOf(one));
        bw.write("\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
