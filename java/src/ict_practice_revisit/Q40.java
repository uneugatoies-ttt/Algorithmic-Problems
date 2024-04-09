package ict_practice_revisit;

import java.io.*;
import java.util.*;

public class Q40 {

    private static final int INF = (int) 1e9;
    private static int n, m;
    private static int[] dist;
    private static List<List<Integer>> adj = new ArrayList<>();

    private static void dijkstra() {
        Arrays.fill(dist, INF);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        dist[0] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : adj.get(curr)) {
                int cost = dist[curr] + 1;
                if (cost < dist[next]) {
                    dist[next] = cost;
                    q.add(next);
                }
            }
        }

    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n];
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        dijkstra();

        int farthest = -1;
        int farthestInd = -1;
        for (int i = 0; i < n; ++i) {
            if (farthest < dist[i]) {
                farthest = dist[i];
                farthestInd = i + 1;
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (farthest == dist[i]) {
                cnt++;
            }
        }

        bw.write(String.valueOf(farthestInd) + ' ');
        bw.write(String.valueOf(farthest) + ' ');
        bw.write(String.valueOf(cnt) + '\n');
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
