package tree;

import java.util.Hashtable;

import graph.Node;

public class Symmetrical {
	public static void main(String[] args) {
		Node root = new Node(1);

		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(2);
		Node n5 = new Node(6);
		Node n6 = new Node(7);
		Node n7 = new Node(8);
		Node n8 = new Node(9);
		Node n0 = new Node(10);
		Hashtable ht = new Hashtable();
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
		root.right = n1;
		root.left = n4;
		n1.left = n2;
		n1.right = n3;
		n4.left = n3;
		n4.right = n0;
		Symmetrical s = new Symmetrical();
		s.isSym(root);
	}
	public void isSym(Node root) {
		System.out.println("is sysmmetrical: " + isSymSubTree(root.left,root.right));
	}

	private boolean isSymSubTree(Node left, Node right) {
		// TODO Auto-generated method stub
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		if(left.left == null && left.right == null 
				&& right.right == null && right.left == null) return left.value == right.value;	
		boolean f = left.value == right.value;
		return f && isSymSubTree(left.left, right.right) && isSymSubTree(left.right, right.left);
	}

}
