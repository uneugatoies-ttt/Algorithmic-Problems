package ict_practice_revisit;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q44 {

    private static class Projection implements Comparable<Projection> {
        int xyz;
        int index;
        public Projection(int xyz, int index) {
            this.xyz = xyz;
            this.index = index;
        }
        @Override
        public int compareTo(Projection o) {
            if (this.xyz == o.xyz)
                Integer.compare(this.index, o.index);
            return Integer.compare(this.xyz, o.xyz);
        }
    }

    private static class Edge implements Comparable<Edge> {
        int node1, node2;
        int cost;
        public Edge(int node1, int node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    private static int[] parent, rank;
    private static int n;
    private static List<Edge> edges = new ArrayList<>();
    private static List<Projection> xx, yy, zz;

    private static int findParent(int x) {
        if (parent[x] != x)
            parent[x] = findParent(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (rank[x] < rank[y]) {
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

        n = Integer.parseInt(br.readLine());

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }


        xx = new ArrayList<>();
        yy = new ArrayList<>();
        zz = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            xx.add(new Projection(Integer.parseInt(st.nextToken()), i));
            yy.add(new Projection(Integer.parseInt(st.nextToken()), i));
            zz.add(new Projection(Integer.parseInt(st.nextToken()), i));
        }

        Collections.sort(xx);
        Collections.sort(yy);
        Collections.sort(zz);

        for (int i = 0; i < n - 1; ++i) {
            edges.add(new Edge(xx.get(i).index, xx.get(i + 1).index, Math.abs(xx.get(i).xyz - xx.get(i + 1).xyz)));
            edges.add(new Edge(yy.get(i).index, yy.get(i + 1).index, Math.abs(yy.get(i).xyz - yy.get(i + 1).xyz)));
            edges.add(new Edge(zz.get(i).index, zz.get(i + 1).index, Math.abs(zz.get(i).xyz - zz.get(i + 1).xyz)));
        }

        Collections.sort(edges);

        int result = 0;
        for (Edge e : edges) {
            int node1 = e.node1;
            int node2 = e.node2;
            if (findParent(node1) != findParent(node2)) {
                union(node1, node2);
                result += e.cost;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
