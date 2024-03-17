package baekjoon;

import java.io.*;

public class BJ11729_3 {

    private static StringBuffer buffer = new StringBuffer();

    // "from" refers to the pole in which the n disks were originally placed.
    // "to" refers to the pole in which the n disks should be placed.
    private static void moveDisks(int n, int from, int auxiliary, int to) {
        // base case: n == 1
        // There's only one disk to move, in this case, we should simply move the disk
        // from "from" to "to" and return.
        if (n == 1) {
            buffer.append(from + " " + to + "\n");
            return;
        }
        // n > 1
        // We have to move n - 1 disks from "from" to "auxiliary";
        // this effectively moves all but the largest disk to the "auxiliary" pole.
        moveDisks(n - 1, from, to, auxiliary);
        // After the first recursive call, we record a move of the remaining disk,
        // which is the largest one, from "from" to "to".
        buffer.append(from + " " + to + "\n");
        // Finally, we make another recursive call to move the n - 1 disks from
        // "auxiliary" to "to"; this moves all the smaller disks on top of the
        // largest disk on the destination.
        moveDisks(n - 1, auxiliary, from, to);
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        buffer.append(((int)Math.pow(2, n) - 1) + "\n");
        moveDisks(n, 1, 2, 3);
        bw.write(buffer.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
