package ict_practice_revisit;

import java.util.Scanner;

public class Q09 {

    public int solution(String s) {
        int n = s.length();

        if (n == 1) {
            return 1;
        }

        int result = Integer.MAX_VALUE;

        String temp = "";
        for (int i = 1; i <= n/2; ++i) {
            temp = "";
            for (int j = 0; j < n;) {
                int ind = j + i;
                int cnt = 1;

                if (ind >= n || ind + i > n) {
                    temp += s.substring(j, n);
                    break;
                }

                while (s.substring(j, j+i).equals(s.substring(ind, ind+i))) {
                    cnt++;
                    ind += i;
                    if (ind >= n || ind + i > n)
                        break;
                }
                if (cnt > 1) {
                    temp += String.valueOf(cnt) + s.substring(j, j + i);
                } else {
                    temp += s.substring(j, j + i);
                }
                j = ind;
            }
            if (temp.length() < result)
                result = temp.length();
        }

        System.out.println(temp);
        System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q09 q = new Q09();
        q.solution(sc.next());
    }

}
