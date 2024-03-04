package ict_practice.part3.dfsbfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q22_1 {
	
	// This method is for getting the positions that are available 
	// from the current position.
	private List<RobotPos> getNextPos(RobotPos pos, int[][] board) {
		List<RobotPos> nextPos = new ArrayList<>();
		
		int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
		
		// OPTION 1: NESW
		for (int i = 0; i < 4; ++i) {
			int ny1 = pos.y1 + dir[i][0];
			int nx1 = pos.x1 + dir[i][1];
			int ny2 = pos.y2 + dir[i][0];
			int nx2 = pos.x2 + dir[i][1];
			int ntime = pos.time + 1;
			
			// If the two cells that we want to move the robot are empty:
			if (board[ny1][nx1] == 0 && board[ny2][nx2] == 0)
				nextPos.add(new RobotPos(ny1, nx1, ny2, nx2, ntime));
		}
		
		// OPTION 2: ROTATION
		// The robot is currently placed horizontally
		if (pos.y1 == pos.y2) {
			// vert[0]: rotate upward; vert[1]: rotate downward;
			int[] vert = {-1,1};
			
			for (int i = 0; i < 2; ++i) {
				if (board[pos.y1 + vert[i]][pos.x1] == 0 && board[pos.y2 + vert[i]][pos.x2]== 0) {
					nextPos.add(new RobotPos(pos.y1, pos.x1, pos.y1 + vert[i], pos.x1, pos.time + 1));
					nextPos.add(new RobotPos(pos.y2, pos.x2, pos.y2 + vert[i], pos.x2, pos.time + 1));
				}
			}
		}
		
		// The robot is currently placed vertically
		if (pos.x1 == pos.x2) {
			// horiz[0]: rotate leftward; horiz[1]: rotate rightward;
			int[] horiz = {-1,1};
			for (int i = 0; i < 2; ++i) {
				if (board[pos.y1][pos.x1 + horiz[i]] == 0 && board[pos.y2][pos.x2 + horiz[i]] == 0) {
					nextPos.add(new RobotPos(pos.y1, pos.x1, pos.y1, pos.x1 + horiz[i], pos.time + 1));
					nextPos.add(new RobotPos(pos.y2, pos.x2, pos.y2, pos.x2 + horiz[i], pos.time + 1));
				}
			}
		}
		
		return nextPos;
	}
	
	private int bfs(int n, int[][] newboard) {
		Queue<RobotPos> q = new ArrayDeque<>();
		List<RobotPos> visited = new ArrayList<>();
		// Since we have expanded the board, the starting index must be (1,1) and (1,2).
		RobotPos pos = new RobotPos(1, 1, 1, 2, 0);
		q.add(pos);
		visited.add(pos);
		
		while (!q.isEmpty()) {
			pos = q.poll();
			if ((pos.y1 == n && pos.x1 == n) || (pos.y2 == n && pos.x2 == n))
				return pos.time;
			
			List<RobotPos> nextPos = getNextPos(pos, newboard);
			for (int i = 0; i < nextPos.size(); ++i) {
				boolean check = true;
				pos = nextPos.get(i);
				for (int j = 0; j < visited.size(); ++j) {
					if (
						pos.y1 == visited.get(j).y1 && pos.x1 == visited.get(j).x1 &&
						pos.y2 == visited.get(j).y2 && pos.x2 == visited.get(j).x2
					)
					{
						check = false;
						break;
					}
				}
				
				if (check)
				{
					q.add(pos);
					visited.add(pos);
				}
			}
		}
		return 0;
	}
	
	public int solution(int[][] board) {
		int n = board.length;
		// Expand the original board by 2 each horizontally and vertically.
		int[][] newboard = new int[n + 2][n + 2];
		for (int i = 0; i < n + 2; ++i) {
			for (int j = 0; j < n + 2; ++j)
				newboard[i][j] = 1;
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				newboard[i + 1][j + 1] = board[i][j];
		}
		
		return bfs(n, newboard);
	}
	
	public static class RobotPos {
		int y1;
		int x1;
		int y2;
		int x2;
		int time;
		
		public RobotPos(int y1, int x1, int y2, int x2, int time) {
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
			this.time = time;
		}
	}
	
}