package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2110 {
	
	private static int[] houses;
	private static int houseNum, routerNum;
	
	private static int bs() {
		int left = 1;		// Why do you have to assign 1 instead of houses[0]?
		int right = houses[houseNum - 1];
		
		int pos, cnt;
		while (left <= right) {
			int mid = (left + right) / 2;
			
			pos = 0;
			cnt = 1;
			
			for (int i = 1; i < houseNum; ++i) {
				if (houses[i] - houses[pos] >= mid) {
					pos = i;
					cnt++;
				}
			}
			
			if (cnt >= routerNum)
				left = mid + 1;
			else
				right = mid - 1;
		}
		
		return left - 1;	// What is the implication of (left - 1)?
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


//Fucking failed attempt
	/*
	private static int houseNum, routerNum;
	private static int[] houses;
	private static int[] routers;
	private static boolean[] settled;
	
	private static void bs() {
		int cnt = 2;
		int num = houses[houseNum - 1];
		int left, right, mid;
		int dist = Integer.MAX_VALUE;
		int closest = -1;
		while (cnt < routerNum) {
			left = houses[0];
			right = num;
			
			while (left <= houseNum || cnt < routerNum) {
				mid = (left + right) / 2;
				for (int i = 0; i < houseNum; ++i) {
					if (settled[i]) continue;
					if (dist > Math.abs(mid - houses[i])) {
						dist = Math.abs(mid - houses[i]);
						closest = i;
					}
				}
				routers[cnt] = houses[closest];
				cnt++;
				left = right + 1;
				right = left + num;
			}
			
			num /= 2;
		}
		
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		houseNum = Integer.parseInt(token.nextToken());
		routerNum = Integer.parseInt(token.nextToken());
		
		houses = new int[houseNum];
		routers = new int[routerNum];
		settled = new boolean[houseNum];
		
		for (int i = 0; i < houseNum; ++i)
			houses[i] = Integer.parseInt((new StringTokenizer(reader.readLine()).nextToken()));
			
		Arrays.sort(houses);
		settled[0] = true;
		settled[houseNum - 1] = true;
		routers[0] = houses[0];
		routers[1] = houses[houseNum - 1];
		
		bs();
		
		Arrays.sort(routers);
		
		int mn = Math.abs(routers[0] - routers[1]);
		
		for (int i = 1; i < routerNum - 1; ++i)
			mn = Math.min(mn, Math.abs(routers[i] - routers[i + 1]));
		
		writer.write(String.valueOf(mn) + '\n');
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}*/

