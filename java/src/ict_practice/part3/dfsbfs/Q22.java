package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
public class Q22 {
	
	static int n;
	static int[][] map;
	
	static int res = Integer.MAX_VALUE;
	
	private static void recurSearch(int y1, int x1, int y2, int x2, int sec) {
		if (y1 > n - 1 || y1 < 0 || y2 > n - 1 || y2 < 0 ||
			x1 > n - 1 || x1 < 0 || x2 > n - 1 || x2 < 0)
			return;
		
		if ((y1 == n-1 && x1 == n-1) || (y2 == n-1 && x2 == n-1)) {
			res = Math.min(res, sec);
			return;
		}
		
		boolean fl = false;
		
		// if H
		if (y1 == y2)
		{
			if (x2 + 1 < n && map[y2][x2 + 1] == 0) {
				recurSearch(y1, x1 + 1, y2, x2 + 1, sec + 1);
				fl = true;
			}
			if (y1 + 1 < n && y2 + 1 < n && map[y1 + 1][x1] == 0 && map[y2 + 1][x2] == 0) {
				recurSearch(y1 + 1, x1, y2 + 1, x2, sec + 1);
				fl = true;
			}
			if (x1 - 1 > -1 && map[y1][x1 - 1] == 0)
				recurSearch(y1, x1 - 1, y2, x2 - 1, sec + 1);
			if (y1 - 1 > -1 && y2 - 1 > -1 && map[y1 - 1][x1] == 0 && map[y2 - 1][x2] == 0)
				recurSearch(y1 - 1, x1, y2 - 1, x2, sec + 1);
		}
		// if V
		else 
		{
			if (x1 + 1 < n && x2 + 1 < n && map[y1][x1 + 1] == 0 && map[y2][x2 + 1] == 0) {
				recurSearch(y1, x1 + 1, y2, x2 + 1, sec + 1);
				fl = true;
			}
			if (y2 + 1 < n && map[y2 + 1][x2] == 0) {
				recurSearch(y1 + 1, x1, y2 + 1, x2, sec + 1);
				fl = true;
			}
			if (x1 - 1 > -1 && x2 - 1 > -1 && map[y1][x1 - 1] == 0 && map[y2][x2 - 1] == 0)
				recurSearch(y1, x1 - 1, y2, x2 - 1, sec + 1);
			if (y1 - 1 > -1 && map[y1 - 1][x1] == 0)
				recurSearch(y1 - 1, x1, y2 - 1, x2, sec + 1);
		}
		
		if (!fl) {
			rotate(y1, x1, y2, x2, sec);
		}
	}
	
	private static void rotate(int y1, int x1, int y2, int x2, int sec) {
		// Horizontal -> Vertical
		if (y1 == y2)
		{
			if (y1 + 1 < n && map[y1 + 1][x1] == 0) {
				recurSearch(y2, x2, y2 + 1, x2, sec + 1);
			}
			if (y2 + 1 < n && map[y2 + 1][x2] == 0) {
				recurSearch(y1, x1, y1 + 1, x1, sec + 1);
			}
			if (y1 - 1 > -1 && map[y1 - 1][x1] == 0) {
				recurSearch(y2 - 1, x2, y2, x2, sec + 1);
			}
			if (y2 - 1 > -1 && map[y2 - 1][x2] == 0) {
				recurSearch(y1 - 1, x1, y1, x1, sec + 1);
			}
		}
		// V -> H
		else
		{
			if (x1 - 1 > -1 && map[y1][x1 - 1] == 0) {
				recurSearch(y2, x2 - 1, y2, x2, sec + 1);
			}
			if (x2 - 1 > -1 && map[y2][x2 - 1] == 0) {
				recurSearch(y1, x1 - 1, y1, x1, sec + 1);
			}
			if (x1 + 1 < n && map[y1][x1 + 1] == 0) {
				recurSearch(y2, x2, y2, x2 + 1, sec + 1);
			}
			if (x2 + 1 < n && map[y2][x2 + 1] == 0) {
				recurSearch(y1, x1, y1, x1 + 1, sec + 1);
			} 
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		
		map = new int[n][n];
		
		StringTokenizer token;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j)
				map[i][i] = Integer.parseInt(token.nextToken());
		}
		
