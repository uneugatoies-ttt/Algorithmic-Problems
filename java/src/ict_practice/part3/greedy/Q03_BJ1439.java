package ict_practice.part3.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q03_BJ1439 {

	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String inputValue = reader.readLine();
		int[] arr = new int[1000000];
		
		for (int i = 0; i < inputValue.length(); ++i)
			arr[i] = Character.getNumericValue(inputValue.charAt(i));
		
		int zeroes = 0;
		int ones = 0;
		
		if (arr[0] == 0)
			zeroes++;
		else 
			ones++;
		
		for (int i = 1; i < inputValue.length(); ++i) {
			if (arr[i] == 0) {
				if (arr[i - 1] == 0) 	
					continue;
				else
					zeroes++;
			} else {
				if (arr[i - 1] == 1)
					continue;
				else
					ones++;
			}
		}
		
		if ((zeroes == 1 && ones == 0) || (zeroes == 0 && ones == 1))
			writer.write(String.valueOf(0));
		else
			writer.write(String.valueOf(Math.min(zeroes, ones)));
		
		writer.write('\n');
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
}
