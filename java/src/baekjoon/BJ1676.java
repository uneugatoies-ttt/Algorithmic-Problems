package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ1676 {
	/*
	public static int countingEndZeros(int n) {
		int count = 0;
		while (n >= 5) {
			n /= 5;
			count += n;
		}
		return count;
	}*/
	public static int countingEndZeroes(int n) {
		int count = 0;
		int fives = 5;
		while ((n / fives) > 0) {
			count += (int)(n / fives);
			fives *= 5;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		
		int count = countingEndZeroes(n);
		
		writer.write(Integer.toString(count));
		writer.flush();
		writer.close();
		reader.close();
	}
}
