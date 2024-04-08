package ict_practice_revisit;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q39 {

    private static class Pos {
        public int y;
        public int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static final int INF = (int) 1e9;
    private static int[][] map = new int[126][126];
    private static int[][] dist = new int[126][126];
    private static int n;
    private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    private static void search() {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(0, 0));

        while (!q.isEmpty()) {
            int yy = q.peek().y;
            int xx = q.peek().x;
            q.poll();

            for (int i = 0; i < 4; ++i) {
                int ny = yy + dir[i][0];
                int nx = xx + dir[i][1];

                if (ny > n - 1 || ny < 0 || nx > n - 1 || nx < 0)
                    continue;

                int cost = dist[yy][xx] + map[ny][nx];
                if (cost < dist[ny][nx]) {
                    dist[ny][nx] = cost;
                    q.add(new Pos(ny, nx));
                }
            }
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; ++i) {
                Arrays.fill(dist[i], INF);
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; ++j)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
            dist[0][0] = map[0][0];

            search();

            sb.append(String.valueOf(dist[n-1][n-1]));
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
