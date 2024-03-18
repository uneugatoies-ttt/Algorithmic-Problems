package baekjoon;

import java.io.*;

public class BJ2447 {

    // 2 means a void; 0 means a star.
    private static int[][] result;

    private static void makeHole(int n, int y, int x) {
        int tri = n / 3;
        for (int i = y + tri; i < y + tri * 2; ++i) {
            for (int j = x + tri; j < x + tri * 2; ++j)
                result[i][j] = 2;
        }
    }
    private static void doRecursively(int n, int y, int x) {
        makeHole(n, y, x);
        if (n == 3) return;

        int tri = n / 3;
        for (int i = 0; i < n; i += tri) {
            for (int j = 0; j < n; j += tri) {
                if (i == tri && j == tri) continue;
                doRecursively(tri, y + i, x + j);
            }
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        result = new int[n][n];
        doRecursively(n, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (result[i][j] == 2)
                    sb.append(' ');
                else
                    sb.append('*');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
