package algorithm.josephus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Josephus001 {
    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());

        josephus(n, k);
        reader.close();
    }

    public static void josephus(int n, int k) throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder builder = new StringBuilder();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        int index = 0;
        
        while (n > 0) {
            index = (index + k - 1) % n;
            builder.append(numbers[index]).append(", ");

            for (int i = index; i < n - 1; i++) {
                numbers[i] = numbers[i + 1];
            }

            n--;
        }

        builder.append(numbers[0]);
        writer.write("<" + builder.toString() + ">");
        writer.flush();
        writer.close();
    }
}




/* Failed attempt 002
public class Josephus001 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		int n = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		
		
		
		if (k == 1) {
			for (int i = 1; i < n; i++)
				builder.append(i).append(", ");
			builder.append(n);
		} else {
			Node head = new Node(1);
			Node prev = head;
			for (int i = 2; i <= n; i++) {
				Node newNode = new Node(i);
				prev.next = newNode;
				prev = newNode;
			}
			prev.next = head;
			
			Node curr = head;
			while (curr.next != curr) {
				for (int i = 1; i < k - 1; i++)
					curr = curr.next;
				builder.append(curr.next.data).append(", ");
				curr.next = curr.next.next;
				curr = curr.next;
			}
			builder.append(curr.data);
		}
		writer.write("<" + builder.toString() + ">");
		writer.flush();
		writer.close();
		reader.close();
	}
}

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}*/