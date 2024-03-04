package ict_practice.part3.binsearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q27 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int l = 0;
		int r = n - 1;
		int mid;
		int cnt = -1;
		while (l <= r) {
			mid = (l + r) / 2;
			
			if (arr[mid] == x) {
				cnt = 1;
				int i = mid + 1;
				while (i < n && arr[i] == x) {
					cnt++;
					i++;
				}
				i = mid - 1;
				while (i > -1 && arr[i] == x) {
					cnt++;
					i--;
				}
				
				break;
			}
			
			if (x < arr[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		bw.write(String.valueOf(cnt) + "\n");
		bw.flush();
	}

}
