package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1373 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		String binaryNum = token.nextToken();
		
		if (binaryNum.length() % 3 == 2) {
			builder.append(
				2*Integer.parseInt( binaryNum.substring(0, 1) ) 
				+ Integer.parseInt( binaryNum.substring(1, 2) )  
			);
			binaryNum = binaryNum.substring(2, binaryNum.length());
		} else if (binaryNum.length() % 3 == 1) {
			builder.append(
				Integer.parseInt( binaryNum.substring(0, 1) ) 
			);
			binaryNum = binaryNum.substring(1, binaryNum.length());
		}
		
		for (int i = 0; i < (binaryNum.length() / 3); i++) {
			builder.append(
				4*Integer.parseInt( binaryNum.substring((i*3), (i*3)+1))
				+ 2*Integer.parseInt( binaryNum.substring((i*3)+1, (i*3)+2))
				+ Integer.parseInt( binaryNum.substring((i*3)+2, (i*3)+3))
			);
		}
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
