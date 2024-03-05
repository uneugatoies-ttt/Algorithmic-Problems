package ict_practice_revisit;

import java.io.*;
import java.util.*;


/*
    A few things must be noted with this problem:
    1) Using a queue, instead of other data structures.

    2) Representing the spaces occupied by the snake as the integer "2" in the "map".

    3) Defining the direction-changing operation as a separate procedure.

    4) Using two custom classes: "DirChange" which represents the timing of the direction-changing,
    and "Position" which represents a coordinate on the 2-dimensional plane.


    But, it's still unknown why the former submission (the class named "Q11" in the same package)
    was wrong; I'd like to know the reason. IWAAIL.
*/


public class Q11_2 {

    private static class DirChange {
        int time;
        char direction;
        public DirChange(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    private static class Position {
        int y, x;
        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int n, k, l;
    private static int[][] map = new int[100][100];
    private static List<DirChange> dirChange = new ArrayList<>();
    private static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    private static int turn(int direction, char c) {
        if (c == 'L')
            direction = (direction == 0) ? 3 : direction - 1;
        else
            direction = (direction + 1) % 4;
        return direction;
    }

    private static int simulate() {
        int y = 0, x = 0;
        map[y][x] = 2;
        int direction = 1;
        int time = 0;
        int ind = 0;

        Queue<Position> q = new ArrayDeque<>();
        q.add(new Position(y, x));

        while (true) {
            int ny = y + dir[direction][0];
            int nx = x + dir[direction][1];

            if (ny >= 0 && ny < n && nx >= 0 && nx < n && map[ny][nx] != 2) {
                if (map[ny][nx] == 0) {
                    map[ny][nx] = 2;
                    q.add(new Position(ny, nx));
                    Position prev = q.poll();
                    map[prev.y][prev.x] = 0;
                } else if (map[ny][nx] == 1) {
                    map[ny][nx] = 2;
                    q.add(new Position(ny, nx));
                }
            } else {
                time++;
                break;
            }

            y = ny;
            x = nx;
            time++;

            if (ind < l && time == dirChange.get(ind).time) {
                direction = turn(direction, dirChange.get(ind).direction);
                ind++;
            }
        }

        return time;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; ++i) {
            st = new StringTokenizer(br.readLine());
            dirChange.add(new DirChange(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }

        bw.write(String.valueOf(simulate()));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
