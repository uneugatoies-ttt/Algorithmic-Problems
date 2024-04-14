package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
    -> Initially, I tried the way similar to that used in the Q44 from the ICT book;
    but that wasn't the only thing you have to consider.

    This problem should follow the divide and conquer paradigm.
    IWAAIL.
*/
public class BJ2261 {

    private static int n;

    private static int getDistSquare(int x1, int y1, int x2, int y2) {
        return (int) Math.pow(Math.abs(x1 - x2), 2) + (int) Math.pow(Math.abs(y1 - y2), 2);
    }

    private static int

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
