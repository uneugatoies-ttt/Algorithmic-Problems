package ict_practice_revisit;

import java.util.Arrays;

public class Q30 {


    // UNFINISHED
/*
    class Solution {


        public int[] solution(String[] words, String[] queries) {
            Arrays.sort(words);

            for (int i = 0; i < queries.length; ++i) {
                String target = queries[i];
                // wildcards are at the end of the entry
                if (target.charAt(0) != '?') {
                    int ind = 0;
                    while (target.charAt(ind) != '?')
                        ind++;
                    String head = target.substring(0, ind);

                    int left = 0, right = words.length - 1;

                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (words[mid].length() != entry.length()) {
                            left = mid + 1;
                            continue;
                        }
                        boolean flag = true;
                        for (int j = 0; j < head.length(); ++j) {
                            if (words[mid].charAt(j) != entry.charAt(j)) {
                                flag = false;
                                break;
                            }
                        }

                        if ()


                    }



                }
                // wildcards are at the beginning of the entry
                else {

                }


            }

        }
    }

*/
}
