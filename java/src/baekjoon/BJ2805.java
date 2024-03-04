package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2805 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int[] timber = new int[n];
		
		long left = 0;
		long right = -1;
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i) {
			timber[i] = Integer.parseInt(token.nextToken());
			right = Math.max(timber[i], right);
		}
		
		long mid, temp, res = -999999l;
		while (left <= right) {
			temp = 0;
			mid = (left + right) / 2;
			for (int t : timber)
				temp += ( (t - mid) >= 0 ? (t - mid) : 0 );
			if (temp >= m) {
				res = Math.max(res, mid);
				left = mid + 1;
			} else 
				right = mid - 1;
		}
		
		writer.write(String.valueOf(res));
		writer.flush();
		writer.close();
		reader.close();
	}

}
