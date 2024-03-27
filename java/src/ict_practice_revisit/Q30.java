package ict_practice_revisit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
    -> I got a problem with understanding the logic of the procedures "lowerBound" and "upperBound":
    Although I can see that the general idea is the same as the logic that was used in solving "Q27",
    I don't particularly understand the parts where "arr.get(mid).compareTo(target) >= 0"
    and "arr.get(mid).compareTo(target) > 0" are used.

    How does the "lowerBound" procedure find the lower bound?
    How does the "upperBound" procedure find the upper bound?
*/


// p.s. Now I can see it a bit more clearly. Here are the things that I've got:
/*
    -> The procedures "lowerBound" and "upperBound" are variations of the procedures "findFirstIndex"
    and "findLastIndex" that were already introduced; the former group utilizes loops while the latter
    group utilizes recursive calling.

    -> The condition checking in both procedures works in a similar way as that that was used in "countByValue()".
    That is, "lowerBound" finds the left half if the entry at "mid" is equal to or greater than "target";
    on the other hand, "upperBound" finds the left half only if the entry at "mid" is greater than "target".

    -> We substitute all "?" in each query with "a" and "z" and call "countByRange" so that we can find
    the number of all entries that are between those end points.

    -> We have to define "byLenInv" so that we can handle the cases where the wildcard character ? is at the beginning
    of the given query.
    However, it is still clunky to give an exact explanation on why we should do this; IWAAIL.

    -> So, as you can see, there's nothing much that is too difficult in this problem.
    What matters is whether you can come up with the idea about distinguishing the given words by their lengths.
    After that, it is just applying the similar pattern that was learned in the past.
    (Of course, grouping words by their lengths also can be seen as applying the pattern)
*/

// p.p.s Remaining Questions:
/*
    -> Why does it use "left < right" as the while condition?

    -> Why does it assign "mid" to "end" in the if statement's body?

    -> Why does it have to reverse the words when it comes to a query
    whose first character is the wildcard?

    -> Why does it set the boundary values of the search process like this?
    Besides, I'm not sure about the boundaries in implementations of the binary search algorithm
    in general; from my viewpoint as of now, it seems that it sometimes initializes its boundaries
    with some pattern and other times it seems that it does in another way.

    Maybe I would have to dig up some information in detail, more thoroughly;
    indeed, the recent learning process of mine was pretty superficial.

    If I'm going to find out about the matter, I'll come back to this part. IWAAIL.
*/


public class Q30 {

    private static class Solution {

        List<List<String>> byLen = new ArrayList<>();
        List<List<String>> byLenInv = new ArrayList<>();

        private int lowerBound(List<String> arr, String target, int start, int end) {
            int mid;
            while (start < end) {
                mid = (start + end) / 2;

                // find the left half if the entry at "mid" is equal to or greater than "target".
                if (arr.get(mid).compareTo(target) >= 0)
                    end = mid;
                else
                    start = mid + 1;
            }
            return end;
        }

        private int upperBound(List<String> arr, String target, int start, int end) {
            int mid;
            while (start < end) {
                mid = (start + end) / 2;

                // find the left half only if the entry at "mid" is greater than "target".
                if (arr.get(mid).compareTo(target) > 0)
                    end = mid;
                else
                    start = mid + 1;
            }
            return end;
        }

        private int countByRange(List<String> arr, String left, String right) {
            int leftIndex = lowerBound(arr, left, 0, arr.size());
            int rightIndex = upperBound(arr, right, 0, arr.size());
            return rightIndex - leftIndex;
        }

        public int[] solution(String[] words, String[] queries) {
            for (int i = 0; i < 10001; ++i) {
                byLen.add(new ArrayList<>());
                byLenInv.add(new ArrayList<>());
            }

            for (int i = 0; i < words.length; ++i) {
                byLen.get(words[i].length()).add(words[i]);
                byLenInv.get(words[i].length()).add(new StringBuilder(words[i]).reverse().toString());
            }

            for (int i = 0; i < 10001; ++i) {
                Collections.sort(byLen.get(i));
                Collections.sort(byLenInv.get(i));
            }

            int[] result = new int[queries.length];
            String temp;
            for (int i = 0; i < queries.length; ++i) {
                temp = queries[i];
                int res = 0;
                if (temp.charAt(0) == '?') {
                    temp = (new StringBuilder(temp).reverse().toString());
                    res = countByRange(
                            byLenInv.get(temp.length()),
                            temp.replace("?", "a"),
                            temp.replace("?", "z"));
                } else {
                    res = countByRange(
                            byLen.get(temp.length()),
                            temp.replace("?", "a"),
                            temp.replace("?", "z"));
                }
                result[i] = res;
            }

            return result;
        }

    }





    public static void main(String[] args) {

    }

}