		recurSearch(0, 0, 0, 1, 0);
		
		System.out.println(res);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	

}*/


// failed attempt 2
/*


public class Q22_2 {
	
	private static int n;
	private static int res = Integer.MAX_VALUE;
	
	private static void recurSearch(int y1, int x1, int y2, int x2, int sec, int[][] map) {
		if (y1 > n - 1 || y1 < 0 || y2 > n - 1 || y2 < 0 ||
			x1 > n - 1 || x1 < 0 || x2 > n - 1 || x2 < 0)
			return;
		
		if ((y1 == n-1 && x1 == n-1) || (y2 == n-1 && x2 == n-1)) {
			res = Math.min(res, sec);
			return;
		}
		
		boolean fl = false;
		
		// if H
		if (y1 == y2)
		{
			if (x2 + 1 < n && map[y2][x2 + 1] == 0) {
				recurSearch(y1, x1 + 1, y2, x2 + 1, sec + 1, map);
				fl = true;
			}
			if (y1 + 1 < n && y2 + 1 < n && map[y1 + 1][x1] == 0 && map[y2 + 1][x2] == 0) {
				recurSearch(y1 + 1, x1, y2 + 1, x2, sec + 1, map);
				fl = true;
			}
		}
		// if V
		else 
		{
			if (x1 + 1 < n && x2 + 1 < n && map[y1][x1 + 1] == 0 && map[y2][x2 + 1] == 0) {
				recurSearch(y1, x1 + 1, y2, x2 + 1, sec + 1, map);
				fl = true;
			}
			if (y2 + 1 < n && map[y2 + 1][x2] == 0) {
				recurSearch(y1 + 1, x1, y2 + 1, x2, sec + 1, map);
				fl = true;
			}
		}
		
		if (!fl) {
			rotate(y1, x1, y2, x2, sec, map);
		}
	}
	
	private static void rotate(int y1, int x1, int y2, int x2, int sec, int[][] map) {
		// Horizontal -> Vertical
		if (y1 == y2)
		{
			if (y1 + 1 < n && map[y1 + 1][x1] == 0) {
				recurSearch(y2, x2, y2 + 1, x2, sec + 1, map);
			}
			if (y2 + 1 < n && map[y2 + 1][x2] == 0) {
				recurSearch(y1, x1, y1 + 1, x1, sec + 1, map);
			}
			if (y1 - 1 > -1 && map[y1 - 1][x1] == 0) {
				recurSearch(y2 - 1, x2, y2, x2, sec + 1, map);
			}
			if (y2 - 1 > -1 && map[y2 - 1][x2] == 0) {
				recurSearch(y1 - 1, x1, y1, x1, sec + 1, map);
			}
		}
		// V -> H
		else
		{
			if (x1 - 1 > -1 && map[y1][x1 - 1] == 0) {
				recurSearch(y2, x2 - 1, y2, x2, sec + 1, map);
			}
			if (x2 - 1 > -1 && map[y2][x2 - 1] == 0) {
				recurSearch(y1, x1 - 1, y1, x1, sec + 1, map);
			}
			if (x1 + 1 < n && map[y1][x1 + 1] == 0) {
				recurSearch(y2, x2, y2, x2 + 1, sec + 1, map);
			}
			if (x2 + 1 < n && map[y2][x2 + 1] == 0) {
				recurSearch(y1, x1, y1, x1 + 1, sec + 1, map);
			} 
		}
	}
	
    public int solution(int[][] board) {
    	recurSearch(0, 0, 0, 1, 0, board);
    	n = board[0].length;
    	return res;
    }
    
    
    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		
		int[][] map = new int[n][n];
		
		StringTokenizer token;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
		
		Q22_2 q = new Q22_2();
		
		System.out.println(q.solution(map));
	}
    
    


*/

