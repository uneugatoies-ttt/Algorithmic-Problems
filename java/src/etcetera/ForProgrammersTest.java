package etcetera;

import java.util.Scanner;

import ict_practice.part3.dfsbfs.Q22_1;

public class ForProgrammersTest {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] board = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				board[i][j] = s.nextInt();
		}
		
		Q22_1 q = new Q22_1();
		
		System.out.println(q.solution(board));
	}
	
}
