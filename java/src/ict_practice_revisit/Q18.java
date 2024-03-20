package ict_practice_revisit;

import java.io.IOException;

public class Q18 {

    private static class Solution {
        private String recursivelyCorrect(String curr) {
            if (curr.length() == 0) return "";
            int cnt = 0;
            int ind = 1;
            boolean correct = true;
            if (curr.charAt(0) == '(')
                cnt++;
            else
                cnt--;
            while (cnt != 0) {
                if (cnt < 0) correct = false;
                if (curr.charAt(ind) == '(')
                    cnt++;
                else
                    cnt--;
                ind++;
            }
            String u = curr.substring(0, ind);
            String v = curr.substring(ind);
            String res;
            if (correct) {
                res = u + recursivelyCorrect(v);
            } else {
                res = ("(" + recursivelyCorrect(v) + ")");
                String newu = "";
                for (int i = 1; i < u.length() - 1; ++i) {
                    if (u.charAt(i) == '(')
                        newu += ")";
                    else
                        newu += "(";
                }
                res += newu;
            }
            return res;
        }

        public String solution(String p) {
            if (p.length() == 0) return "";

            String res = recursivelyCorrect(p);

            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("(()())()"));
        System.out.println(s.solution(")("));
        System.out.println(s.solution("()))((()"));
    }

}
