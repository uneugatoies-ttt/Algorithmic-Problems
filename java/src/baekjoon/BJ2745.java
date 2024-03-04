package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2745 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		String n = token.nextToken();
		int b = Integer.parseInt(token.nextToken());
		long result = 0;
		
		for (int i = 0; i < n.length(); i++) {
			try {
				result += ( (int) Math.pow( b, (n.length()-1-i) ) )*( Integer.parseInt( n.substring(i, i+1) ));
			} catch (Exception e) {
				result += ( (int) Math.pow( b, (n.length()-1-i) ) )*( n.charAt(i) - 55 );
			}
		}
		
		writer.write(Long.toString(result));
		writer.flush();
		writer.close();
		reader.close();
	}
}
