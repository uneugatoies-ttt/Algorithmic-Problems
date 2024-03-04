package ict_practice.part3.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q02 {
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = reader.readLine();
		
		int res = Character.getNumericValue(str.charAt(0));
		
		int former;
		int ent;
		for (int i = 1; i < str.length(); ++i) {
			former = Character.getNumericValue(str.charAt(i - 1));
			ent = Character.getNumericValue(str.charAt(i));
			if (former == 1 || former == 0 || ent == 1 || ent == 0)
				res += ent;
			else
				res *= ent;
		}
		
		writer.write(String.valueOf(res));
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}