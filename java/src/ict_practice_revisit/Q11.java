package ict_practice_revisit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



// failed attempt; I couldn't find the wrong part.
/*
public class Q11 {

    private static class Part {
        int order;
        int direction;
        int y, x;
        public Part(int order, int direction, int y, int x) {
            this.order = order;
            this.direction = direction;
            this.y = y;
            this.x = x;
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = 1;
        }

        Map<Integer, Character> chdir = new HashMap<>();
        int[][] chdirposition = new int[n][n];
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; ++i) {
            st = new StringTokenizer(br.readLine());
            chdir.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
        int cnt = 0;
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        List<Part> snake = new LinkedList<>();
        snake.add(new Part(1, 1, 0, 0));

        if (chdir.containsKey(0)) {
            if (chdir.get(cnt) == 'D') {
                snake.get(0).direction = 2;
            } else {
                snake.get(0).direction = 0;
            }
        }

        while (true) {
            cnt++;

            int yy = snake.get(snake.size()-1).y + dir[snake.get(snake.size()-1).direction][0];
            int xx = snake.get(snake.size()-1).x + dir[snake.get(snake.size()-1).direction][1];

            boolean breakflag = false;
            if (yy >= n || yy < 0 || xx >= n || xx < 0)
                breakflag = true;

            for (int i = 0; i < snake.size() - 1; ++i) {
                if (yy == snake.get(i).y && xx == snake.get(i).x) {
                    breakflag = true;
                    break;
                }
            }

            if (breakflag)
                break;

            if (map[yy][xx] == 1) {
                snake.add(new Part(snake.get(snake.size()-1).order + 1, snake.get(snake.size()-1).direction, yy, xx));
                map[yy][xx] = 0;
            } else {
                for (int i = 0; i < snake.size() - 1; ++i) {
                    snake.get(i).y += dir[snake.get(i).direction][0];
                    snake.get(i).x += dir[snake.get(i).direction][1];
                    snake.get(i).direction += chdirposition[snake.get(i).y][snake.get(i).x];

                    if (snake.get(i).direction >= 4)
                        snake.get(i).direction = 0;
                    else if (snake.get(i).direction < 0)
                        snake.get(i).direction = 3;

                    if (i == 0 && chdirposition[snake.get(i).y][snake.get(i).x] != 0)
                        chdirposition[snake.get(i).y][snake.get(i).x] = 0;
                }
                snake.get(snake.size()-1).y = yy;
                snake.get(snake.size()-1).x = xx;
            }

            if (chdir.containsKey(cnt)) {
                if (chdir.get(cnt) == 'D') {
                    snake.get(snake.size()-1).direction++;
                    if (snake.get(snake.size()-1).direction >= 4)
                        snake.get(snake.size()-1).direction = 0;
                    chdirposition[snake.get(snake.size()-1).y][snake.get(snake.size()-1).x] = 1;
                } else {
                    snake.get(snake.size()-1).direction--;
                    if (snake.get(snake.size()-1).direction < 0)
                        snake.get(snake.size()-1).direction = 3;
                    chdirposition[snake.get(snake.size()-1).y][snake.get(snake.size()-1).x] = -1;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}*/

// Something was wrong with this code, but I couldn't find the part.
/*
public class Q11 {

    private static class Part {
        int order;
        int direction;
        int y, x;
        public Part(int order, int direction, int y, int x) {
            this.order = order;
            this.direction = direction;
            this.y = y;
            this.x = x;
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < k; ++i) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = 1;
        }

        Map<Integer, Character> chdir = new HashMap<>();
        int[][] chdirposition = new int[n][n];
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; ++i) {
            st = new StringTokenizer(br.readLine());
            chdir.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
        int cnt = 0;
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        List<Part> snake = new LinkedList<>();
        snake.add(new Part(1, 1, 0, 0));

        while (true) {
            cnt++;

            snake.get(snake.size()-1).y += dir[snake.get(snake.size()-1).direction][0];
            snake.get(snake.size()-1).x += dir[snake.get(snake.size()-1).direction][1];
            int yy = snake.get(snake.size()-1).y;
            int xx = snake.get(snake.size()-1).x;

            boolean breakflag = false;
            if (yy >= n || yy < 0 || xx >= n || xx < 0)
                breakflag = true;

            for (int i = 0; i < snake.size() - 1; ++i) {
                if (yy == snake.get(i).y && xx == snake.get(i).x) {
                    breakflag = true;
                    break;
                }
            }

            if (breakflag)
                break;

            if (map[yy][xx] == 1) {
                snake.add(new Part(snake.get(snake.size()-1).order + 1, snake.get(snake.size()-1).direction, yy, xx));
                snake.get(snake.size()-2).y -= dir[snake.get(snake.size()-1).direction][0];
                snake.get(snake.size()-2).x -= dir[snake.get(snake.size()-1).direction][1];
                map[yy][xx] = 0;
            } else {
                for (int i = 0; i < snake.size() - 1; ++i) {
                    snake.get(i).y += dir[snake.get(i).direction][0];
                    snake.get(i).x += dir[snake.get(i).direction][1];
                    snake.get(i).direction += chdirposition[snake.get(i).y][snake.get(i).x];

                    if (snake.get(i).direction >= 4)
                        snake.get(i).direction = 0;
                    else if (snake.get(i).direction < 0)
                        snake.get(i).direction = 3;

                    if (i == 0 && chdirposition[snake.get(i).y][snake.get(i).x] != 0)
                        chdirposition[snake.get(i).y][snake.get(i).x] = 0;
                }
            }

            if (chdir.containsKey(cnt)) {
                if (chdir.get(cnt) == 'D') {
                    snake.get(snake.size()-1).direction++;
                    if (snake.get(snake.size()-1).direction >= 4)
                        snake.get(snake.size()-1).direction = 0;
                    chdirposition[snake.get(snake.size()-1).y][snake.get(snake.size()-1).x] = 1;
                } else {
                    snake.get(snake.size()-1).direction--;
                    if (snake.get(snake.size()-1).direction < 0)
                        snake.get(snake.size()-1).direction = 3;
                    chdirposition[snake.get(snake.size()-1).y][snake.get(snake.size()-1).x] = -1;
                }

            }

        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
*/