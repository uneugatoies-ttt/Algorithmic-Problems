package algorithm.graph;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class BFS003 {
	
	private static int[][] maze = new int[101][101];
	private static int[][] passCnt = new int[101][101];
	private static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	private static int n, m;
	
	private static void bfs() {
		Queue<Map.Entry<Integer, Integer>> q = new ArrayDeque<>();
		q.add(new AbstractMap.SimpleImmutableEntry<>(0, 0));
		passCnt[0][0] = 1;
		while (!q.isEmpty()) {
			int yy = q.peek().getKey();
			int xx = q.peek().getValue();
			q.poll();
			for (int i = 0; i < 4; ++i) {
				int ny = yy + direction[i][0];
				int nx = xx + direction[i][1];
				if (ny > -1 && ny < n && nx > -1 && nx < m) {
					if (maze[ny][nx] == 1 && passCnt[ny][ny] == 0) {
						q.add(new AbstractMap.SimpleImmutableEntry<>(ny, nx));
						passCnt[ny][nx] = passCnt[yy][xx] + 1;
					}
				}
			}
		}

	}
}
