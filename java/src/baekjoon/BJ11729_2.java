package baekjoon;

import java.io.*;


// I really don't understand the proof; aside from the proof, I don't get the process either.
// IWAAIL

public class BJ11729_2 {

    private static StringBuffer buffer = new StringBuffer();
    private static int cnt = 0;

    private static void tower(int n, int i, int dont, int understand) {
        cnt++;
        if (n == 1) {
            buffer.append(i + " " + understand + "\n");
            return;
        }
        tower(n - 1, i, understand, dont);
        buffer.append(i + " " + understand + "\n");
        tower(n - 1, dont, i, understand);
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        tower(n, 1, 2, 3);
        System.out.println(cnt);
        bw.write(buffer.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}

/*
public class BJ11729_2 {

    private static StringBuffer buffer = new StringBuffer();
    private static int cnt = 0;

    private static void tower(int n, int i, int dont, int understand) {
        cnt++;
        if (n == 1) {
            buffer.append(i + " " + understand + "\n");
            return;
        }
        tower(n - 1, i, understand, dont);
        buffer.append(i + " " + understand + "\n");
        tower(n - 1, dont, i, understand);
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        tower(n, 1, 2, 3);
        System.out.println(cnt);
        bw.write(buffer.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}*/