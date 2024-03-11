package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// memory limit exceeded
/*
public class BJ1780 {

    private static class Position {
        int y, x;
        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static int[][] orig;

    private static void divide(List<List<Position>> list, int yy, int xx, int side) {
        List<Position> smallerList;
        for (int k = 0; k < side; k += (side / 3)) {
            for (int i = 0; i < side; i += (side/3)) {
                smallerList = new ArrayList<>();
                for (int j = 0; j < side/3; ++j)
                    for (int jj = 0; jj < side/3; ++jj)
                        smallerList.add(new Position(yy + k + j, xx + i + jj));
                list.add(smallerList);
            }
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<List<Position>> list = new ArrayList<>();
        orig = new int[n][n];
        list.add(new ArrayList<>());
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                orig[i][j] = Integer.parseInt(st.nextToken());
                list.get(0).add(new Position(i, j));
            }
        }

        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int i = 0; i < list.size(); ++i) {
                int ttt = orig[list.get(i).get(0).y][list.get(i).get(0).x];
                int yy = list.get(i).get(0).y;
                int xx = list.get(i).get(0).x;
                int size = list.get(i).size();
                int side = (int) Math.sqrt(size);
                if (size == 1) continue;
                int j;
                for (j = 1; j < size; ++j) {
                    if (orig[list.get(i).get(j).y][list.get(i).get(j).x] != ttt) {
                        list.remove(i);
                        divide(list, yy, xx, side);
                        break;
                    }
                }
                if (j < size)
                    flag = false;
            }
        }
        int minuscnt = 0, zerocnt = 0, onecnt = 0;
        for (List<Position> l : list) {
            if (orig[l.get(0).y][l.get(0).x] == -1)
                minuscnt++;
            else if (orig[l.get(0).y][l.get(0).x] == 0)
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
*/