package baekjoon;

import java.io.*;

// Something's missing with the problem's description: if the whole image is
// exclusively composed of the same number, then the parentheses shouldn't be
// included in the output value.
public class BJ1992 {

    private static int[][] orig;
    private static StringBuffer buffer = new StringBuffer();

    private static boolean checkIdentity(int side, int y, int x) {
        int val = orig[y][x];
        for (int i = y; i < y + side; ++i) {
            for (int j = x; j < x + side; ++j)
                if (orig[i][j] != val)
                    return false;
        }
        return true;
    }

    private static void quadrisect(int side, int y, int x) {
        if (side == 1) {
            buffer.append(String.valueOf(orig[y][x]));
            return;
        }

        if (checkIdentity(side, y, x)) {
            buffer.append(String.valueOf(orig[y][x]));
            return;
        }
        buffer.append('(');
        int newside = side / 2;
        for (int i = 0; i < side; i += newside)
            for (int j = 0; j < side; j += newside)
                quadrisect(newside, y + i, x + j);
        buffer.append(')');
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        orig = new int[n][n];
        String line;
        for (int i = 0; i < n; ++i) {
            line = br.readLine();
            for (int j = 0; j < n; ++j)
                orig[i][j] = line.charAt(j) - '0';
        }

        quadrisect(n, 0, 0);
        if (buffer.charAt(0) != '(') {
            buffer.insert(0, '(');
            buffer.append(')');
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(buffer.toString());
        bw.write('\n');
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
