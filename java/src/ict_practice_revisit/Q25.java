package ict_practice_revisit;

import java.io.*;
import java.util.*;


public class Q25 {
    private static class Level implements Comparable<Level> {
        int index;
        double failure;
        public Level(int index) {
            this.index = index;
        }
        @Override
        public int compareTo(Level o) {
            return Double.compare(o.failure, this.failure);
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] notYet = new int[N + 2];
        for (int i = 0; i < stages.length; ++i) {
            notYet[stages[i]]++;
        }
        int[] reached = new int[N + 1];
        List<Level> levels = new ArrayList<>();
        levels.add(new Level(0));
        reached[N] = notYet[N + 1] + notYet[N];
        for (int i = N - 1; i > 0; --i) {
            reached[i] = reached[i + 1] + notYet[i];
            levels.add(new Level(N - i));
        }
        levels.add(new Level(N));
        for (int i = 1; i <= N; ++i) {
            double failure;
            if (reached[i] == 0)
                failure = 0;
            else
                failure = (double) notYet[i] / reached[i];
            levels.get(i).failure = failure;
        }
        levels.get(0).failure = -1000;
        Collections.sort(levels);
        int[] result = new int[N];
        for (int i = 0; i < N; ++i)
            result[i] = levels.get(i).index;

        return result;
    }

    public static void main(String[] args) {
        Q25 q = new Q25();
        int n = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        System.out.println(Arrays.toString(q.solution(n, stages)));
        System.out.println(Arrays.toString(q.solution(1, new int[] {1})));
    }

}





// time limit exceeded.
/*
public class Q25 {

    private static class Level implements Comparable<Level> {
        int index;
        int reached;
        int notClearedYet;

        public Level(int index) {
            this.index = index;
            this.reached = 0;
            this.notClearedYet = 0;
        }

        @Override
        public int compareTo(Level o) {
            return Integer.compare(o.notClearedYet / o.reached, this.notClearedYet / this.reached);
        }
    }
    public int[] solution(int N, int[] stages) {

        List<Level> levels = new ArrayList<>();
        levels.add(new Level(0));
        levels.get(0).notClearedYet = -1000;
        for (int i = 1; i < N + 1; ++i)
            levels.add(new Level(i));

        for (int i = 0; i < stages.length; ++i) {
            int temp = stages[i];

            for (int j = 0; j < temp; ++i) {
                levels.get(j).reached++;
            }
            levels.get(i).notClearedYet++;
        }

        Collections.sort(levels);

        int[] result = new int[N];
        for (int i = 0; i < N; ++i)
            result[i] = levels.get(i).index;

        return result;
    }

}*/