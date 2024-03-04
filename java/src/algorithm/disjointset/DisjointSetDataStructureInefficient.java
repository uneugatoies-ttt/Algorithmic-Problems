package algorithm.disjointset;

import java.util.Scanner;


/*
public class DisjointSetDataStructureInefficient {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int v = scanner.nextInt();
		int e = scanner.nextInt();
		
		DSDS dsds = new DSDS(v);
		
		int a, b;
		for (int i = 0; i < e; ++i) {
			a = scanner.nextInt() - 1;
			b = scanner.nextInt() - 1;
			dsds.union(a, b);
		}
		
		System.out.print("The set of each element: ");
		for (int i = 0; i < v; ++i)
			System.out.print(dsds.find(i) + " ");
		
		System.out.println();
		
		System.out.print("The \"parent\" table: ");
		for (int i = 0; i < v; ++i)
			System.out.print(dsds.parent[i] + " ");
		
		scanner.close();
	}

}


class DSDS {
	int[] parent;
	int size;
	
	public DSDS(int size) {
		this.size = size;
		parent = new int[size];
		for (int i = 0; i < size; ++i)
			parent[i] = i;
	}
	
	int find(int x) {
		if (parent[x] != x)
			return find(parent[x]);
		return x;
	}
	
	void union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		if (ap < bp)
			parent[bp] = ap;
		else
			parent[ap] = bp;
	}
}
*/
