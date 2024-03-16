package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// failed.
/*
public class BJ11729 {

    private static StringBuffer buffer = new StringBuffer();
    private static int cnt = 0;

    private static void tower(int n, int from, int to, int aux) {
        cnt++;
        if (n == 1) {
            buffer.append(from + " " + to + "\n");
            return;
        }
        tower(n - 1, from, aux, to);
        buffer.append(from + " " + to + "\n");
        tower(n - 1, aux, to, from);
    }

    private static void solve() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        tower(n, 1, 2, 3);
        System.out.println(cnt);
        bw.write(buffer.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
*/