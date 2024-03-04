package ict_practice.part3.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.AbstractMap.SimpleImmutableEntry;

public class Q11_2 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		// "n" is this square board's width.
		int n = Integer.parseInt(reader.readLine());
		// "k" is the number of apples, which are items that increase the size of the snake.
		int k = Integer.parseInt(reader.readLine());
		
		// "board" is this game's board; 1 if there's an apple, 0 otherwise.
		int[][] board = new int[n + 1][n + 1];
		
		StringTokenizer token;
		
		int y, x;
		for (int i = 0; i < k; ++i) {
			token = new StringTokenizer(reader.readLine());
			y = Integer.parseInt(token.nextToken());
			x = Integer.parseInt(token.nextToken());
			board[y][x] = 1;
		}
		
		int l = Integer.parseInt(reader.readLine());
		// "chdir" is the time when direction change of the snake's head should be done.
		// if its value is 'L', the snake will turn left (90 degree); if 'R', will turn right.
		Map<Integer, Character> chdir = new HashMap<>();
		for (int i = 0; i < l; ++i) {
			token = new StringTokenizer(reader.readLine());
			chdir.put(Integer.parseInt(token.nextToken()), token.nextToken().charAt(0));
		}
		
		
		writer.write(String.valueOf(simulate(n, k, board, chdir)));
		writer.write('\n');
		writer.flush();
		writer.close();
		reader.close();
	}
	
	private static int turn(int direction, int c) {
		if (c == 'L')
			direction = (direction == 0) ? 3 : direction - 1;
		else
			direction = (direction + 1) % 4;
		return direction;
	}
	
	private static int simulate(
		int n,
		int k,
		int[][] board,
		Map<Integer, Character> chdir
	) {
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		
		int y = 1;
		int x = 1;
		
		board[y][x] = 2;
		int direction = 0;
		int second = 0;
		
		Queue<Entry<Integer, Integer>> q = new ArrayDeque<>();
		q.add(new SimpleImmutableEntry<>(y, x));
		
		int nx, ny;
		while (true) {
			ny = y + dy[direction];
			nx = x + dx[direction];
			
			if (1 <= nx && nx <= n && 1 <= ny && ny <=n && board[ny][nx] != 2) {
				if (board[ny][nx] == 0) {
					board[ny][nx] = 2;
					q.add(new SimpleImmutableEntry<>(ny, nx));
					int py = q.peek().getKey();
					int px = q.peek().getValue();
					
					// The first attempt was failed since I wasn't
					// performing the poll() operation on the queue.
					// Remember this has to be done.
					q.poll();
					board[py][px] = 0;
				} 
				if (board[ny][nx] == 1) {
					board[ny][nx] = 2;
					q.add(new SimpleImmutableEntry<>(ny, nx));
				}
			} else {
				second++;
				break;
			}
			y = ny;
			x = nx;
			second++;
			if (chdir.containsKey(second)) {
				direction = turn(direction, chdir.get(second));
			}
		}
		return second;
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
