package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// divide and conquer
public class BJ6549_3 {

    // The code fails if you define "hist" as an int array; but why?
    // Each element can be as great as 100000000, which is way less than
    // the maximum value of the int type. So why does this have to be long?
    private static long[] hist = new long[100001];

    private static long findMaxRectCrossing(int low, int mid, int high) {
        int l = mid, r = mid;
        long height = hist[mid];
        long rect = height;
        while (l > low && r < high) {
            if (hist[l - 1] < hist[r + 1]) {
                r++;
                height = Math.min(height, hist[r]);
            } else {
                l--;
                height = Math.min(height, hist[l]);
            }

            rect = Math.max(rect, height * (r - l + 1));
        }
        while (r < high) {
            r++;
            height = Math.min(height, hist[r]);
            rect = Math.max(rect, height * (r - l + 1));
        }
        while (l > low) {
            l--;
            height = Math.min(height, hist[l]);
            rect = Math.max(rect, height * (r - l + 1));
        }

        return rect;
    }

    private static long findMaxRect(int low, int high) {
        if (low >= high) return hist[low];

        int mid = (low + high) / 2;

        long left = findMaxRect(low, mid);
        long right = findMaxRect(mid + 1, high);

        long crossing = findMaxRectCrossing(low, mid, high);

        return Math.max(crossing, Math.max(left, right));
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            for (int i = 0; i < n; ++i)
                hist[i] = Integer.parseInt(st.nextToken());
            sb.append(findMaxRect(0, n - 1)).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        //solve();
        System.out.println(Integer.MAX_VALUE);
    }

}
