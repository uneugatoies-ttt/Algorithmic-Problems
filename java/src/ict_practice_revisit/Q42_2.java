package ict_practice_revisit;

import java.io.*;
import java.util.Arrays;

/*
    -> Empirically, I can understand that this works; but I couldn't have
    thought the idea by myself.
    I'm not sure whether I can solve a similar problem if I see one; IWAAIL.
*/
public class Q42_2 {

    private static int[] parent;

    private static int findParent(int x) {
        if (parent[x] != x)
            parent[x] = findParent(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        parent = new int[g + 1];
        for (int i = 1; i < g + 1; ++i)
            parent[i] = i;

        int cnt = 0;
        for (int i = 0; i < p; ++i) {
            int data = findParent(Integer.parseInt(br.readLine()));
            if (data == 0) break;
            union(data, data - 1);
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
