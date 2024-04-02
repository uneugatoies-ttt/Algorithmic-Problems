package ict_practice_revisit;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q38 {

    private static int n, m;
    private static final int INF = (int) 1e9;
    private static int[][] dist;

    private static void floydWarshall() {
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        StringTokenizer st;
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            dist[from][to] = Math.min(dist[from][to], d);
        }

        floydWarshall();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dist[i][j] == INF)
                    sb.append('0');
                else
                    sb.append(dist[i][j]);

                if (j != n - 1)
                    sb.append(' ');
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
