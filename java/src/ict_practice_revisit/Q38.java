package ict_practice_revisit;

import java.io.*;
import java.util.*;

public class Q38 {

    private static boolean[] checked;
    private static int n, m;
    private static List<List<Integer>> adj;

    private static void bfsTarget(int start, int target) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == target) {
                checked[start] = true;
                return;
            }

            for (int next : adj.get(curr)) {
                if (!visited[next])
                    q.add(next);
            }
        }
    }

    private static void bfsFrom(int start) {
        Queue<Integer> q = new ArrayDeque();
        q.add(start);
        checked[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            checked[curr] = true;

            for (int next : adj.get(curr)) {
                if (!checked[next])
                    q.add(next);
            }
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        checked = new boolean[n];
        adj = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            adj.get(from).add(to);
        }

        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            Arrays.fill(checked, false);
            bfsFrom(i);
            boolean flag = true;
            for (int j = 0; j < n; ++j) {
                if (!checked[j]) {
                    bfsTarget(j, i);

                    if (!checked[j]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
