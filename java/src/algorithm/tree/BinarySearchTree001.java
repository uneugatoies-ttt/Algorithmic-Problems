package algorithm.tree;


public class BinarySearchTree001 {
	

	
	private static class BST {
		private static class Node {
			int value;
			
			Node left;
			Node right;
			
			public Node(int value) {
				this.value = value;
				this.left = null;
				this.right = null;
			}
		}
		
		Node root;
		
		public void add(int value) {
			root = addRecursive(root, value);
		}
		
		private Node addRecursive(Node curr, int value) {
			if (curr == null)
				return new Node(value);
			
			if (value < curr.value)
				curr.left = addRecursive(curr.left, value);
			else if (value > curr.value)
				curr.right = addRecursive(curr.right, value);
			
			return curr;
		}
		
		public boolean containsNode(int value) {
			return containsNodeRecursive(root, value);
		}
		
		private boolean containsNodeRecursive(Node curr, int value) {
			if (curr == null)
				return false;
			if (value == curr.value)
				return true;
			
			return (value < curr.value)
				? containsNodeRecursive(curr.left, value)
				: containsNodeRecursive(curr.right, value);
		}
		
		public void delete(int value) {
			root = deleteRecursive(root, value);
		}
		
		private Node deleteRecursive(Node curr, int value) {
			if (curr == null)
				return null;
			
			if (value == curr.value) {
				if (curr.left == null && curr.right == null) {
					return null;
				} else if (curr.left == null || curr.right == null) {
					if (curr.left == null)
						return curr.right;
					if (curr.right == null)
						return curr.left;
				} else {
					int smallest = findSmallestValue(curr.right);
					curr.value = smallest;
					curr.right = deleteRecursive(curr.right, smallest);
					return curr;
				}
			}
			if (value < curr.value) {
				curr.left = deleteRecursive(curr.left, value);
				return curr;
			} else {
				curr.right = deleteRecursive(curr.right, value);
				return curr;
			}
		}
		
		private int findSmallestValue(Node root) {
			return root.left == null ? root.value : findSmallestValue(root.left);
		}
	
	}
	
	
}


















// Version 1.
/*
public class BinarySearchTree001 {
	
	public static void main(String[] args) {
		BinarySearchTreeImpl02.size = 5;
		BinarySearchTreeImpl02.btree = new BinarySearchTreeImpl02.Node[BinarySearchTreeImpl02.size];
		BinarySearchTreeImpl02.btree[0] = new BinarySearchTreeImpl02.Node(0, 938);
		BinarySearchTreeImpl02.btree[1] = new BinarySearchTreeImpl02.Node(1, 8375332);
		BinarySearchTreeImpl02.btree[2] = new BinarySearchTreeImpl02.Node(2, 115900);
		BinarySearchTreeImpl02.btree[3] = new BinarySearchTreeImpl02.Node(3, 6132);
		BinarySearchTreeImpl02.btree[4] = new BinarySearchTreeImpl02.Node(4, 37705199);
		
		BinarySearchTreeImpl02.inorderWalk(0);
		
		System.out.println("\n============\n");
		
		BinarySearchTreeImpl01 bst = new BinarySearchTreeImpl01();
		bst.insert(0);
	    bst.insert(1);
	    bst.insert(2);
	    bst.insert(3);
	    bst.insert(4);

	    bst.inorderWalk();
	}
	
}

class BinarySearchTreeImpl01 {
	
	private static class Node {
		private int val;
		private Node left;
		private Node right;
		
		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node root;
	
	public BinarySearchTreeImpl01() {
		root = null;
	}
	
	public void insert(int val) {
		root = insertRec(root, val);
	}
	
	private Node insertRec(Node node, int val) {
		if (node == null)
			return new Node(val);
		
		if (val < node.val) {
			node.left = insertRec(node.left, val);
		} else if (val > node.val) {
			node.right = insertRec(node.right, val);
		}
		
		return node;
	}
	
	public void inorderWalk() {
		inorderWalkRec(root);
	}
	
	private void inorderWalkRec(Node node) {
		if (node == null) return;
		
		inorderWalkRec(node.left);
		System.out.println(node.val);
		inorderWalkRec(node.right);
	}
	

}

class BinarySearchTreeImpl02 {
	
	public static class Node {
		private int ind;
		private int val;
		public Node(int ind, int val) {
			this.ind = ind;
			this.val = val;
		}
		public int getInd() {
			return ind;
		}
		public void setInd(int ind) {
			this.ind = ind;
		}
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
	}
	
	public static int size;
	public static Node[] btree;
	

	public static void inorderWalk(int x) {
		if (x >= size || x < 0) return;
		inorderWalk(2*x + 1);
		System.out.println(btree[x].getInd());
		inorderWalk(2*x + 2);
	}
	
}*/
