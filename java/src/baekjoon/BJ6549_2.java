package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// This version utilizes the stack data structure.
public class BJ6549_2 {

    private static long[] histogram = new long[100001];

    private static long getArea(int len) {
        Stack<Integer> stack = new Stack<>();

        long max = 0;
        for (int i = 0; i < len; ++i) {
            // New bar is shorter than the former one; this is the part where you have to
            // calculate the area.
            while ((!stack.isEmpty()) && histogram[stack.peek()] >= histogram[i]) {
                long height = histogram[stack.pop()];

                /*
                    -> This part might be confusing, but if you consider that this is
                    done repeatedly with the while statement that encompasses this block,
                    (until the stack is empty or one of the former bars is shorter than the "i"th bar)
                    it will be much easier to understand the flow.

                    -> If there's no other element in the stack after the former pop operation,
                    it means that the "width" of this time of the loops becomes the whole length
                    from the very beginning of the histogram to the "i-1"th bar.
                */
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();

                max = Math.max(max, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            long height = histogram[stack.pop()];
            long width = stack.isEmpty() ? len : len - 1 - stack.peek();
            max = Math.max(max, width * height);
        }

        return max;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while (n != 0) {
            for (int i = 0; i < n; ++i) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(n)).append('\n');

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
