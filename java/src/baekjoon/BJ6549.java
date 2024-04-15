package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// This version follows the divide-and-conquer paradigm; it is less efficient than
// the solution that uses the stack data structure.
public class BJ6549 {

    private static long[] histogram = new long[100001];

    private static long getAreaConsecutive(int low, int high, int mid) {
        int leftward = mid;
        int rightward = mid;
        long height = histogram[mid];
        long max = height;

        while (low < leftward && rightward < high) {
            if (histogram[leftward - 1] < histogram[rightward + 1]) {
                rightward++;
                height = Math.min(histogram[rightward], height);
            } else {
                leftward--;
                height = Math.min(histogram[leftward], height);
            }
            max = Math.max(max, height * (rightward - leftward + 1));
        }

        while (rightward < high) {
            rightward++;
            height = Math.min(height, histogram[rightward]);
            max = Math.max(max, height * (rightward - leftward + 1));
        }

        while (leftward > low) {
            leftward--;
            height = Math.min(height, histogram[leftward]);
            max = Math.max(max, height * (rightward - leftward + 1));
        }

        return max;
    }

    private static long getArea(int low, int high) {
        // Base case: segment only contains one bar.
        if (low == high) return histogram[low];

        int mid = (low + high) / 2;

        // max area of the left half
        long left = getArea(low, mid);
        // max area of the right half
        long right = getArea(mid + 1, high);
        // max area of the whole
        long whole = getAreaConsecutive(low, high, mid);

        long max = Math.max(whole, Math.max(left, right));

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

            sb.append(getArea(0, n - 1)).append('\n');

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
