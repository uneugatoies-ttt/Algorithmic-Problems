package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ2178 {
	public static int n, m;
	public static int[][] maze = new int[101][101];
	public static int[][] passCnt = new int[101][101];
	public static int[][] direct = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
	
	public static void bfs() {
		Queue<Map.Entry<Integer, Integer>> q = new ArrayDeque<>();
		q.add(new AbstractMap.SimpleImmutableEntry<>(0, 0));
		passCnt[0][0] = 1;
		while (!q.isEmpty()) {
			Map.Entry<Integer, Integer> pair = q.poll();
			int cn = pair.getKey();
			int cm = pair.getValue();
			for (int i = 0; i < 4; ++i) {
				int sn = cn + direct[i][0];
				int sm = cm + direct[i][1];
				if (sn >= 0 && sn < n && sm >= 0 && sm < m) {
					if (maze[sn][sm] == 1 && passCnt[sn][sm] == 0) {
						q.add(new AbstractMap.SimpleImmutableEntry<>(sn, sm));
						passCnt[sn][sm] = passCnt[cn][cm] + 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		String entry = null;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			entry = token.nextToken();
			for (int j = 0; j < m; ++j)
				maze[i][j] = entry.charAt(j) - '0';
		}
		
		bfs();
		
		writer.write(String.valueOf(passCnt[n - 1][m - 1]));
		writer.flush();
		writer.close();
		reader.close();
	}
}







// failed attempt: time limit exceeded.
/*
public class BJ2178 {
	
	public static int minVal = 20000;
	public static int n;
	public static int m;
	
	public static void solution(int y, int x, int[][] maze, boolean[][] visited, int count) {
		visited[y][x] = true;
		
		if (y == n - 1 && x == m - 1)
			minVal = Math.min(minVal, count);
		
		if (y + 1 < n && !visited[y + 1][x] && maze[y + 1][x] == 1) {
			solution(y + 1, x, maze, visited, count + 1);
			visited[y + 1][x] = false;
		}
		if (y - 1 > -1 && !visited[y - 1][x] && maze[y - 1][x] == 1) {
			solution(y - 1, x, maze, visited, count + 1);
			visited[y - 1][x] = false;
		}
		if (x + 1 < m && !visited[y][x + 1] && maze[y][x + 1] == 1) {
			solution(y, x + 1, maze, visited, count + 1);
			visited[y][x + 1] = false;
		}
		if (x - 1 > -1 && !visited[y][x - 1] && maze[y][x - 1] == 1) {
			solution(y, x - 1, maze, visited, count + 1);
			visited[y][x - 1] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		
		int[][] maze = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			String temp = token.nextToken();
			for (int j = 0; j < m; ++j)
				maze[i][j] = temp.charAt(j) - '0';
		}
		
		solution(0, 0, maze, visited, 1);
		
		System.out.println(minVal);
	}

}*/
