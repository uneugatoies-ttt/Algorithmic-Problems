package ict_practice.part3.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This would work, but this was not the intention of the problem.
public class Q35 {
	
	private static void solve() {
		Scanner s = new Scanner(System.in);
		double n = s.nextInt();
		
		int size = (int) Math.ceil( Math.pow(n, 1.0/3.0) );
		size++;
		
		long[] fives = new long[size];
		long[] threes = new long[size];
		long[] twos = new long[size];
		
		for (int i = 0; i < size; ++i) {
			fives[i] = (long) Math.pow(5, i);
			threes[i] = (long) Math.pow(3, i);
			twos[i] = (long) Math.pow(2, i);
		}
		
		List<Long> list = new ArrayList<>();
		list.add(1L);
		long temp;
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				for (int k = 0; k < size; ++k) {
					temp = fives[i] * threes[j] * twos[k];
					if (list.contains(temp)) continue;
					list.add(temp);
				}
			}
		}
		
		System.out.println(list.get(((int)n) - 1));
	}
	
	public static void main(String[] args) {
		solve();
	}

}
