package tree;

import java.util.LinkedList;
import java.util.Queue;

import graph.Node;

public class TreeTraversal {
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
		
		TreeTraversal tt = new TreeTraversal(); 
		
		tt.postOrder(root);
		System.out.println("post order:");
		
		tt.preOrder(root);
		System.out.println("pre order:");
		
		tt.inOrder(root);
		System.out.println("in order:");
		tt.levelOrder(root);
		System.out.println("level order:");
	}
	/**
	 * left-right-root
	 * @param node
	 */
	public void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value+" ");
	}
	/**
	 * left-root-right
	 * @param node
	 */
	public void inOrder(Node node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.value+" ");
		inOrder(node.right);
	}
	/**
	 * root-left-right
	 * @param node
	 */
	public void preOrder(Node node) {
		if(node==null) return;
		System.out.print(node.value+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 * root-left-right (level by level, no recursion)
	 * @param node
	 */
	public void levelOrder(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		while(node != null) {
			System.out.print(node.value + " ");
			if(node.left != null) {
				q.offer(node.left);
			}
			if (node.right != null) {
				q.offer(node.right);
			}
			node = q.poll();
		}
	}
}
