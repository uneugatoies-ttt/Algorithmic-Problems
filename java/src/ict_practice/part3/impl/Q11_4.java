package ict_practice.part3.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11_4 {
	
	public static int n, k, l;
	public static int[][] arr = new int[101][101];
	public static ArrayList<Q11_4DirectionChange> dirch
		= new ArrayList<>();
	
	public static int dy[] = {0, 1, 0, -1};
	public static int dx[] = {1, 0, -1, 0};
	
	public static int turn(int direction, char c) {
		if (c == 'L')
			direction = (direction == 0) ? 3 : direction - 1;
		else
			direction = (direction + 1) % 4;
		return direction;
	}
	
	public static int simulate() {
		// Initial location of the head is (1, 1), and it is indicated by "2"
		int y = 1, x = 1;
		arr[y][x] = 2;
		
		// Initial direction is the east.
		int direction = 0;
		
		int second = 0;
		
		// "index" keeps track of the index of "info".
		int index = 0;
		
		// The location of the snake's all body parts.
		Queue<Q11_4Position> q = new ArrayDeque<>();
		q.add(new Q11_4Position(y, x));
		
		while (true) {
			int ny = y + dy[direction];
			int nx = x + dx[direction];
			
			// If it is in the board's extent, and it doesn't hit the snake itself.
			if (1 <= ny && ny <= n && 1 <= nx && nx <= n && arr[ny][nx] != 2)
			{
				// There is no apple at the location.
				if (arr[ny][nx] == 0)
				{
					arr[ny][nx] = 2;
					q.add(new Q11_4Position(ny, nx));
					Q11_4Position prev = q.poll();
					arr[prev.getY()][prev.getX()] = 0;
				}
				
				// There is an apple at the location.
				if (arr[ny][nx] == 1)
				{
					arr[ny][nx] = 2;
					q.add(new Q11_4Position(ny, nx));
				}
			}
			// If it hits the wall or the snake's body.
			else
			{
				second++;
				break;
			}
			
			y = ny;
			x = nx;
			
			second++;
			
			if (index < l && second == dirch.get(index).getTime()) {
				direction = turn(direction, dirch.get(index).getDirection());
				index++;
			}
		}
		
		return second;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(reader.readLine());
        k = Integer.parseInt(reader.readLine());
        
        StringTokenizer token;
        // the board; 1 if there is an apple, 0 otherwise.
        for (int i = 0; i < k; i++) {
        	token = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            arr[a][b] = 1;
        }

        // the direction change 
        l = Integer.parseInt(reader.readLine());
        for (int i = 0; i < l; i++) {
        	token = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(token.nextToken());
            char c = token.nextToken().charAt(0);
            dirch.add(new Q11_4DirectionChange(x, c));
        }
		
		writer.write(String.valueOf(simulate()));
		writer.write('\n');
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
}

// Representing each time when the direction change should happen.
class Q11_4DirectionChange {
	
	private int time;
	private char direction;
	
	public Q11_4DirectionChange(int time, char direction) {
		this.time = time;
		this.direction = direction;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public char getDirection() {
		return this.direction;
	}
	
}

class Q11_4Position {
	
	private int y;
	private int x;
	
	public Q11_4Position(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}

}