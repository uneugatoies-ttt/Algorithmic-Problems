package baekjoon;


import java.io.*;

// following the divide and conquer paradigm
public class BJ1725 {

    private static int[] hist = new int[100001];

    private static long getMaxArea(int low, int high) {
        int mid = (low + high) / 2;
        int height = hist[mid];
        long mx = height;

        if (low < high) {
            long left = getMaxArea(low, mid);
            long right = getMaxArea(mid + 1, high);
            mx = Math.max(mx, Math.max(left, right));
        }

        int l = mid;
        int r = mid;
        while (low < l && r < high) {
            if (hist[l - 1] >= hist[r + 1]) {
                l--;
                height = Math.min(height, hist[l]);
            } else {
                r++;
                height = Math.min(height, hist[r]);
            }
            mx = Math.max(mx, height * (r - l + 1));
        }

        while (low < l) {
            l--;
            height = Math.min(height, hist[l]);
            mx = Math.max(mx, height * (r - l + 1));
        }
        while (r < high) {
            r++;
            height = Math.min(height, hist[r]);
            mx = Math.max(mx, height * (r - l + 1));
        }

        return mx;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i)
            hist[i] = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(getMaxArea(0, n - 1)));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
