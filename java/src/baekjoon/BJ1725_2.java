package baekjoon;


import java.io.*;
import java.util.Stack;

// using the stack data structure
public class BJ1725_2 {

    private static int[] hist = new int[100001];
    private static int n;

    private static long getMaxArea() {
        Stack<Integer> stack = new Stack<>();
        long mx = 0;
        for (int i = 0; i < n; ++i) {
            while ((!stack.isEmpty()) && hist[stack.peek()] >= hist[i]) {
                int height = hist[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();

                mx = Math.max(mx, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            long height = hist[stack.pop()];
            long width = stack.isEmpty() ? n : n - 1 - stack.peek();
            mx = Math.max(mx, width * height);
        }

        return mx;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i)
            hist[i] = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(getMaxArea()));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
