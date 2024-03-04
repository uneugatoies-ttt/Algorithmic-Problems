package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2110_2 {
	
	private static int[] houses;
	private static int houseNum, routerNum;
	
	private static int bs() {
		int left = 1;
		int right = houses[houseNum - 1];
		int mid, temp, pos;
		
		while (left <= right) {
			mid = (left + right) / 2;
			pos = 0;
			temp = 1;
			for (int i = 1; i < houseNum; ++i) {
				if (houses[i] - houses[pos] >= mid) {
					temp++;
					pos = i;
				}
			}
			
			if (temp >= routerNum)
				left = mid + 1;
			else
				right = mid - 1;
		}
		
		return left - 1;
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		houseNum = Integer.parseInt(token.nextToken());
		routerNum = Integer.parseInt(token.nextToken());
		
		houses = new int[houseNum];
		for (int i = 0; i < houseNum; ++i)
			houses[i] = Integer.parseInt((new StringTokenizer(reader.readLine()).nextToken()));
		Arrays.sort(houses);
		
		writer.write(String.valueOf(bs()));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
