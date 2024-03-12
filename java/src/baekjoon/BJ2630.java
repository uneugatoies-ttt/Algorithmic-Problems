package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2630 {

    private static class Piece {
        int y, x;
        int size;
        int side;
        public Piece(int y, int x, int size) {
            this.y = y;
            this.x = x;
            this.size = size;
            this.side = (int)Math.sqrt(size);
        }
    }

    private static int n;
    private static int[][] orig;
    private static List<Piece> pieces = new ArrayList<>();

    private static void divide(List<Piece> list, int yy, int xx, int size, int side) {
        for (int i = 0; i < side; i += (side / 2)) {
            for (int j = 0; j < side; j += (side / 2))
                list.add(new Piece(yy + i, xx + j, size / 4));
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        orig = new int[n][n];
        pieces.add(new Piece(0, 0, n * n));
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j)
                orig[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int i = 0; i < pieces.size(); ++i) {
                int ttt = orig[pieces.get(i).y][pieces.get(i).x];
                int yy = pieces.get(i).y;
                int xx = pieces.get(i).x;
                int size = pieces.get(i).size;
                int side = pieces.get(i).side;
                if (size == 1) continue;
                int j;
                boolean innerflag = true;
                for (j = 0; j < side; ++j) {
                    for (int jj = 0; jj < side; ++jj) {
                        if (orig[yy+j][xx+jj] != ttt){
                            pieces.remove(i);
                            divide(pieces, yy, xx, size, side);
                            innerflag = false;
                            break;
                        }
                    }
                    if (!innerflag)
                        break;
                }
                if (!innerflag)
                    flag = false;
            }
        }

        int blue = 0, white = 0;
        for (Piece p : pieces) {
            int yy = p.y;
            int xx = p.x;
            if (orig[yy][xx] == 1)
                blue++;
            else
                white++;
        }

        bw.write(String.valueOf(white));
        bw.write("\n");
        bw.write(String.valueOf(blue));
        bw.write("\n");
        bw.flush();


    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
