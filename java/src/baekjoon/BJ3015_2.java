package baekjoon;

import java.io.*;
import java.util.Stack;

public class BJ3015_2 {

    private static class GroupByHeight {
        int height;
        int number;
        public GroupByHeight(int height, int number) {
            this.height = height;
            this.number = number;
        }
    }

    private static int n;
    private static int[] line;

    private static long countPairs() {
        long cnt = 0;
        Stack<GroupByHeight> stack = new Stack<>();
        GroupByHeight newGroup, topGroup;
        for (int i = 0; i < n; ++i) {
            newGroup = new GroupByHeight(line[i], 1);
            while (!stack.isEmpty() && stack.peek().height <= line[i]) {
                topGroup = stack.pop();
                cnt += topGroup.number;
                if (topGroup.height == line[i])
                    newGroup.number += topGroup.number;
            }
            if (!stack.isEmpty())
                cnt++;
            stack.push(newGroup);
        }
        return cnt;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        line = new int[n];
        for (int i = 0; i < n; ++i)
            line[i] = Integer.parseInt(br.readLine());
        bw.write(Long.toString(countPairs()) + '\n');
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
