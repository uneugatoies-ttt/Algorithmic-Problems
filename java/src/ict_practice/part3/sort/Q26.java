package ict_practice.part3.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q26 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < n; ++i)
			q.add(Integer.parseInt(reader.readLine()));
		int mn1, mn2, temp;
		int result = 0;
		while (q.size() > 1) {
			mn1 = q.poll(); mn2 = q.poll();
			temp = mn1 + mn2;
			result += temp;
			q.add(temp);
		}
		writer.write(String.valueOf(result) + "\n");
		writer.flush();
	}
}













// failed attempt 2
	/*
	public class Q26 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		List<Elem> list = new LinkedList<>();
		list.add(new Elem(Integer.parseInt(reader.readLine()), 0, -1));
		int ent;
		for (int i = 1; i < n; ++i) {
			ent = Integer.parseInt(reader.readLine());
			list.add(new Elem(ent, Math.abs(list.get(i-1).self - ent), list.get(i-1).self));
		}
		
		Comparator<Elem> c = (e1, e2) -> Integer.compare(e1.ld, e2.ld);
		while (list.size() > 1) {
			Collections.sort(list, c);
			list.set(1, new Elem(list.get(1).self + list.get(1).left, ))
		}
		
		
		writer.write(String.valueOf(list.get(0)));
		writer.write('\n');
		writer.flush();
		
	}
	
	private static class Elem {
		int self; int ld; int left;
		public Elem(int self, int ld, int left) {
			this.self = self;
			this.ld = ld;
			this.left = left;
		}
	}

}
*/


// failed attempt 1
/*
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(reader.readLine());
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; ++i)
			list.add(Integer.parseInt(reader.readLine()));
		
		int ind, diff, temp, sum;
		while (list.size() > 1) {
			Collections.sort(list);
			ind = 0;
			diff = list.get(ind + 1) - list.get(ind);
			for (int i = 1; i < list.size() - 1; ++i) {
				temp = list.get(i + 1) - list.get(i);
				if (temp < diff) {
					ind = i;
					diff = temp;
				}
			}
			sum = list.get(ind) + list.get(ind + 1);
			list.set(ind, sum);
			list.remove(ind + 1);
		}
		writer.write(String.valueOf(list.get(0)));
		writer.write('\n');
		writer.flush();
		
	}
*/
