package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11005 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		StringTokenizer token = new StringTokenizer(reader.readLine());
		long n = Long.parseLong( token.nextToken() );
		int b = Integer.parseInt( token.nextToken() );
		while (n > 0) {
			int r = (int)(n % b);
			if (r > 9)
				builder.insert(0, Character.toChars(r + 55));
			else
				builder.insert(0, r);
			n /= b;
		}
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
