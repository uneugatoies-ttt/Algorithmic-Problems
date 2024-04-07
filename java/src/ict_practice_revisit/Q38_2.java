package ict_practice_revisit;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


/*
    -> If a node B is reachable from another node A, it would mean that A's grade is less than B's;
    i.e., the two grades can be compared.

    Using this trait, we can check the "dist" array after applying the Floyd Warshall algorithm on the given
    graph, if "dist[i][j]" and "dist[j][i]" are the same as INF; if they are, they are not comparable; otherwise,
    increment the "cnt" variable.
*/
public class Q38_2 {

    private static final int INF = (int) 1e9;
    private static List<List<Integer>> adj;
    private static int[][] dist;
    private static int n, m;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n][n];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            dist[from][to] = 1;
        }

        floydWarshall();

        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            boolean flag = true;
            for (int j = 0; j < n; ++j) {
                if (dist[i][j] == INF) {
                    if (dist[j][i] == INF) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
