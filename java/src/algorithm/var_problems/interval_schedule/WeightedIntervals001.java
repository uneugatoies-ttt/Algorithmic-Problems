package algorithm.var_problems.interval_schedule;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WeightedIntervals001 {

    private static int[] intervals;
    private static int[] weights;
    private static int[] p;
    private static int[] maxWeights;
    private static List<Integer> finalSchedule = new LinkedList<>();

    private static void schedule(int i) {
        if (i == 0) return;
        if (weights[i] + maxWeights[p[i]] >= maxWeights[i - 1]) {
            finalSchedule.add(0, intervals[i]);
            schedule(p[i]);
        } else {
            schedule(i - 1);
        }
    }

    public static void main(String[] args) {
        int numOfIntervals = 20;
        for (int i = 1; i < numOfIntervals + 1; ++i)
            maxWeights[i] = Math.max(weights[i] + maxWeights[p[i]], maxWeights[i - 1]);
    }

}
