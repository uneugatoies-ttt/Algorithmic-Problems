package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ10834 {
	private static int[] queue = new int[10000];
	private static int head = 0;
	private static int tail = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
		StringTokenizer token = null;
		int n = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			switch (token.nextToken()) {
			case "push":
				push(Integer.parseInt(token.nextToken()));
				continue;
			case "pop":
				builder.append(pop()).append('\n');
				continue;
			case "size":
				builder.append(size()).append('\n');
				continue;
			case "empty":
				builder.append(empty()).append('\n');
				continue;
			case "front":
				builder.append(front()).append('\n');
				continue;
			case "back":
				builder.append(back()).append('\n');
				continue;
			}
		}
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void push(int x) {
		queue[tail++] = x;
	}
	
	public static int pop() {
		if (size() == 0) return -1;
		return queue[head++];
	}
	
	public static int size() {
		return tail - head;
	}
	
	public static int empty() {
		return size() == 0 ? 1 : 0;
	}
	
	public static int front() {
		if (size() == 0) return -1;
		return queue[head];
	}
	
	public static int back() {
		if (size() == 0) return -1;
		return queue[tail - 1];
	}
}
