package ict_practice.part3.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// failed
/*
public class Q06_Programmers42891 {
	
	private static int increment(int target, int len) {
		target++;
		if (target >= len) 
			return 0;
		else
			return target;
	}
	
	public static int solution(int[] food_times, long k) {
		int len = food_times.length;
        int target = 0;
        long cnt = 0;
        int temp;
        boolean flag = false;
        
        while (cnt < k) {
        	temp = 0;
        	while (food_times[target] == 0) {
        		if (temp >= len) {
        			flag = true;
        			break;
        		}
        		target = increment(target, len);
        		temp++;
        	}
        	if (flag) {
        		target = -1;
        		break;
        	}
        	food_times[target]--;
        	cnt++;
        	target = increment(target, len);
        }
        
        if (target >= len)
        	return 1;
        else if (target == -1) 	
        	return -1;
        else				
        	return target + 1;
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


class Q06Solution {

}*/