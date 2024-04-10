package ict_practice_revisit;

import java.io.*;
import java.util.StringTokenizer;

/*
    -> Initially, I was confused if reaching a destination node in the latter part before reaching
    another in the former results in failure; but apparently, that wasn't the author's
    intention.

    This problem is asking whether the given destination nodes are included in the same group
    in this undirected graph or not; so simply applying the DSDS operations would be enough
    to solve the problem.
*/
public class Q41 {

    private static int n, m;
    private static int[] parent;
    private static int[] rank;
    private static int[] destinations;

    private static int findRoot(int x) {
        if (parent[x] != x)
            parent[x] = findRoot(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (parent[x] == parent[y]) return;

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
        destinations = new int[m];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                int zeroone = Integer.parseInt(st.nextToken());
                if (zeroone == 1)
                    union(i, j);
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; ++i)
            destinations[i] = Integer.parseInt(st.nextToken()) - 1;

        boolean flag = true;
        for (int i = 0; i < m - 1; ++i) {
            if (findRoot(destinations[i]) != findRoot(destinations[i + 1])) {
                flag = false;
                break;
            }
        }

        String msg;
        if (flag)
            msg = "YES";
        else
            msg = "NO";

        bw.write(msg);
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
