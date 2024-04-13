package ict_practice_revisit;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// review of the problem
public class Q43_2 {

    private static class Edge {
        int node1, node2;
        int dist;
        public Edge(int node1, int node2, int dist) {
            this.node1 = node1;
            this.node2 = node2;
            this.dist = dist;
        }
    }

    private static int[] parent, rank;
    private static List<Edge> edges = new ArrayList<>();
    private static int n, m;

    private static int findParent(int x) {
        if (parent[x] != x)
            parent[x] = findParent(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            if (rank[x] == rank[y])
                rank[y]++;
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            edges.add(new Edge(node1, node2, dist));
        }

        Collections.sort(edges, (e1, e2) -> Integer.compare(e1.dist, e2.dist));

        int origCost = 0;
        int reduced = 0;
        for (Edge e : edges) {
            int node1 = e.node1;
            int node2 = e.node2;
            origCost += e.dist;
            if (findParent(node1) != findParent(node2)) {
                union(node1, node2);
                reduced += e.dist;
            }
        }

        bw.write(String.valueOf(origCost - reduced));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
