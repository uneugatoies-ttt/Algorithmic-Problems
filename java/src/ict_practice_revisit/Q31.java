package ict_practice_revisit;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q31 {

    private static int[][] mine = new int[21][21];
    private static int[][] gold = new int[21][21];
    private static int n, m;

    private static int doDPAndFindMax() {
        for (int i = 0; i < n; ++i)
            gold[i][0] = mine[i][0];

        for (int j = 1; j < m; ++j) {
            gold[0][j] = Math.max(gold[0][j-1], gold[1][j-1]) + mine[0][j];
            for (int i = 1; i < n - 1; ++i) {
                gold[i][j] = Math.max(gold[i-1][j-1], Math.max(gold[i][j-1], gold[i+1][j-1])) + mine[i][j];
            }
            gold[n-1][j] = Math.max(gold[n-2][j-1], gold[n-1][j-1]) + mine[n-1][j];
        }

        int result = -10;
        for (int i = 0; i < n; ++i)
            result = Math.max(result, gold[i][m-1]);
        return result;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; ++i) {
                Arrays.fill(gold[i], 0);
                for (int j = 0; j < m; ++j)
                    mine[i][j] = Integer.parseInt(st.nextToken());
            }

            int result = doDPAndFindMax();

            sb.append(String.valueOf(result) + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
