package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2004 {
	public static long countMultiples5(long num) {
		long count = 0L;
		while (num >= 5) {
			count += (long) num / 5;
			num = (long) num / 5;
		}
		return count;
	}
	
	public static long countMultiples2(long num) {
		long count = 0L;
		while (num >= 2) {
			count += (long) num / 2;
			num = (long) num / 2;
		}
		return count;
	}
	
	public static long countTrailZeros(long n, long m) {
		long count5 = countMultiples5(n) - countMultiples5(n - m) - countMultiples5(m);
		long count2 = countMultiples2(n) - countMultiples2(n - m) - countMultiples2(m);
		return Math.min(count5, count2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		long n = Long.parseLong(token.nextToken());
		long m = Long.parseLong(token.nextToken());

		long count = countTrailZeros(n, m);
		
		writer.write(Long.toString(count));
		writer.flush();
		writer.close();
		reader.close();
	}
}
	
	// failed attempt
	/*
	public static long countTrailZeroes(long number) {
		long count = 0L;
		long fives = 5L;
		while ((number / fives) > 0) {
			count += (long) (number / fives);
			fives *= 5;
		}
		return count;
	}
	
	public static long countCombTrailZeroes(long n, long m) {
		long countNumer = countTrailZeroes(n) - countTrailZeroes(n - m);
		long countDenom = countTrailZeroes(m);
		return Math.min(countNumer - countDenom, 0);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		long n = Long.parseLong(token.nextToken());
		long m = Long.parseLong(token.nextToken());

		long trailingZeroes = countCombTrailZeroes(n, m);
		writer.write(Long.toString( trailingZeroes ));
		writer.flush();
		writer.close();
		reader.close();
	}
}*/
