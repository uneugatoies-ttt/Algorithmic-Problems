package ict_practice_revisit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q12_2 {

    private class Entry implements Comparable<Entry> {
        int x, y, pob;
        public Entry(int x, int y, int pob) {
            this.x = x;
            this.y = y;
            this.pob = pob;
        }

        @Override
        public int compareTo(Entry o) {
            if (this.x == o.x) {
                if (this.y == o.y)
                    return Integer.compare(this.pob, o.pob);
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }

    private boolean isOperPossible(List<List<Integer>> list) {
        for (List<Integer> l : list) {
            int x = l.get(0);
            int y = l.get(1);
            int pob = l.get(2);

            if (pob == 0) {
                boolean flag = false;

                if (y == 0)
                    flag = true;
                for (List<Integer> ll : list) {
                    if (ll.get(0) == x - 1 && ll.get(1) == y && ll.get(2) == 1)
                        flag = true;
                    if (ll.get(0) == x && ll.get(1) == y && ll.get(2) == 1)
                        flag = true;
                    if (ll.get(0) == x && ll.get(1) == y - 1 && ll.get(2) == 0)
                        flag = true;
                    if (flag)
                        break;
                }
                if (!flag) return false;
            } else if (pob == 1) {
                boolean flag = false;
                boolean left = false;
                boolean right = false;

                for (List<Integer> ll : list) {
                    if (ll.get(0) == x && ll.get(1) == y - 1 && ll.get(2) == 0)
                        flag = true;
                    if (ll.get(0) == x + 1 && ll.get(1) == y - 1 && ll.get(2) == 0)
                        flag = true;
                    if (ll.get(0) == x - 1 && ll.get(1) == y && ll.get(2) == 1)
                        left = true;
                    if (ll.get(0) == x + 1 && ll.get(1) == y && ll.get(2) == 1)
                        right = true;
                    if (left && right)
                        flag = true;
                    if (flag)
                        break;
                }
                if (!flag) return false;
            }
        }
        // there is no part within the list
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int pob = build[2];
            int oper = build[3];

            if (oper == 0) {
                int ind = 0;
                for (int i = 0; i < list.size(); ++i) {
                    if (list.get(i).get(0) == x && list.get(i).get(1) == y && list.get(i).get(2) == pob) {
                        ind = i;
                        break;
                    }
                }
                List<Integer> removed = list.get(ind);
                list.remove(ind);
                if (!isOperPossible(list))
                    list.add(removed);
            } else if (oper == 1) {
                List<Integer> constructed = new ArrayList<>();
                constructed.add(x);
                constructed.add(y);
                constructed.add(pob);
                list.add(constructed);
                if (!isOperPossible(list))
                    list.remove(list.size()-1);
            }
        }
        List<Entry> resultlist = new ArrayList<>();
        for (List<Integer> l : list)
            resultlist.add(new Entry(l.get(0), l.get(1), l.get(2)));
        Collections.sort(resultlist);
        int[][] result = new int[list.size()][3];
        for (int i = 0; i < list.size(); ++i) {
            result[i][0] = resultlist.get(i).x;
            result[i][1] = resultlist.get(i).y;
            result[i][2] = resultlist.get(i).pob;
        }

        return result;
    }


}
