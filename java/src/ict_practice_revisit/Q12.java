package ict_practice_revisit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    A few things must be noted.

        1) Check the given input data's boundary size more carefully, and then make a decision.

        2) Do not assume that the first idea that has come to your mind is the best.

        Of course, if you're trying to solve the problem in some kind of competition with a severe time limit,
        you should be able to come up with the best idea at the first trial.

        But, in many other situations where you're trying to solve real-life problems,
        you must assess your idea to find out whether it is good enough; and if it isn't,
        you should find an alternative.
        To find the alternative, maybe you should see the problem from the opposite direction;
        or, maybe you should demolish the whole frame of yours that has been built.
        Whatever your approach might be, you have to keep doing the similar process
        until you find the best one.

        Besides, although this might seem so overwhelmingly time-consuming,
        it will eventually help me to think the best idea at the first trial.
 */

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

    /*
        -> We don't have to set the separate case checking for the removal operation,
        since the checking is simply being done with every part that is contained within
        the list. whether you're doing the removal or the construction, you'll know if
        that is not possible.
     */
    private boolean isPossibleToOperate(List<List<Integer>> res) {
        for (List<Integer> eachres : res) {
            int eachx = eachres.get(0);
            int eachy = eachres.get(1);
            int eachpob = eachres.get(2);
            // a pillar
            if (eachpob == 0) {
                boolean check = false;
                if (eachy == 0) check = true;

                for (List<Integer> j : res) {
                    // There is a beam at (x-1, y)
                    if (eachx - 1 == j.get(0) && eachy == j.get(1) && 1 == j.get(2))
                        check = true;
                    // There is a beam at (x, y)
                    if (eachx == j.get(0) && eachy == j.get(1) && 1 == j.get(2))
                        check = true;
                    // There is a pillar at (x, y-1)
                    if (eachx == j.get(0) && eachy - 1 == j.get(1) && 0 == j.get(2))
                        check = true;
                }

                if (!check) return false;
            }
            // a beam
            else if (eachpob == 1) {
                boolean check = false;
                boolean left = false;
                boolean right = false;

                for (List<Integer> j : res) {
                    if (eachx == j.get(0) && eachy - 1 == j.get(1) && 0 == j.get(2))
                        check = true;
                    if (eachx + 1 == j.get(0) && eachy - 1 == j.get(1) && 0 == j.get(2))
                        check = true;
                    if (eachx - 1 == j.get(0) && eachy == j.get(1) && 1 == j.get(2))
                        left = true;
                    if (eachx + 1 == j.get(0) && eachy == j.get(1) && 1 == j.get(2))
                        right = true;
                }

                if (left && right) check = true;
                if (!check) return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        List<List<Integer>> res = new ArrayList<>();

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int pob = build[2];
            int oper = build[3];

            // removal
            if (oper == 0) {
                int ind = 0;
                // finding the constructed part at that coordinate;
                // since the problem's description mentioned that there will be no case
                // where a non-existing part will be said to be removed, "ind" will always
                // contain the index number of the corresponding part.
                for (int i = 0; i < res.size(); ++i) {
                    if (x == res.get(i).get(0) && y == res.get(i).get(1) && pob == res.get(i).get(2))
                        ind = i;
                }
                List<Integer> erased = res.get(ind);
                res.remove(ind);
                if (!isPossibleToOperate(res))
                    res.add(erased);
            }
            // construction
            else if (oper == 1) {
                List<Integer> inserted = new ArrayList<>();
                inserted.add(x);
                inserted.add(y);
                inserted.add(pob);
                res.add(inserted);
                if (!isPossibleToOperate(res))
                    res.remove(res.size() - 1);
            }
        }

        List<Entry> resultList = new ArrayList<>();
        for (List<Integer> i : res)
            resultList.add(new Entry(i.get(0), i.get(1), i.get(2)));
        Collections.sort(resultList);

        int[][] result = new int[resultList.size()][3];
        for (int i = 0; i < resultList.size(); ++i) {
            result[i][0] = resultList.get(i).x;
            result[i][1] = resultList.get(i).y;
            result[i][2] = resultList.get(i).pob;
        }
        return result;
    }

}
