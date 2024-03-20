package ict_practice_revisit;

import java.io.*;
import java.util.StringTokenizer;

/*
    -> The solver must see the problem through the lens of a certain paradigm; i.e., graph abstraction.
    This is not that easy, but at the level of its very fundament, it is not that complicated.

    -> ~ is lacking as of now. If I could've thought of the abstraction at the first observation,
    I could solve it way more efficiently.
*/

public class Q19_2 {

    private static int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
    private static int n;
    private static int[] operands;


    private static void computeMaxAndMin(int ind, int tempRes, int add, int sub, int multi, int divi) {
        if (ind == n) {
            if (tempRes > mx) {
                mx = tempRes;
            }
            if (tempRes < mn) {
                mn = tempRes;
            }
            return;
        }

        if (add > 0)
            computeMaxAndMin(ind + 1, tempRes + operands[ind], add - 1, sub, multi, divi);
        if (sub > 0)
            computeMaxAndMin(ind + 1, tempRes - operands[ind], add, sub - 1, multi, divi);
        if (multi > 0)
            computeMaxAndMin(ind + 1, tempRes * operands[ind], add, sub, multi - 1, divi);
        if (divi > 0)
            computeMaxAndMin(ind + 1, tempRes / operands[ind], add, sub, multi, divi - 1);

    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        operands = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            operands[i] = Integer.parseInt(st.nextToken());

        int[] operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; ++i) {
            int j = Integer.parseInt(st.nextToken());
            while (j-- > 0)
                operators[i]++;
        }

        computeMaxAndMin(1, operands[0], operators[0], operators[1], operators[2], operators[3]);

        bw.write(String.valueOf(mx) + "\n" + String.valueOf(mn) + "\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
