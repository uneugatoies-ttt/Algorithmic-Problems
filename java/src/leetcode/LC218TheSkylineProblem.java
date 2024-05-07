package leetcode;

import java.util.*;

// sweep line approach (https://github.com/awangdev/leet-code/blob/master/Java/218.%20The%20Skyline%20Problem.java)
/* note
    -> I initially tried to solve this by using tones of if statements with flooding amounts of
    conditions. But as it always has been with the similar cases, it didn't work.
*/
public class LC218TheSkylineProblem {

    private static class Solution {


        private static class Point {
            int pos, height;

            public Point(int pos, int height) {
                this.pos = pos;
                this.height = height;
            }
        }

        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> result = new ArrayList<>();
            if (buildings.length == 0 || buildings == null) return result;

            Queue<Point> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.pos, b.pos));
            for (int i = 0; i < buildings.length; ++i) {
                pq.offer(new Point(buildings[i][0], -buildings[i][2]));
                pq.offer(new Point(buildings[i][1], buildings[i][2]));
            }

            Queue<Integer> maxHeightQueue = new PriorityQueue<>(Collections.reverseOrder());
            maxHeightQueue.offer(0);
            int prevPeak = maxHeightQueue.peek();

            while (!pq.isEmpty()) {
                Point point = pq.peek();

                while (!pq.isEmpty() && pq.peek().pos == point.pos) {
                    point = pq.poll();
                    if (point.height < 0)
                        maxHeightQueue.offer(-point.height);
                    else
                        maxHeightQueue.remove(point.height);
                }
                int currPeak = maxHeightQueue.peek();
                if (currPeak != prevPeak) {
                    List<Integer> list = new ArrayList<>();
                    list.add(point.pos);
                    list.add(currPeak);
                    result.add(list);
                    prevPeak = currPeak;
                }
            }
            return result;
        }



        // failed attempt
        /*
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> result = new ArrayList<>();
            List<List<Integer>> height = new ArrayList<>();

            List temp;
            for (int[] b : buildings) {
                temp = new ArrayList<>();
                temp.add(b[0]);
                temp.add(-b[2]);
                height.add(temp);
                temp = new ArrayList<>();
                temp.add(b[1]);
                temp.add(b[2]);
                height.add(temp);
            }

            Collections.sort(height, (a, b) -> {
                if (a.get(0) == b.get(0)) return Integer.compare(a.get(1), b.get(1));
                return Integer.compare(a.get(0), b.get(0));
            });

            Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            pq.offer(0);
            int prev = 0;

            for (List<Integer> h : height) {
                if (h.get(1) < 0)
                    pq.offer(-h.get(1));
                else
                    pq.remove(h.get(1));
                int curr = pq.peek();
                if (prev != curr) {
                    temp = new ArrayList<>();
                    temp.add(h.get(0));
                    temp.add(curr);
                    result.add(temp);
                    prev = curr;
                }
            }

            return result;
        }*/
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
