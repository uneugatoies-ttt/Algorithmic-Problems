package baekjoon;

import java.io.*;
import java.util.*;

public class BJ2261_2 {

    private static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Point[] points;

    private static Comparator<Point> yComparator = (o1, o2) -> Integer.compare(o1.y, o2.y);
    private static Comparator<Point> xComparator = (o1, o2) -> Integer.compare(o1.x, o2.x);

    private static int getDistSquare(Point p1, Point p2) {
        return (int) Math.pow(p1.x - p2.x, 2) + (int) Math.pow(p1.y - p2.y, 2);
    }

    private static int applyBruteForce(int low, int high) {
        int mn = Integer.MAX_VALUE;

        for (int i = low; i <= high - 1; ++i) {
            for (int j = i + 1; j <= high; ++j) {
                int ds = getDistSquare(points[i], points[j]);
                if (ds < mn)
                    mn = ds;
            }
        }

        return mn;
    }

    private static int getCrossingClosestDist(int low, int mid, int high, int mn) {
        // "candidates" that might be yielding smaller values than "mn"
        List<Point> candidates = new ArrayList<>();

        // [ populate "candidates" ]
        // The x point of the element at "mid" will be the pivot;
        // only the points whose x point forms a distance less than "mn"
        // should be appended to "candidates".
        int midx = points[mid].x;
        int xd;
        for (int i = low; i <= high; ++i) {
            xd = points[i].x - midx;
            if (xd * xd < mn) candidates.add(points[i]);
        }

        // [ sort "candidates" according to their y point in ascending order ]
        Collections.sort(candidates, yComparator);

        int yd;
        for (int i = 0; i < candidates.size() - 1; ++i) {
            for (int j = i + 1; j < candidates.size(); ++j) {
                yd = candidates.get(j).y - candidates.get(i).y;
                // If yd^2 >= mn, it means that the distance cannot be less than "mn";
                // break this loop and get to the next "i".
                if (yd * yd >= mn)
                    break;
                else
                    mn = Math.min(mn, getDistSquare(candidates.get(i), candidates.get(j)));
            }
        }

        return mn;
    }

    private static int getClosestDist(int low, int high) {
        if (high - low + 1 < 4) return applyBruteForce(low, high);

        int mid = (low + high) / 2;
        int left = getClosestDist(low, mid);
        int right = getClosestDist(mid + 1, high);
        int mn = Math.min(left, right);
        int crossing = getCrossingClosestDist(low, mid, high, mn);

        return Math.min(mn, crossing);
}

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        points = new Point[n];
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        Arrays.sort(points, xComparator);
        bw.write(String.valueOf(getClosestDist(0, n - 1)));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
