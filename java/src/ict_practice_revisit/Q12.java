package ict_practice_revisit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




/*
    A few things must be noted.

        1) Check the given input data's boundary size more carefully, and then make a decision.

        2) Do not assume that the first idea that has come to your mind is the best.

        Of course, if you're trying to solve the problem in some kind of competition with a severe time limit,
        then you should be able to come up with the best idea at the first trial.

        But, in many other situations where you're trying to solve real-life problems,
        you must be able to assess your idea whether it is good enough; and if it isn't,
        you should be able to find an alternative.

        Maybe you should see the problem from the opposite direction;
        or maybe you must demolish the whole frame of yours that has been built.


        Besides, this will eventually help me to think the best idea at the first trial, anyway.

 */


/*

public class Q12 {

    private class Entry implements Comparable<Entry> {
        int x, y;
        // pillar: 0
        // beam: 1
        int pob;

        public Entry(int x, int y, int pob) {
            this.x = x;
            this.y = y;
            this.pob = pob;
        }

        @Override
        public int compareTo(Entry o) {
            if (this.x == o.x && this.y == o.y) {
                return Integer.compare(this.pob, o.pob);
            }
            if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }

    private boolean isPossibleToOperate(List<List<Integer>> res) {
        for (int i = 0; i < res.size(); ++i) {
            int x = res.get(i).get(0);
            int y = res.get(i).get(0);
            int pob = res.get(i).get(0);
            if (pob == 0) {
                boolean check = false;
                if (y == 0) check = true;

            }
        }

    }

    public int[][] solution(int n, int[][] build_frame) {
        List<List<Integer>> res = new ArrayList<>();

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[0];
            int pob = build[0];
            int oper = build[0];
            if (oper == 0) {
                int ind = 0;
                for (int i = 0; i < res.size(); ++i) {
                    if (x == res.get(i).get(0) && y == res.get(i).get(1) && pob == res.get(i).get(2))
                        ind = i;
                }
                List<Integer> erased = res.get(ind);
                res.remove(ind);
                if (!isPossibleToOperate(res))
                    res.add(erased);
            }
        }
    }

}
*/