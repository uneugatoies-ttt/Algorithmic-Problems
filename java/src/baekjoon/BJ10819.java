package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ10819 {
	private static int[] origArr = new int[8];
	private static boolean[] visited = new boolean[8];
	private static int result = -99999;
	
	public static void ans(Stack<Integer> permutation, int depth, int n) {
		if (depth == n) {
			int sum = 0;
			for (int i = 0; i < n - 1; ++i)
				sum += Math.abs(permutation.get(i) - permutation.get(i + 1));
			result = Math.max(result, sum);
		}
		for (int i = 0; i < n; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				permutation.add(origArr[i]);
				ans(permutation, depth + 1, n);
				visited[i] = false;
				permutation.pop();
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
			int n = Integer.parseInt(reader.readLine());
			StringTokenizer token = new StringTokenizer(reader.readLine());
			for (int i = 0; i < n; ++i)
				origArr[i] = Integer.parseInt( token.nextToken() );
			Stack<Integer> permutation = new Stack<>();
			
			ans(permutation, 0, n);
			
			writer.write(String.valueOf(result));
			writer.flush();
			writer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
