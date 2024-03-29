package algorithm.dp;

import java.util.Arrays;

public class LIS002 {

    private static int lis(int[] seq) {
        int n = seq.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (seq[i] > seq[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }

        return Arrays.stream(lis).max().orElseThrow();
    }

    // "lds[i]" refers to the length of the longest decreasing subsequence that can be achieved from the index 0 to the index i.
    private static int lds(int[] seq) {
        int n = seq.length;
        int[] lds = new int[n];
        Arrays.fill(lds, 1);

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (seq[i] < seq[j] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;
            }
        }

        return Arrays.stream(lds).max().orElseThrow();
    }

    public static void main(String[] args) {
        int[] seq = { 15, 11, 4, 8, 5, 2, 4 };
        System.out.println(lds(seq));
    }

}
