package ict_practice_revisit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q20 {

    private static class Pos {
        int y, x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int n;
    private static int[][] map;
    private static List<Pos> obstruction;
    private static List<Pos> teacher;

    private static boolean result = false;

    private static void check() {
        for (Pos t : teacher) {
            int yy = t.y;
            int xx = t.x;
            // northward
            for (int i = yy - 1; i >= 0; --i) {
                if (map[i][xx] == 1)
                    return;
                if (map[i][xx] == 3)
                    break;
            }
            // eastward
            for (int i = xx + 1; i < n; ++i) {
                if (map[yy][i] == 1)
                    return;
                if (map[yy][i] == 3)
                    break;
            }
            // southward
            for (int i = yy + 1; i < n; ++i) {
                if (map[i][xx] == 1)
                    return;
                if (map[i][xx] == 3)
                    break;
            }
            // westward
            for (int i = xx - 1; i >= 0; --i) {
                if (map[yy][i] == 1)
                    return;
                if (map[yy][i] == 3)
                    break;
            }
        }

        result = true;
    }

    private static void doRecursively(int obs) {
        if (obs == 3) {
            check();
            return;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (result) return;

                if (map[i][j] == 3 || map[i][j] == 2 || map[i][j] == 1) continue;

                map[i][j] = 3;
                obstruction.add(new Pos(i, j));
                doRecursively(obs + 1);
                obstruction.remove(obstruction.size() - 1);
                map[i][j] = 0;
            }
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        obstruction = new ArrayList<>();
        teacher = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                char c = st.nextToken().charAt(0);
                if (c == 'X')
                    map[i][j] = 0;
                else if (c == 'S')
                    map[i][j] = 1;
                else {
                    map[i][j] = 2;
                    teacher.add(new Pos(i, j));
                }
            }
        }

        doRecursively(0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (result)
            bw.write("YES");
        else
            bw.write("NO");

        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
