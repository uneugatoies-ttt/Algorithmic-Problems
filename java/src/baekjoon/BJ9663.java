package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ9663 {
	private static int countCase = 0;
	
	public static boolean canPlaceThere(int[] pos, int row, int col) {
		for (int prevRow = 0; prevRow < row; ++prevRow) {
			if (
				pos[prevRow] == col ||
				Math.abs(pos[prevRow] - col) == Math.abs(prevRow - row)
			) return false;
		}
		return true;
	}
	
	public static void solve(int[] pos, int row, int n) {
		if (row == n) {
			countCase++;
			return;
		}
		for (int col = 0; col < n; ++col) {
			if (canPlaceThere(pos, row, col)) {
				pos[row] = col;
				solve(pos, row + 1, n);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		int[] pos = new int[n];
		for (int i = 0; i < n; ++i)
			pos[i] = 0;
		
		solve(pos, 0, n);

		writer.write(String.valueOf(countCase));
		writer.flush();
		writer.close();
		reader.close();
	}
}
