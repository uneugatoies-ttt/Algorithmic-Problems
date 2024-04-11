package ict_practice_revisit;

import java.io.*;
import java.util.Arrays;

// too inefficient?
public class Q42 {

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int[] gates = new int[g];
        Arrays.fill(gates, -1);

        int cnt = 0;

        for (int i = 0; i < p; ++i) {
            int plane = Integer.parseInt(br.readLine()) - 1;
            while (plane > -1 && gates[plane] != -1)
                plane--;
            if (plane <= -1) break;
            gates[plane] = i;
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
