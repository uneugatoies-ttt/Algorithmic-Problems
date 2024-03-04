package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1654_4 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tok = new StringTokenizer(reader.readLine());
		int k, n;
		long[] cables;
		long res = -100000l;

		k = Integer.parseInt(tok.nextToken());
		n = Integer.parseInt(tok.nextToken());
		cables = new long[k];
		
		for (int i = 0; i < k; ++i)
			cables[i] = Long.parseLong(reader.readLine());

		long l = 1, r = Arrays.stream(cables).max().orElseThrow();
		long mid;
		long temp;
		
		while (l <= r) {
			mid = (l + r) / 2;
			temp = 0;
			
			for (long c : cables)
				temp += (c / mid);
			
			if (temp >= n) {
				res = Math.max(res, mid);
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		
		bw.write(String.valueOf(res) + "\n");
		bw.flush();
	}

}
