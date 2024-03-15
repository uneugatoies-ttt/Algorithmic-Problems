package ict_practice_revisit;

import java.io.*;
import java.util.*;

/*
    -> Spent some worthless time because I haven't checked the problem more carefully;
    the description says that the graph is directed, but I overlooked this.
*/
public class Q15 {

    private static int n, m, targetDist, source;
    private static List<List<Integer>> adj = new ArrayList<>();
    private static int[] dist;
    private static boolean[] visited;

    private static void doBfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);
        dist[source] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : adj.get(curr)) {
                if (dist[next] == -1) {
                    dist[next] = 1 + dist[curr];
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
        targetDist = Integer.parseInt(st.nextToken());
        source = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        dist = new int[n];
        Arrays.fill(dist, -1);

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            adj.get(node1).add(node2);
        }

        doBfs();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (dist[i] == targetDist)
                result.add(i + 1);
        }

        if (result.size() == 0) {
            bw.write("-1\n");
        } else {
            for (int r : result)
                bw.write(String.valueOf(r) + "\n");
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
