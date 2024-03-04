package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ10816 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt(token.nextToken());
		
		Map<Integer, Integer> map = new HashMap<>();
		
		token = new StringTokenizer(reader.readLine());
		int card;
		for (int i = 0; i < n; ++i) {
			card = Integer.parseInt(token.nextToken());
			if (map.containsKey(card)) {
				map.replace(card, map.get(card) + 1);
			} else {
				map.put(card, 1);
			}
		}
		
		int m = Integer.parseInt((new StringTokenizer(reader.readLine()).nextToken()));
		int[] whether = new int[m];
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < m; ++i)
			whether[i] = Integer.parseInt(token.nextToken());
		
		int cnt;
		for (int i = 0; i < m; ++i) {
			cnt = 0;
			if (map.containsKey(whether[i])) {
				cnt = map.get(whether[i]);
			}
			
			writer.write(String.valueOf(cnt));
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
