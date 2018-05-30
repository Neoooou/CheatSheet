package graph;

public class Q2c {
	public void printLeaves(Node root) {
		if(root == null) return;
		if(root.left == null && root.right == null) System.out.println(root.value);
		if(root.left != null) printLeaves(root.left);
		if(root.right != null) printLeaves(root.right);
	}
	public void printAntiClockwise(Node root) {
		Node temp = root;
		while(temp != null && !(temp.left == null && temp.right == null)) {
			System.out.println(temp.value);
			temp = temp.left;
		}
		printLeaves(root);
		printRight(root.right);	
	}
	
	public void printRight(Node root) {
		if(root == null) return;
		// if it is leave, no printing
		if(root.right == null && root.left == null) return;
		if(root.right == null) {
			System.out.println(root.value);
		}else {
			printRight(root.right);
			System.out.println(root.value);
		}
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);

		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(5);
		Node n5 = new Node(6);
		Node n6 = new Node(7);
		Node n7 = new Node(8);
		Node n8 = new Node(9);
		Node n0 = new Node(10);
		/*
		root.left = n1;
		root.right = n4;
		n1.right = n2;
		n2.left = n3;
		n4.right = n0;
		n4.left = n5;
		n5.right = n8;
		n5.left = n6;
		n6.right = n7;*/
		root.right = n2;
		n2.right = n5;
		root.left = n1;
		n1.left = n3;
		n1.right = n7;
		n7.left = n6;
		new Q2c().printAntiClockwise(root);
	}
}
