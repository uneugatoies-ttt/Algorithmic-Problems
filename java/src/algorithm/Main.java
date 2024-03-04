package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int a = Integer.parseInt( token.nextToken() );
		int b = Integer.parseInt( token.nextToken() );
		
		if (b > a) {
			int swap = a;
			a = b;
			b = swap;
		}
		
		int gcd;
		for (gcd = b; (gcd > 0); gcd--) {
			if (a % gcd == 0 && b % gcd == 0)
				break;
		}

		int lcm = (a * b) / gcd;
		
		builder.append(gcd).append("\n").append(lcm);
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
