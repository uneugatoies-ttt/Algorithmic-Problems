package ict_practice_revisit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q30_2 {

    private static class Solution {

        private List<List<String>> qByLen = new ArrayList<>();
        private List<List<String>> qByLenInv = new ArrayList<>();

        private int findUpperBound(List<String> list, String target, int left, int right) {
            while (left < right) {
                int mid = (left + right) / 2;

                if (list.get(mid).compareTo(target) > 0)
                    right = mid;
                else
                    left = mid + 1;
            }
            return right;
        }

        private int findLowerBound(List<String> list, String target, int left, int right) {
            while (left < right) {
                int mid = (left + right) / 2;

                if (list.get(mid).compareTo(target) >= 0)
                    right = mid;
                else
                    left = mid + 1;
            }
            return right;
        }

        private int countByRange(List<String> list, String target) {
            int first = findLowerBound(list, target, 0, list.size());
            if (first == -1) return 0;
            int last = findUpperBound(list, target, 0, list.size());
            if (last == -1) return 1;
            return first - last + 1;
        }

        private int[] solution(String[] words, String[] queries) {
            for (int i = 0; i < 10001; ++i) {
                qByLen.add(new ArrayList<>());
                qByLenInv.add(new ArrayList<>());
            }

            for (int i = 0; i < words.length; ++i) {
                qByLen.get(words[i].length()).add(words[i]);
                qByLenInv.get(words[i].length()).add((new StringBuilder(words[i]).reverse().toString()));
            }

            for (int i = 0; i < 10001; ++i) {
                Collections.sort(qByLen.get(i));
                Collections.sort(qByLenInv.get(i));
            }

            int[] result = new int[queries.length];
            String query;
            for (int i = 0; i < queries.length; ++i) {
                query = queries[i];

                if (query.charAt(0) != '?') {
                    result[i] = countByRange(qByLen.get(query.length()), query);
                } else {
                    query = (new StringBuilder(query).reverse().toString());
                    result[i] = countByRange(qByLenInv.get(query.length()), query);
                }
            }

            return result;
        }

    }


    public static void main(String[] args) {

    }

}
