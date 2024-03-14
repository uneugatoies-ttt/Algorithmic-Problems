package ict_practice_revisit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q14_2 {

    private class Permutation {
        int n, r;
        int[] curr;
        List<List<Integer>> result;
        public Permutation(int n, int r) {
            this.n = n;
            this.r = r;
            this.curr = new int[r];
            this.result = new ArrayList<>();
        }
        private void swap(int[] orig, int i, int j) {
            int temp = orig[i];
            orig[i] = orig[j];
            orig[j] = temp;
        }
        public void generatePermutation(int[] orig, int depth) {
            if (depth == r) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < r; ++i)
                    temp.add(orig[curr[i]]);
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
        int wlen = weak.length;
        int[] extended = new int[wlen * 2];
        for (int i = 0; i < wlen; ++i) {
            extended[i] = weak[i];
            extended[i + wlen] = weak[i] + n;
        }
        Permutation per = new Permutation(dist.length, dist.length);
        per.generatePermutation(dist, 0);
        List<List<Integer>> permutation = per.result;

        int result = Integer.MAX_VALUE;

        for (int start = 0; start < wlen; ++start) {
            for (List<Integer> friends : permutation) {
                int cnt = 1;
                int currentPosition = extended[start] + friends.get(cnt-1);
                for (int ind = start; ind < start + wlen; ++ind) {
                    if (currentPosition < extended[ind]) {
                        cnt++;
                        if (cnt > dist.length)
                            break;
                        currentPosition = extended[ind] + friends.get(cnt-1);
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
        int n = 12;
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};

        Q14_2 q = new Q14_2();
        System.out.println( q.solution(n, weak, dist) );
    }

}
