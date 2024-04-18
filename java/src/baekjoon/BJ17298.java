package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17298 {

    private static class Element {
        int value;
        int ind;
        public Element(int value, int ind) {
            this.value = value;
            this.ind = ind;
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        Stack<Element> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && stack.peek().value < arr[i])
                nge[stack.pop().ind] = arr[i];
            stack.push(new Element(arr[i], i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i)
            sb.append(nge[i]).append(' ');
        sb.append('\n');
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
