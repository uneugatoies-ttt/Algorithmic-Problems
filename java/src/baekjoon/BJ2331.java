package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ2331 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt( token.nextToken() );
		int p = Integer.parseInt( token.nextToken() );
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(n, 1);
		int count = 1, temp = n, i, res;
		
		while (true) {
			i = temp;
			temp = 0;
			while (i > 0) {
				temp += Math.pow(i % 10, p);
				i /= 10;
			}
			if (map.containsKey(temp)) {
				res = map.get(temp) - 1;
				break;
			}
			count++;
			map.put(temp, count);
		}
		
		writer.write(String.valueOf(res));
		writer.flush();
		writer.close();
		reader.close();
	}
}