// failed attempt 3
/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q22_3 {
	
	private static int n;
	private static int res = Integer.MAX_VALUE;
	
	private static int[][] map;
	
	private static void recurSearch(int y1, int x1, int y2, int x2, int sec) {
		if (y1 > n - 1 || y1 < 0 || y2 > n - 1 || y2 < 0 ||
			x1 > n - 1 || x1 < 0 || x2 > n - 1 || x2 < 0)
			return;
		
		if ((y1 == n-1 && x1 == n-1) || (y2 == n-1 && x2 == n-1)) {
			res = Math.min(res, sec);
			return;
		}
		
		boolean fl = false;
		
		// if H
		if (y1 == y2)
		{
			if (x2 + 1 < n && map[y2][x2 + 1] == 0) {
				recurSearch(y1, x1 + 1, y2, x2 + 1, sec + 1);
				fl = true;
			}
			if (y1 + 1 < n && y2 + 1 < n && map[y1 + 1][x1] == 0 && map[y2 + 1][x2] == 0) {
				recurSearch(y1 + 1, x1, y2 + 1, x2, sec + 1);
				fl = true;
			}
		}
		// if V
		else 
		{
			if (x1 + 1 < n && x2 + 1 < n && map[y1][x1 + 1] == 0 && map[y2][x2 + 1] == 0) {
				recurSearch(y1, x1 + 1, y2, x2 + 1, sec + 1);
				fl = true;
			}
			if (y2 + 1 < n && map[y2 + 1][x2] == 0) {
				recurSearch(y1 + 1, x1, y2 + 1, x2, sec + 1);
				fl = true;
			}
		}
		
		if (!fl) {
			rotate(y1, x1, y2, x2, sec);
		}
	}
	
	private static void rotate(int y1, int x1, int y2, int x2, int sec) {
		// Horizontal -> Vertical
		if (y1 == y2)
		{
			if (y1 + 1 < n && map[y1 + 1][x1] == 0) {
				recurSearch(y2, x2, y2 + 1, x2, sec + 1);
			}
			if (y2 + 1 < n && map[y2 + 1][x2] == 0) {
				recurSearch(y1, x1, y1 + 1, x1, sec + 1);
			}
			if (y1 - 1 > -1 && map[y1 - 1][x1] == 0) {
				recurSearch(y2 - 1, x2, y2, x2, sec + 1);
			}
			if (y2 - 1 > -1 && map[y2 - 1][x2] == 0) {
				recurSearch(y1 - 1, x1, y1, x1, sec + 1);
			}
		}
		// V -> H
		else
		{
			if (x1 - 1 > -1 && map[y1][x1 - 1] == 0) {
				recurSearch(y2, x2 - 1, y2, x2, sec + 1);
			}
			if (x2 - 1 > -1 && map[y2][x2 - 1] == 0) {
				recurSearch(y1, x1 - 1, y1, x1, sec + 1);
			}
			if (x1 + 1 < n && map[y1][x1 + 1] == 0) {
				recurSearch(y2, x2, y2, x2 + 1, sec + 1);
			}
			if (x2 + 1 < n && map[y2][x2 + 1] == 0) {
				recurSearch(y1, x1, y1, x1 + 1, sec + 1);
			} 
		}
	}
	
    
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		
		map = new int[n][n];
		
		StringTokenizer token;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
		
		recurSearch(0, 0, 0, 1, 0);
		
		System.out.println(res);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	

}



*/


