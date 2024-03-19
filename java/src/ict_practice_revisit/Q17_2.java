package ict_practice_revisit;

import java.io.*;
import java.util.*;

// If you just put all viruses into a single structure and sort them
// according to their virus types, then you don't have to keep a structure
// for each virus type; this is way more efficient than the initial idea
// that I could have thought of.

// I think that applying the sorting process just once at the beginning would be enough;
// you don't have to sort every time an infection process is over.

// And you don't have to use the PriorityQueue; use ArrayDeque instead.
public class Q17_2 {

    private static class Point {
        int y, x;
        int time;
        public Point(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }

    }

    private static int n, k;
    private static int second;
    private static int[][] cosy;
    private static List<int[]> viruses = new ArrayList<>();
    private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cosy = new int[n][n];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                cosy[i][j] = Integer.parseInt(st.nextToken());
                if (cosy[i][j] != 0)
                    viruses.add(new int[] {i, j});
            }
        }

        st = new StringTokenizer(br.readLine());
        second = Integer.parseInt(st.nextToken());
        int yres = Integer.parseInt(st.nextToken());
        int xres = Integer.parseInt(st.nextToken());

        Collections.sort(viruses,
            (o1, o2) ->
                Integer.compare(cosy[o1[0]][o1[1]], cosy[o2[0]][o2[1]])
        );

        Queue<Point> q = new ArrayDeque<>();
        for (int[] n : viruses)
            q.add(new Point(n[0], n[1], 0));

        while (!q.isEmpty()) {
            Point curr = q.poll();

            if (curr.time < second) {
                for (int i = 0; i < 4; ++i) {
                    int ny = curr.y + dir[i][0];
                    int nx = curr.x + dir[i][1];

                    if (ny >= n || ny < 0 || nx >= n || nx < 0) continue;
                    if (cosy[ny][nx] != 0) continue;

                    cosy[ny][nx] = cosy[curr.y][curr.x];
                    q.offer(new Point(ny, nx, curr.time + 1));
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cosy[yres - 1][xres - 1]));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
