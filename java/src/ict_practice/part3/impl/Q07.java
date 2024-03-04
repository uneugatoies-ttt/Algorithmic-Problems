package ict_practice.part3.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q07 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String ent = reader.readLine();
		int len = ent.length();
		int ind = len / 2;
		
		int leftsum = 0;
		int rightsum = 0;
		
		for (int i = 0; i < ind; ++i)
			leftsum += Character.getNumericValue(ent.charAt(i));
		for (int i = ind; i < len; ++i)
			rightsum += Character.getNumericValue(ent.charAt(i));
		
		String res = null;
		if (leftsum == rightsum)
			res = "LUCKY";
		else 
			res = "READY";
		
		writer.write(res);
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
}
