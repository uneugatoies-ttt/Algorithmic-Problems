package baekjoon;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// time limit exceeded
public class BJ1780_2 {

    private static class Piece {
        // Starting point's coordinate
        int y, x;
        int size;
        int side;
        public Piece(int y, int x, int size, int side) {
            this.y = y;
            this.x = x;
            this.size = size;
            this.side = side;
        }
    }

    public static int[][] orig;

    private static void divide(List<Piece> list, int yy, int xx, int size, int side) {
        for (int i = 0; i < side; i += (side / 3)) {
            for (int j = 0; j < side; j += (side / 3))
                list.add(new Piece(yy + i, xx + j, size / 9, (int) Math.sqrt(size / 9)));
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Piece> list = new ArrayList<>();
        orig = new int[n][n];
        list.add(new Piece(0, 0, n * n, n));
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j)
                orig[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int i = 0; i < list.size(); ++i) {
                int ttt = orig[list.get(i).y][list.get(i).x];
                int yy = list.get(i).y;
                int xx = list.get(i).x;
                int size = list.get(i).size;
                int side = list.get(i).side;
                if (size == 1) continue;
                int j;
                boolean innerflag = true;
                for (j = 0; j < side; ++j) {
                    for (int jj = 0; jj < side; ++jj) {
                        if (orig[yy+j][xx+jj] != ttt){
                            list.remove(i);
                            divide(list, yy, xx, size, side);
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
        int minuscnt = 0, zerocnt = 0, onecnt = 0;
        for (Piece p : list) {
            int yy = p.y;
            int xx = p.x;
            if (orig[yy][xx] == -1)
                minuscnt++;
            else if (orig[yy][xx] == 0)
                zerocnt++;
            else
                onecnt++;
        }

        bw.write(String.valueOf(minuscnt));
        bw.write("\n");
        bw.write(String.valueOf(zerocnt));
        bw.write("\n");
        bw.write(String.valueOf(onecnt));
        bw.write("\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
