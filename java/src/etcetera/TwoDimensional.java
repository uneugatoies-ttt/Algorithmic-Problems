package etcetera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import algorithm.disjointset.DisjointSetDataStructure;

public class TwoDimensional {
	
	public static void main(String[] args) {
		List<List<Integer>> td = new ArrayList<>();
		
		for (int i = 0; i < 16; ++i) {
			td.add(new ArrayList<>());
			for (int j = 0; j < 16; ++j)
				td.get(i).add(j);
		}
		
		for (int i = 0; i < 16; ++i) {
			for (int j = 0; j < 16; ++j)
				System.out.print(td.get(i).get(j) + " ");
			System.out.println();
		}
		
		List<Integer> td2 = new ArrayList<>(16);
		
		System.out.println("noooooooo");
		
		
		DisjointSetDataStructure dsds = new DisjointSetDataStructure();
		
	}
	
	
	
	/*
	public static void main(String[] args) {
		List<List<Integer>> twoDimen = new ArrayList<List<Integer>>();
		
		List<List<Integer>> twoDimen2 = new ArrayList<>();
		
		List<Integer>[] twoDimen3 = new LinkedList[3];
	}*/

}
