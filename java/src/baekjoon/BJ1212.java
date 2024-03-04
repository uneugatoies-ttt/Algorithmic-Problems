package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ1212 {
	public static void main(String[] args) throws IOException {
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String o = reader.readLine();
		
		for (int i = 0; i < o.length(); ++i) {
			int temp = o.charAt(i) - '0';
			switch (temp) {
			case 0:
				builder.append("000");
				break;
			case 1:
				builder.append("001");
				break;
			case 2:
				builder.append("010");
				break;
			case 3:
				builder.append("011");
				break;
			case 4:
				builder.append("100");
				break;
			case 5:
				builder.append("101");
				break;
			case 6:
				builder.append("110");
				break;
			case 7:
				builder.append("111");
				break;
			}
			
		}
		
		if (builder.charAt(0) == '0' && builder.charAt(1) == '0')
			builder.delete(0, 2);
		else if (builder.charAt(0) == '0')
			builder.delete(0, 1);
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
