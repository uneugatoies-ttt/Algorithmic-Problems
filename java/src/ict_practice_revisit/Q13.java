package ict_practice_revisit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q13 {

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

        public void generateCombination(List<Position> orig, int depth, int index, int target) {
            if (depth == r) {
                List<Position> temp = new ArrayList<>();
                for (int i = 0; i < r; ++i)
                    temp.add(orig.get(curr[i]));
                result.add(temp);
                return;
            }

            if (target == n) return;

            curr[index] = target;
            generateCombination(orig, depth + 1, index + 1, target + 1);
            generateCombination(orig, depth, index, target + 1);
        }

    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int map[][] = new int[n][n];
        List<Position> houses = new ArrayList<>();
        List<Position> chickens = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    houses.add(new Position(i, j));
                else if (map[i][j] == 2)
                    chickens.add(new Position(i, j));
            }
        }
        Combination c = new Combination(chickens.size(), m);
        c.generateCombination(chickens, 0, 0, 0);
        List<List<Position>> chickencombi = c.result;

        int dist = Integer.MAX_VALUE;
        for (List<Position> cc : chickencombi) {
            int tempdist = 0;

            for (Position house : houses) {
                int eachdist = Integer.MAX_VALUE;
                for (Position eachChicken : cc)
                    eachdist = Math.min(eachdist, Math.abs((eachChicken.y+1) - (house.y+1)) + Math.abs((eachChicken.x+1) - (house.x+1)));
                tempdist += eachdist;
            }
            if (tempdist < dist)
                dist = tempdist;
        }

        bw.write(String.valueOf(dist));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }



}
