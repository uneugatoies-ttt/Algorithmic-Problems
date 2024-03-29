package ict_practice_revisit;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
    -> We can define a recurrence relation with the condition and loops as follows:
    for (0 <= j < i):
        if (seq[i] < seq[j]):
            lds[i] = max(lds[i], lds[j] + 1)

    s.t.
    lds[i]: the length of the longest decreasing subsequence of "seq" whose last element is "seq[i]".

*/
public class Q34 {

    // lds[i]: the length of the longest decreasing subsequence of "seq" whose last element is "seq[i]".
    private static int lds(int[] seq) {
        int[] lds = new int[seq.length];
        Arrays.fill(lds, 1);

        for (int i = 1; i < lds.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (seq[i] < seq[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        return lds.length - Arrays.stream(lds).max().orElseThrow();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            seq[i] = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(lds(seq)) + "\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
