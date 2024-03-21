package ict_practice_revisit;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Q21 {

    private static class Pos {
        int y, x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
}

    private static int n, ll, rr;
    private static int cnt = 0;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<List<Pos>> unions = new ArrayList<>();
    private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    private static void formUnions(int y, int x, List<Pos> temp) {
        visited[y][x] = true;
        temp.add(new Pos(y, x));
        for (int i = 0; i < 4; ++i) {
            int ny = dir[i][0] + y;
            int nx = dir[i][1] + x;
            if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;
            if (visited[ny][nx]) continue;
            int diff = Math.abs(map[y][x] - map[ny][nx]);
            if (diff >= ll && diff <= rr)
                formUnions(ny, nx, temp);
        }
    }

    private static void formUnionsInit() {
        while (true) {
            for (int i = 0; i < n; ++i)
                Arrays.fill(visited[i], false);

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (!visited[i][j]) {
                        List<Pos> temp = new ArrayList<>();
                        formUnions(i, j, temp);
                        if (temp.size() > 1)
                            unions.add(temp);
                    }
                }
            }

            if (unions.size() == 0) break;

            cnt++;

            for (List<Pos> union : unions) {
                int population = 0;
                for (Pos p : union) {
                    population += map[p.y][p.x];
                }
                population = population / union.size();

                for (Pos p : union) {
                    map[p.y][p.x] = population;
                }
            }

            unions.clear();
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ll = Integer.parseInt(st.nextToken());
        rr = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        formUnionsInit();

        bw.write(String.valueOf(cnt) + "\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}