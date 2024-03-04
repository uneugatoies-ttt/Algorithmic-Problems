package etcetera;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinearStructures {
	
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new ArrayDeque<>();
		
		Stack<Integer> s1 = new Stack<>();
		
		
		
		
	}
	
	

}


class MyIterableClass<T> implements Iterable<T> {
	private T[] elements;
	
	public MyIterableClass(T[] elements) {
		this.elements = elements;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T> {
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			return index < elements.length;
		}
		
		@Override
		public T next() {
			return elements[index++];
		}
	}
}
