package baekjoon;

// Refer to: https://st-lab.tistory.com/256

import java.io.*;
import java.util.*;

public class BJ2261 {

    private static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Point[] points;

    private static Comparator<Point> yComparator = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return Integer.compare(o1.y, o2.y);
        }
    };
    private static Comparator<Point> xComparator = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return Integer.compare(o1.x, o2.x);
        }
    };

    private static int getDist(Point p1, Point p2) {
        return (int) Math.pow(p1.x - p2.x, 2) + (int) Math.pow(p1.y - p2.y, 2);
    }

    private static int bruteForce(int begin, int end) {
        int minDist = Integer.MAX_VALUE;

        for (int i = begin; i < end; ++i) {
            Point x0 = points[i];
            for (int j = i + 1; j <= end; ++j)
                minDist = Math.min(minDist, getDist(x0, points[j]));
        }

        return minDist;
    }

    private static int getMiddleBand(int begin, int mid, int end, int mn) {
        int xd;

        List<Point> list = new ArrayList<>();

        int midx = points[mid].x;
        for (int i = begin; i <= end; ++i) {
            xd = points[i].x - midx;
            if (xd * xd < mn)
                list.add(points[i]);
        }

        Collections.sort(list, yComparator);

        int yd;
        for (int i = 0; i < list.size() - 1; ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                yd = list.get(i).y - list.get(j).y;
                if (yd * yd < mn)
                    mn = Math.min(mn, getDist(list.get(i), list.get(j)));
                else
                    break;
            }
        }
        return mn;
    }

    private static int getClosestDist(int begin, int end) {
        if (end - begin + 1 < 4)
            return bruteForce(begin, end);

        int mid = (begin + end) / 2;
        int left = getClosestDist(begin, mid);
        int right = getClosestDist(mid + 1, end);
        int mn = Math.min(left, right);

        int band = getMiddleBand(begin, mid, end, mn);
        return Math.min(mn, band);
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        points = new Point[n];
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(points, xComparator);
        bw.write(String.valueOf(getClosestDist(0, n - 1)));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}