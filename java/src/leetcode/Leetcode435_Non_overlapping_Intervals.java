package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Leetcode435_Non_overlapping_Intervals {

    private static class Solution {

        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparing(i -> i[1]));
            int cnt = 0;

            ArrayList<int[]> result = new ArrayList<>();
            int[] task;
            while (intervals.length != 0) {
                task = intervals[0];
                result.add(task);
                int i;
                for (i = 1; i < intervals.length; ++i) {
                    if (intervals[i][0] >= task[1]) break;
                    cnt++;
                }
                intervals = Arrays.copyOfRange(intervals, i, intervals.length);
            }

            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(s.eraseOverlapIntervals(intervals));

    }

}
