package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10815 {
	
	private static int[] cards;
	private static int[] whether;
	
	private static int bs(int target) {
		int left = 0;
		int right = cards.length - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (cards[mid] == target) {
				return 1;
			} else if (cards[mid] < target) {
				left = mid + 1;
			} else if (cards[mid] > target) {
				right = mid - 1;
			}
		}
		
		return 0;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		cards = new int[n];
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			cards[i] = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt((new StringTokenizer(reader.readLine()).nextToken()));
		whether = new int[m];
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < m; ++i)
			whether[i] = Integer.parseInt(token.nextToken());
		Arrays.sort(cards);
		
		
		for (int i = 0; i < m; ++i) {
			writer.write(String.valueOf(bs(whether[i])));
			writer.write(' ');
		}
		
		writer.write('\n');
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
