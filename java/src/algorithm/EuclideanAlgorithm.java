package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class EuclideanAlgorithm {
	public static long euclidean(long a, long b) {
		if (a < b) {
			long swap = a;
			a = b;
			b = swap;
		}
		long r = a % b;
		if (r == 0)
			return b;
		else 
			return euclidean(b, r);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		
		StringTokenizer token1 = new StringTokenizer(reader.readLine());
		long a = Long.parseLong(token1.nextToken());
		long b = Long.parseLong(token1.nextToken());
		
		long r = euclidean(a, b);
		
		for (long i = 0; i < r; i++)
			builder.append(1);
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
}
