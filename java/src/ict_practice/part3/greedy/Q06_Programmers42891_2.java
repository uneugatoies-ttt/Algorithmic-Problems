package ict_practice.part3.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


// failed
/*
public class Q06_Programmers42891_2 {
	
	public static int solution(int[] food_times, long k) {
		int len = food_times.length;
		int i;
		int temp;
		long cnt = 0;
		boolean flag = false;
		while (true) {
			temp = 0;
			for (i = 0; i < len; ++i) {
				if (food_times[i] != 0) {
					cnt++;
					food_times[i]--;
				}
				if (cnt >= k) {
					flag = true;
					break;
				}
			}
			if (flag)
				break;
			if (temp >= len) {
				i = -2;
				break;
			}
		}
		
		if (i >= len) i = 0;
		
		return i + 1;

    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		long k = Long.parseLong(reader.readLine());
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int[] ft = new int[n];
		for (int i = 0; i < n; ++i) {
			ft[i] = Integer.parseInt(token.nextToken());
		}
		
		//Q06Solution s = new Q06Solution();
		
		//writer.write(String.valueOf(s.solution(ft, k)));
		writer.write(String.valueOf(solution(ft, k)));
		writer.flush();
		writer.close();
		reader.close();
	}
	

}

*/