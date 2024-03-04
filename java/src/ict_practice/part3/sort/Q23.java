package ict_practice.part3.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q23 {

	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		
		StringTokenizer token;
		int g, e, m; String name;
		List<Student> l = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			name = token.nextToken();
			g = Integer.parseInt(token.nextToken());
			e = Integer.parseInt(token.nextToken());
			m = Integer.parseInt(token.nextToken());
			l.add(new Student(g, e, m, name));
		}
		
		Collections.sort(l);
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; ++i)
			builder.append(l.get(i).name + "\n");
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
	private static class Student implements Comparable<Student> {
		int g;
		int e;
		int m;
		String name;
		
		public Student(int g, int e, int m, String name) {
			this.g = g;
			this.e = e;
			this.m = m;
			this.name = name;
		}
		
		@Override
		public int compareTo(Student o) {
			if (this.g == o.g) {
				if (this.e == o.e) {
					if (this.m == o.m)
						return this.name.compareTo(o.name);
					
					return o.m - this.m;
				}
				return this.e - o.e;
			}
			return o.g - this.g;
		}
	}
}


