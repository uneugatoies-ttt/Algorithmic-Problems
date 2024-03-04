package ict_practice.part3.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q08 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String ent = reader.readLine();
		List<Integer> ints = new ArrayList<>();
		List<Character> chars = new ArrayList<>();
		
		char c;
		for (int i = 0; i < ent.length(); ++i) {
			c = ent.charAt(i);
			if (c < 65)
				ints.add(Character.getNumericValue(c));
			else 
				chars.add(c);
		}
		
		Collections.sort(ints);
		Collections.sort(chars);
		
		for (char i : chars)
			writer.write(i);
		
		int sum = 0;
		for (int i : ints)
			sum += i;
		writer.write(String.valueOf(sum));
		writer.write('\n');
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	

}
