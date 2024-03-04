package ict_practice_revisit;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q08 {

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        List<Character> list = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c - 'A' < 0)
                sum += c - '0';
            else
                list.add(c);
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); ++i)
            sb.append(list.get(i));
        sb.append(String.valueOf(sum));

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        solve();
    }

}
