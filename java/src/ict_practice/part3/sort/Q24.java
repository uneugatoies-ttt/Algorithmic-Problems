package ict_practice.part3.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q24 {
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] houses = new int[n];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			houses[i] = Integer.parseInt(token.nextToken());
		
		if (n == 1) {
			System.out.println(houses[0]);
			return;
		}
		
		Arrays.sort(houses);
		
		int center = n / 2 - 1;
		int dist = 0;
		for (int i = 0; i < n; ++i)
			dist += Math.abs(houses[center] - houses[i]);
		
		int templ = center - 1;
 		int tempdist;
		boolean leftflag = false;
		while (templ >= 0) {
			tempdist = 0;
			for (int i = 0; i < n; ++i)
				tempdist += Math.abs(houses[templ] - houses[i]);
			if (tempdist < dist) {
				leftflag = true;
				dist = tempdist;
				templ--;
			} else {
				break;
			}
		}
		
		int tempr = center + 1;
		boolean rightflag = false;
		while (tempr < n) {
			tempdist = 0;
			for (int i = 0; i < n; ++i)
				tempdist += Math.abs(houses[tempr] - houses[i]);
			if (tempdist < dist) {
				rightflag = true;
				dist = tempdist;
				tempr++;
			} else {
				break;
			}
		}
		
		if (leftflag) {
			if (rightflag)
				System.out.println(houses[tempr - 1]);
			else
				System.out.println(houses[templ + 1]);
		} else {
			if (rightflag)
				System.out.println(houses[tempr - 1]);
			else
				System.out.println(houses[center]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
}




/*
public class Q24 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] houses = new int[n];
		StringTokenizer token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; ++i)
			houses[i] = Integer.parseInt(token.nextToken());
		Arrays.sort(houses);
		int ind = n / 2 - 2;
		int temp = houses[ind + 1];
		while (houses[ind] == temp)
			ind--;
		
		int dist = 0;
		for (int i = 0; i < n; ++i)
			dist += Math.abs(temp - houses[i]);
		
		while (true) {
			int tempdist = 0;
			for (int i = 0; i < n; ++i)
				tempdist += Math.abs(houses[ind] - houses[i]);
			if (tempdist < dist) 
				ind--;
			else
				break;
		}
		
		System.out.println(houses[ind + 1]);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}
*/