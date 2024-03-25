package ict_practice_revisit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
    -> I got a problem with understanding the logic of the procedures "lowerBound" and "upperBound":
    Although I can see that the general idea is the same as the logic that was used in solving "Q27",
    I don't particularly understand the parts where "arr.get(mid).compareTo(target) >= 0"
    and "arr.get(mid).compareTo(target) > 0" are used.

    Why can the "lowerBound" procedure find the lower bound?
    Why can the "upperBound" procedure find the upper bound?

    I don't know yet; IWAAIL.
*/


public class Q30 {

    private static class Solution {

        List<List<String>> byLen = new ArrayList<>();
        List<List<String>> byLenInv = new ArrayList<>();

        private int lowerBound(List<String> arr, String target, int start, int end) {
            int mid;
            while (start < end) {
                mid = (start + end) / 2;
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
                if (arr.get(mid).compareTo(target) > 0)
                    end = mid;
                else
                    start = mid + 1;
            }
            return end;
        }

        private int countByRange(List<String> arr, String left, String rigth) {
            int leftIndex = lowerBound(arr, left, 0, arr.size());
            int rightIndex = upperBound(arr, right, 0, arr.size());
            return rightIndex - leftIndex;
        }

    }

    public static void main(String[] args) {

    }

}
