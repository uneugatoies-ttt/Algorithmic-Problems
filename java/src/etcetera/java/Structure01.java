package etcetera.java;

import java.util.LinkedList;
import java.util.List;

public class Structure01 {
	
	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<>();
		
		for (int i = 0; i < 20; ++i) {
			list.add(i);
		}
		
		System.out.println(list.subList(3, 8));
		
		System.out.println(list);
		
	}

}
