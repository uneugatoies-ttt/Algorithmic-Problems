package ict_practice_revisit;

import java.util.ArrayList;
import java.util.List;



public class Q14 {

    private static class Permutation {
        int n, r;
        int[] curr;
        List<List<Integer>> result;

        public Permutation(int n, int r) {
            this.n = n;
            this.r = r;
            this.curr = new int[r];
            this.result = new ArrayList<>();
        }

        private void swap(List<Integer> orig, int i, int j) {
            int temp = orig.get(i);
            orig.set(i, orig.get(j));
            orig.set(j, temp);
        }

        public void generatePermutation(List<Integer> orig, int depth) {
            if (depth == r) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < r; ++i)
                    temp.add(orig.get(curr[i]));
                result.add(temp);
                return;
            }

            for (int i = depth; i < n; ++i) {
                swap(orig, depth, i);
                curr[depth] = depth;
                generatePermutation(orig, depth + 1);
                swap(orig, depth, i);
            }
        }
    }

    public int solution(int n, int[] weak, int[] dist) {
        int len = weak.length;
        int[] extended = new int[len * 2];
        for (int i = 0; i < len; ++i) {
            extended[i] = weak[i];
            extended[len + i] = weak[i] + n;
        }
        List<Integer> distList = new ArrayList<>();
        for (int d : dist)
            distList.add(d);

        int result = dist.length + 1;

        Permutation p = new Permutation(dist.length, dist.length);
        p.generatePermutation(distList, 0);
        List<List<Integer>> permutation = p.result;

        for (int start = 0; start < len; ++start) {
            for (List<Integer> friends : permutation) {
                int cnt = 1;
                int pos = extended[start] + friends.get(cnt-1);
                for (int ind = start; ind < start + len; ++ind) {
                    if (pos < extended[ind]) {
                        cnt++;
                        if (cnt > dist.length)
                            break;
                        pos = extended[ind] + friends.get(cnt-1);
                    }
                }
                result = Math.min(result, cnt);
            }
        }
        if (result > dist.length)
            return -1;
        return result;
    }

    public static void main(String[] args) {
        Q14 q = new Q14();
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};
        int result = q.solution(12, weak, dist);
        System.out.println(result);
    }

}




