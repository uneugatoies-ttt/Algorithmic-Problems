package ict_practice.part3.binsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q28 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		int l = 0, r = n - 1;
		int mid;
		int res = -1;
		while (l <= r) {
			mid = (l + r) / 2;
			if (mid == arr[mid]) {
				res = mid;
				break;
			}
			if (mid > arr[mid])
				l = mid + 1;
			else
				r = mid - 1;
		}
		bw.write(String.valueOf(res));
		bw.flush();
	}

}
