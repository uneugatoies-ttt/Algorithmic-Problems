package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

// https://st-lab.tistory.com/256
// sweep line
public class BJ2261_3 {

    private static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Point[] points;
    private static int n;

    private static Comparator<Point> xComparator = (o1, o2) -> Integer.compare(o1.x, o2.x);

    // Unlike we did differently in the divide-and-conquer approach,
    // we have to compare x values if y values are the same; this is
    // for getting rid of duplicate points.

    private static Comparator<Point> yComparator = (o1, o2) -> {
        if (o1.y == o2.y)
            return Integer.compare(o1.x, o2.x);
        return Integer.compare(o1.y, o2.y);
    };


    private static int getDist(Point p1, Point p2) {
        return (int) Math.pow(p1.x - p2.x, 2) + (int) Math.pow(p1.y - p2.y, 2);
    }

    private static int sweepLine() {
        TreeSet<Point> set = new TreeSet<>(yComparator);

        // Initial value of "mnDist" is the distance between the first
        // and the second points in "points".
        int mnDist = getDist(points[0], points[1]);
        //
        set.add(points[0]);
        set.add(points[1]);

        int lowestIdx = 0;
        for (int i = 2; i < n; ++i) {
            // "benchPoint" refers to the point that is being the pivot
            // of this loop in the sweep line process.
            Point benchPoint = points[i];

            // We don't have to consider points placed in where farther than "mnDist";
            // so we exclude them from the "set".
            while (lowestIdx < i) {
                Point targetPoint = points[lowestIdx];
                int xDist = benchPoint.x - targetPoint.x;

                if (xDist * xDist > mnDist) {
                    set.remove(targetPoint);
                    lowestIdx++;
                } else {
                    break;
                }
            }

            int sqrtMnDist = (int) Math.sqrt(mnDist) + 1;

            // The subSet() method returns a subset of "set", which contains
            // only those points whose y coordinate is between "benchPoint.y - sqrtMnDist"
            // and "benchPoint.y + sqrtMnDist".
            TreeSet<Point> ySub = (TreeSet<Point>) set.subSet(
                    new Point(
                            -100000,
                            benchPoint.y - sqrtMnDist
                    ),
                    new Point(
                            100000,
                            benchPoint.y + sqrtMnDist
                    )
            );

            // Go through "ySub", and check whether its element forms a distance smaller than "mnDist".
            for (Point p : ySub)
                mnDist = Math.min(mnDist, getDist(benchPoint, p));

            set.add(benchPoint);
        }

        return mnDist;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        points = new Point[n];
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        Arrays.sort(points, xComparator);

        bw.write(String.valueOf(sweepLine()));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
