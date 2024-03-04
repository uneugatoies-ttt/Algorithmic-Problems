package ict_practice.part3.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
	-> Although this is way less efficient than other solutions, the logic itself is
	still valid.
	
	But, I could pass the test only after I got a number of failed attempts.
	The last hampering problem was caused by the order of the parts that are
	executed within the logic.
	
	For example:
		1) checking whether an apple is at the next location should've been
		done after the assignment of "temppos" is done. But this was 
		reversed.
*/


public class Q11 {
	
	private static int n, k, l;
	
	private static int simulate(int[][] board, Map<Integer, Character> chdir) {
		int second = 0;
		List<BodyPart> snake = new ArrayList<>();
		
		snake.add(new BodyPart(0, 0, 1));
		
		// "changedAt" is the 2 dimensional array to keep track of places where
		// the snake turned its head's direction.
		int[][] changedAt = new int[n][n];
		
		for (int i = 0; i < n; ++i)
			Arrays.fill(changedAt[i], -1);
		
		boolean breakFlag = false;
		boolean appleFlag = false;
		int[] temppos = new int[2];
		
		while (true) {
			if (chdir.containsKey(second))
				changeDirectionHead(snake, chdir.get(second), changedAt);
			
			// Perform loops from snake[1] to snake[snake.length - 2]
			for (int i = 0; i < snake.size() - 1; ++i) {
				if (changedAt[snake.get(i).y][snake.get(i).x] > -1)
					snake.get(i).direction = changedAt[snake.get(i).y][snake.get(i).x];
				
				temppos[0] = snake.get(i).y;
				temppos[1] = snake.get(i).x;
				
				// Move this element to the correct position
				// by assigning "temppos"
				// North
				if (snake.get(i).direction == 0)
					temppos[0]--;
				// East
				if (snake.get(i).direction == 1)
					temppos[1]++;
				// South
				if (snake.get(i).direction == 2)
					temppos[0]++;
				// West
				if (snake.get(i).direction == 3)
					temppos[1]--;
				
				// Check whether this motion ends up in hitting walls or its own body
				if (temppos[0] < 0 || temppos[0] >= n || temppos[1] < 0 || temppos[1] >= n) {
					breakFlag = true;
					break;
				}
				for (int j = 0; j < snake.size(); ++j) {
					if (snake.get(j).y == temppos[0] && snake.get(j).x == temppos[1]) {
						breakFlag = true;
						break;
					}
				}
				if (breakFlag)
					break;

				// If it doesn't hit anything, then update "snake"
				snake.get(i).y = temppos[0];
				snake.get(i).x = temppos[1];
				
				// Check the apple if this is the first element
				if (i == 0 && board[snake.get(i).y][snake.get(i).x] == 1) {
					board[snake.get(i).y][snake.get(i).x] = 0;
					appleFlag = true;
				}
			}
			
			// Check "breakFlag"
			if (breakFlag)
				break;
			
			temppos[0] = snake.get(snake.size() - 1).y;
			temppos[1] = snake.get(snake.size() - 1).x;

			
			// check whether the last element of "snake" changes direction
			if (changedAt[temppos[0]][temppos[1]] > -1) {
				snake.get(snake.size() - 1).direction = changedAt[temppos[0]][temppos[1]];
				changedAt[temppos[0]][temppos[1]] = -1;
			}				
			// North
			if (snake.get(snake.size() - 1).direction == 0)
				temppos[0]--;
			// East
			if (snake.get(snake.size() - 1).direction == 1)
				temppos[1]++;
			// South
			if (snake.get(snake.size() - 1).direction == 2)
				temppos[0]++;
			// West
			if (snake.get(snake.size() - 1).direction == 3)
				temppos[1]--;
			
			// Check whether this motion ends up in hitting walls or its own body
			if (temppos[0] < 0 || temppos[0] >= n || temppos[1] < 0 || temppos[1] >= n) {
				breakFlag = true;
				break;
			}
			for (int j = 0; j < snake.size(); ++j) {
				if (snake.get(j).y == temppos[0] && snake.get(j).x == temppos[1]) {
					breakFlag = true;
					break;
				}
			}
			if (breakFlag)
				break;
			
			if (snake.size() == 1 && board[temppos[0]][temppos[1]] == 1) {
				board[temppos[0]][temppos[1]] = 0;
				appleFlag = true;
			}

			if (appleFlag) {
				//int dir = snake.get(snake.size() - 1).direction;
				//if (dir == 0) 
				snake.add(new BodyPart(
						snake.get(snake.size() - 1).y,
						snake.get(snake.size() - 1).x,
						snake.get(snake.size() - 1).direction));
				snake.get(snake.size() - 2).y = temppos[0];
				snake.get(snake.size() - 2).x = temppos[1];
				appleFlag = false;
			} else {
				snake.get(snake.size() - 1).y = temppos[0];
				snake.get(snake.size() - 1).x = temppos[1];
			}
			
			// Increase "second"
			second++;

		}
		
		second++;
		
		return second;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// "n" is this square board's width.
		n = Integer.parseInt(reader.readLine());
		// "k" is the number of apples, which are items that increase the size of the snake.
		k = Integer.parseInt(reader.readLine());
		
		// "board" is this game's board; 1 if there's an apple, 0 otherwise.
		int[][] board = new int[n][n];
		
		StringTokenizer token;
		
		int y, x;
		for (int i = 0; i < k; ++i) {
			token = new StringTokenizer(reader.readLine());
			y = Integer.parseInt(token.nextToken()) - 1;
			x = Integer.parseInt(token.nextToken()) - 1;
			board[y][x] = 1;
		}
		
		l = Integer.parseInt(reader.readLine());
		// "chdir" is the time when direction change of the snake's head should be done.
		// if its value is 'L', the snake will turn left (90 degree); if 'R', will turn right.
		Map<Integer, Character> chdir = new HashMap<>();
		for (int i = 0; i < l; ++i) {
			token = new StringTokenizer(reader.readLine());
			chdir.put(Integer.parseInt(token.nextToken()), token.nextToken().charAt(0));
		}
		
		int second = simulate(board, chdir);;
		
		writer.write(String.valueOf(second));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	private static void changeDirectionHead(List<BodyPart> snake, char lr, int[][] changedAt) {
		if (lr == 'L')
			snake.get(0).direction = (snake.get(0).direction == 0) ? 3 : snake.get(0).direction - 1;
		else
			snake.get(0).direction = (snake.get(0).direction + 1) % 4;
		
		changedAt[snake.get(0).y][snake.get(0).x] = snake.get(0).direction;
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}

class BodyPart {
	
	int y;
	int x;
	int direction;
	
	public BodyPart(int y, int x, int direction) {
		this.y = y;
		this.x = x;
		this.direction = direction;
	}
	
}
