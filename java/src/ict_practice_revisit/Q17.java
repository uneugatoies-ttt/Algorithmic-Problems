package ict_practice_revisit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q17 {

    private static class Position {
        int y, x;
        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int n, k;
    private static int second;
    private static int[][] orig;
    private static List<List<Position>> viruses;
    private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    private static void infectEach(List<Position> v, int type) {
        List<Position> temp = new ArrayList<>();
        for (Position p : v) {
            int yy = p.y;
            int xx = p.x;
            for (int i = 0; i < 4; ++i) {
                int ny = yy + dir[i][0];
                int nx = xx + dir[i][1];
                if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;
                if (orig[ny][nx] != 0) continue;
                orig[ny][nx] = type;
                temp.add(new Position(ny, nx));
            }
        }
        v.clear();
        v.addAll(temp);
    }

    private static void infect() {
        for (int i = 0; i < second; ++i) {
            for (int j = 1; j <= k; ++j)
                infectEach(viruses.get(j), j);
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        orig = new int[n][n];
        viruses = new ArrayList<>();
        for (int i = 0; i <= k; ++i)
            viruses.add(new ArrayList<>());

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                orig[i][j] = Integer.parseInt(st.nextToken());
                if (orig[i][j] == 0) continue;
                viruses.get(orig[i][j]).add(new Position(i, j));
            }
        }

        st = new StringTokenizer(br.readLine());
        second = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;

        infect();

        bw.write(String.valueOf(orig[y][x]));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