/*
	int n;
	int res;
	boolean[][] visited;
	int[][] map;
	
	private void rs(int y1, int x1, int y2, int x2, int sec) {
		if (y1 > n - 1 || y1 < 0 || y2 > n - 1 || y2 < 0 ||
			x1 > n - 1 || x1 < 0 || x2 > n - 1 || x2 < 0)
			return;
		
		visited[y1][x1] = true;
		visited[y2][x2] = true;
		
		if ((y1 == n-1 && x1 == n-1) || (y2 == n-1 && x2 == n-1)) {
			res = Math.min(res, sec);
			return;
		}
		
		boolean fl = false;
		
		// if H
		if (y1 == y2)
		{
			if (x2 + 1 < n && map[y2][x2 + 1] == 0) {
				if (!visited[y1][x1 + 1] || !visited[y2][x2 + 1]) {
					rs(y1, x1 + 1, y2, x2 + 1, sec + 1);
					fl = true;
				}
			}
			if (y1 + 1 < n && y2 + 1 < n && map[y1 + 1][x1] == 0 && map[y2 + 1][x2] == 0) {
				if (!visited[y1 + 1][x1] || !visited[y2 + 1][x2]) {
					rs(y1 + 1, x1, y2 + 1, x2, sec + 1);
					fl = true;
				}
			}
			if (x1 - 1 > -1 && map[y1][x1 - 1] == 0)
				if (!visited[y1][x1 - 1] || !visited[y2][x2 - 1]) 
					rs(y1, x1 - 1, y2, x2 - 1, sec + 1);
			if (y1 - 1 > -1 && y2 - 1 > -1 && map[y1 - 1][x1] == 0 && map[y2 - 1][x2] == 0)
				if (!visited[y1 - 1][x1] || !visited[y2 - 1][x2])
					rs(y1 - 1, x1, y2 - 1, x2, sec + 1);
		}
		// if V
		else 
		{
			if (x1 + 1 < n && x2 + 1 < n && map[y1][x1 + 1] == 0 && map[y2][x2 + 1] == 0) {
				if (!visited[y1][x2 + 1] || !visited[y2][x2 + 1]) {
					rs(y1, x1 + 1, y2, x2 + 1, sec + 1);
					fl = true;
				}
			}
			if (y2 + 1 < n && map[y2 + 1][x2] == 0) {
				if (!visited[y1 + 1][x1] || !visited[y2 + 1][x2]) {
					rs(y1 + 1, x1, y2 + 1, x2, sec + 1);
					fl = true;
				}
			}
			if (x1 - 1 > -1 && x2 - 1 > -1 && map[y1][x1 - 1] == 0 && map[y2][x2 - 1] == 0)
				if (!visited[y1][x1 - 1] || !visited[y2][x2 - 1])
					rs(y1, x1 - 1, y2, x2 - 1, sec + 1);
			if (y1 - 1 > -1 && map[y1 - 1][x1] == 0)
				if (!visited[y1 - 1][x1] || !visited[y2 - 1][x2])
					rs(y1 - 1, x1, y2 - 1, x2, sec + 1);
		}
		
		if (!fl) {
			rotate(y1, x1, y2, x2, sec);
		}
	}
	
	
	private void rotate(int y1, int x1, int y2, int x2, int sec) {
		// Horizontal -> Vertical
		if (y1 == y2)
		{
			if (y1 + 1 < n && map[y1 + 1][x1] == 0 && map[y2 + 1][x2] == 0) {
				rs(y2, x2, y2 + 1, x2, sec + 1);
			}
			if (y2 + 1 < n && map[y2 + 1][x2] == 0 && map[y1 + 1][x1] == 0) {
				rs(y1, x1, y1 + 1, x1, sec + 1);
			}
			if (y1 - 1 > -1 && map[y1 - 1][x1] == 0 && map[y2 - 1][x2] == 0) {
				rs(y2 - 1, x2, y2, x2, sec + 1);
			}
			if (y2 - 1 > -1 && map[y2 - 1][x2] == 0 && map[y1 - 1][x1] == 0) {
				rs(y1 - 1, x1, y1, x1, sec + 1);
			}
		}
		// V -> H
		else
		{
			if (x1 - 1 > -1 && map[y1][x1 - 1] == 0 && map[y2][x2 - 1] == 0) {
				rs(y2, x2 - 1, y2, x2, sec + 1);
			}
			if (x2 - 1 > -1 && map[y2][x2 - 1] == 0 && map[y1][x1 - 1] == 0) {
				rs(y1, x1 - 1, y1, x1, sec + 1);
			}
			if (x1 + 1 < n && map[y1][x1 + 1] == 0 && map[y2][x2 + 1] == 0) {
				rs(y2, x2, y2, x2 + 1, sec + 1);
			}
			if (x2 + 1 < n && map[y2][x2 + 1] == 0 && map[y1][x1 + 1] == 0) {
				rs(y1, x1, y1, x1 + 1, sec + 1);
			} 
		}
	}
	
	
    public int solution(int[][] board) {
    	this.res = Integer.MAX_VALUE;
    	this.map = board;
    	this.n = map.length;
    	this.visited = new boolean[n][n];
    	
    	rs(0, 0, 0, 1, 0);
    	
        return res;
    }
*/
