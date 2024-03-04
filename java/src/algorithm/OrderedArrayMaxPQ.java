package algorithm;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int n;
	
	public OrderedArrayMaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity];
		n = 0;
	}
	
	public boolean isEmpty()	{ return n == 0; }
	public int size()			{ return n; }
	public Key delMax() 		{ return pq[--n]; }
	
	public void insert(Key key) {
		int i = n - 1;
		while (i >= 0 && less(key, pq[i])) {
			pq[i + 1] = pq[i];
			i--;
		}
		pq[i + 1] = key;
		n++;
	}
	
	private boolean less(Key v, Key w) {
		return v.compareTo(w) < 0;
	}
}
