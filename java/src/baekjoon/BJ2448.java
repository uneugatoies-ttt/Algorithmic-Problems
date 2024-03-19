package baekjoon;

import java.io.*;

public class BJ2448 {

    private static int[][] result;

    private static void formTri(int y, int x) {
        result[y][x + 2] = 2;
        result[y+1][x+1] = 2;
        result[y+1][x+3] = 2;
        result[y+2][x] = 2;
        result[y+2][x+1] = 2;
        result[y+2][x+2] = 2;
        result[y+2][x+3] = 2;
        result[y+2][x+4] = 2;
    }

    private static void doRecursively(int horiz, int verti, int y, int x) {
        if (horiz == 6 && verti == 3) {
            formTri(y, x);
            return;
        }
        int newhoriz = horiz / 2;
        int newverti = verti / 2;

        doRecursively(newhoriz, newverti, y, x + (newhoriz/2));
        doRecursively(newhoriz, newverti, y + newverti, x);
        doRecursively(newhoriz, newverti, y + newverti, x + newhoriz);
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        result = new int[n][n*2];

        doRecursively(n * 2, n, 0, 0);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n * 2; ++j) {
                if (result[i][j] == 2)
                    bw.write('*');
                else
                    bw.write(' ');
            }
            bw.write('\n');
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
