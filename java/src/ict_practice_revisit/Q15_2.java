package ict_practice_revisit;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

public class Q15_2 {
    private static int n, m, targetDist, source;
    private static List<List<Integer>> adj = new ArrayList<>();
    private static int[] dist;
    private static final int INF = (int)1e10;

    private static void doBFS() {
        Queue<Entry<Integer, Integer>> q =
                new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));
        q.add(new SimpleImmutableEntry<>(source, 0));

        while (!q.isEmpty()) {
            int curr = q.peek().getKey();
            int distance = q.peek().getValue();
            q.poll();

            if (distance > dist[curr]) continue;

            for (int next : adj.get(curr)) {
                int cost = distance + 1;
                if (cost < dist[next]) {
                    dist[next] = cost;
                    q.add(new SimpleImmutableEntry<>(next, cost));
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
        Arrays.fill(dist, INF);
        dist[source] = 0;

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()) - 1;
            int node2 = Integer.parseInt(st.nextToken()) - 1;
            adj.get(node1).add(node2);
        }

        doBFS();

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
