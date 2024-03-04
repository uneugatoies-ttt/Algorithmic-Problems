package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11576 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		String firstLine = reader.readLine();
		int a = Integer.parseInt( firstLine.substring(0, firstLine.indexOf(" ")) );
		int b = Integer.parseInt( firstLine.substring(firstLine.indexOf(" ")+1) );
		int n = Integer.parseInt( reader.readLine() );
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int tempDec = 0;
		for (int i = n - 1; i >= 0; --i)
			tempDec += Integer.parseInt( token.nextToken() ) * Math.pow(a, i);
		
		while (tempDec > 0) {
			builder.insert(0, ' ').insert(0, tempDec % b);
			tempDec /= b;
		}
		builder.deleteCharAt(builder.length()-1);
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
