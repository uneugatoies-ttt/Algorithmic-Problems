package ict_practice_revisit;

import java.io.*;
import java.util.*;

public class Q16 {

    private static class Position {
        int y, x;
        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static class Combination {
        int n, r;
        int[] curr;
        List<List<Position>> result;
        public Combination(int n, int r) {
            this.n = n;
            this.r = r;
            this.curr = new int[r];
            this.result = new ArrayList<>();
        }
        public void generateCombination(List<Position> spaces, int depth, int ind, int target) {
            if (depth == r) {
                List<Position> temp = new ArrayList<>();
                for (int i = 0; i < r; ++i)
                    temp.add(spaces.get(curr[i]));
                result.add(temp);
                return;
            }

            if (target == n) return;

            curr[ind] = target;
            generateCombination(spaces, depth + 1, ind + 1, target + 1);
            generateCombination(spaces, depth, ind, target + 1);
        }
    }

    private static int n, m;
    private static int[][] lab;
    private static int result = Integer.MIN_VALUE;
    private static List<List<Position>> combin;
    private static List<Position> spaces;
    private static List<Position> viruses;
    private static int[][] tempLab;
    private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    private static void infect() {
        tempLab = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j)
                tempLab[i][j] = lab[i][j];
        }
        Queue<Position> q = new ArrayDeque<>();
        for (Position virus : viruses)
            q.add(virus);

        while (!q.isEmpty()) {
            int yy = q.peek().y;
            int xx = q.peek().x;
            q.poll();
            tempLab[yy][xx] = 2;

            for (int i = 0; i < 4; ++i) {
                int ny = yy + dir[i][0];
                int nx = xx + dir[i][1];
                if (ny >= n || ny < 0 || nx >= m || nx < 0) continue;
                if (tempLab[ny][nx] == 1 || tempLab[ny][nx] == 2) continue;
                q.add(new Position(ny, nx));
            }
        }

        int tempRes = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j)
                if (tempLab[i][j] == 0) tempRes++;
        }
        if (tempRes > result)
            result = tempRes;
    }

    private static void getGreatestArea() {
        for (List<Position> c : combin) {
            for (int i = 0; i < 3; ++i)
                lab[c.get(i).y][c.get(i).x] = 1;

            infect();

            for (int i = 0; i < 3; ++i)
                lab[c.get(i).y][c.get(i).x] = 0;
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][m];
        spaces = new ArrayList<>();
        viruses = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0)
                    spaces.add(new Position(i, j));
                else if (lab[i][j] == 2)
                    viruses.add(new Position(i, j));
            }
        }

        Combination c = new Combination(spaces.size(), 3);
        c.generateCombination(spaces, 0, 0, 0);
        combin = c.result;

        getGreatestArea();

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
