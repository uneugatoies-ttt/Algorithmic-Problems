package ict_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	- this isn't good; we don't have to use 'dy' and 'dx'.

	- I should've thought using 'turnCnt' in the first place.
	Why didn't I think this kind of ridiculously easy idea?
	Maybe again, I didn't fully utilize the principle of GYK.
*/

public class Chapter4Problem2 {
	// The problem is using 0-based index.
	
	private static int[][] map;
	private static boolean[][] visited;
	private static int y, x;
	private static int n, m;
	private static int direction;
	
	// the order: North, East, South, and West
	private static int[] dy = { -1, 0, 1, 0 };
	private static int[] dx = { 0, 1, 0, -1 };
	
	public static void turnLeft() {
		direction--;
		if (direction == -1) direction = 3;
	}
	
	public static int solve() {
		int count = 1;
		int ny, nx;
		int turnNum = 0;
		while (true) {
			if (turnNum < 4) {
				turnLeft();
				ny = y + dy[direction];
				nx = x + dx[direction];
				
				if (direction == 0) {
					if (ny > -1 && !visited[ny][nx] && map[ny][nx] == 0) {
						visited[ny][nx] = true;
						y = ny;
						x = nx;
						count++;
						turnNum = 0;
						continue;
					} else turnNum++;
				} else if (direction == 1) {
					if (nx < m && !visited[ny][nx] && map[ny][nx] == 0) {
						visited[ny][nx] = true;
						y = ny;
						x = nx;
						count++;
						turnNum = 0;
						continue;
					} else turnNum++;
				} else if (direction == 2) {
					if (ny < n && !visited[ny][nx] && map[ny][nx] == 0) {
						visited[ny][nx] = true;
						y = ny;
						x = nx;
						count++;
						turnNum = 0;
						continue;
					} else turnNum++;
				} else if (direction == 3) {
					if (nx > -1 && !visited[ny][nx] && map[ny][nx] == 0) {
						visited[ny][nx] = true;
						y = ny;
						x = nx;
						count++;
						turnNum = 0;
						continue;
					} else turnNum++;
				}
			} else {
				if (direction == 0) {
					ny = y - dy[direction];
					nx = x - dx[direction];
					if (ny < n && map[ny][nx] == 0) {
						y = ny;
						x = nx;
					} else break;
				} else if (direction == 1) {
					ny = y - dy[direction];
					nx = x - dx[direction];
					if (nx > -1 && map[ny][nx] == 0) {
						y = ny;
						x = nx;
					} else break;
				} else if (direction == 2) {
					ny = y - dy[direction];
					nx = x - dx[direction];
					if (ny > -1 && map[ny][nx] == 0) {
						y = ny;
						x = nx;
					} else break;
				} else if (direction == 3) {
					ny = y - dy[direction];
					nx = x - dx[direction];
					if (nx < m && map[ny][nx] == 0) {
						y = ny;
						x = nx;
					} else break;
				}
				turnNum = 0;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(reader.readLine());
		y = Integer.parseInt(token.nextToken());
		x = Integer.parseInt(token.nextToken());
		direction = Integer.parseInt(token.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		visited[y][x] = true;
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; ++j)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
		
		System.out.println(solve());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	private static int[][] map;
	private static boolean[][] visited;
	private static int y, x;
	private static int n, m;
	private static int direc;
	
	public static int solve() {
		int count = 0;
		
		while (true) {
			if (direc == 0) {
				if (x + 1 < m && !visited[y][x + 1] && map[y][x + 1] == 0) {
					visited[y][x + 1] = true;
					x++;
					count++;
					direc = 3;
					continue;
				} else if (y - 1 > -1 && !visited[y - 1][x] && map[y - 1][x] == 0) {
					visited[y - 1][x] = true;
					y--;
					count++;
					direc = 2;
					continue;
				} else if (x - 1 > -1 && !visited[y][x - 1] && map[y][x - 1] == 0) {
					visited[y][x - 1] = true;
					x--;
					count++;
					direc = 1;
					continue;
				} else if (y + 1 < n && !visited[y + 1][x] && map[y + 1][x] == 0) {
					visited[y + 1][x] = true;
					y++;
					count++;
					continue;
				} else {
					if (y - 1 > -1 && map[y - 1][x] == 0) {
						y--;
						continue;
					}
				}
			} else if (direc == 1) {
				if (y + 1 < n && !visited[y + 1][x] && map[y + 1][x] == 0) {
					visited[y + 1][x] = true;
					y++;
					count++;
					continue;
				} else if (x + 1 < m && !visited[y][x + 1] && map[y][x + 1] == 0) {
					visited[y][x + 1] = true;
					x++;
					count++;
					direc = 3;
					continue;
				} else if (y - 1 > -1 && !visited[y - 1][x] && map[y - 1][x] == 0) {
					visited[y - 1][x] = true;
					y--;
					count++;
					direc = 2;
					continue;
				} else if (x - 1 > -1 && !visited[y][x - 1] && map[y][x - 1] == 0) {
					visited[y][x - 1] = true;
					x--;
					count++;
					direc = 1;
					continue;
				} else {
					if (x + 1 < m && map[y][x + 1] == 0) {
						x++;
						continue;
					}
				}
			} else if (direc == 2) {
				if (x - 1 > -1 && !visited[y][x - 1] && map[y][x - 1] == 0) {
					visited[y][x - 1] = true;
					x--;
					count++;
					direc = 1;
					continue;
				} else if (y + 1 < n && !visited[y + 1][x] && map[y + 1][x] == 0) {
					visited[y + 1][x] = true;
					y++;
					count++;
					continue;
				} else if (x + 1 < m && !visited[y][x + 1] && map[y][x + 1] == 0) {
					visited[y][x + 1] = true;
					x++;
					count++;
					direc = 3;
					continue;
				} else if (y - 1 > -1 && !visited[y - 1][x] && map[y - 1][x] == 0) {
					visited[y - 1][x] = true;
					y--;
					count++;
					direc = 2;
					continue;
				} else {
					if (y + 1 < n && map[y + 1][x] == 0) {
						y++;
						continue;
					}
				}
			} else if (direc == 3) {
				 if (y - 1 > -1 && !visited[y - 1][x] && map[y - 1][x] == 0) {
						visited[y - 1][x] = true;
						y--;
						count++;
						direc = 2;
						continue;
				} else if (x - 1 > -1 && !visited[y][x - 1] && map[y][x - 1] == 0) {
					visited[y][x - 1] = true;
					x--;
					count++;
					direc = 1;
					continue;
				} else if (y + 1 < n && !visited[y + 1][x] && map[y + 1][x] == 0) {
					visited[y + 1][x] = true;
					y++;
					count++;
					continue;
				} else if (x + 1 < m && !visited[y][x + 1] && map[y][x + 1] == 0) {
					visited[y][x + 1] = true;
					x++;
					count++;
					direc = 3;
					continue;
				} else {
					if (x - 1 > -1 && map[y][x - 1] == 0) {
						x--;
						continue;
					}
				}
			}
			break;
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(reader.readLine());
		y = Integer.parseInt(token.nextToken()) - 1;
		x = Integer.parseInt(token.nextToken()) - 1;
		direc = Integer.parseInt(token.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; ++j)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
		
		System.out.println(solve());
	}*/
}
