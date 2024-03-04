package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ2089 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		
		writer.write(decToNeg2(n));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static String decToNeg2(int decimal) {
		if (decimal == 0) return "0";
		StringBuilder builder = new StringBuilder();
		while (decimal != 0) {
			int remainder = decimal % -2;
			decimal /= -2;
			if (remainder < 0) {
				remainder += 2;
				decimal += 1;
			}
			builder.insert(0, remainder);
		}
		return builder.toString();
	}
}
