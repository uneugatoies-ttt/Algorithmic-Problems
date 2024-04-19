package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17298_2 {

    private static int n;
    private static int[] arr;
    private static int[] nge;

    private static void formNGEs() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                nge[stack.peek()] = arr[i];
                stack.pop();
            }

            stack.push(i);
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        nge = new int[n];
        Arrays.fill(nge, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());
        formNGEs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; ++i)
            sb.append(String.valueOf(nge[i]) + ' ');
        sb.append(String.valueOf(nge[n-1]) + '\n');
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
