package tree;

import graph.Node;

public class PrintTree {
	
	public final static String horz = "=";
	public final static String vert = "⥯";
	public final static String upLeft = "⥥";
	public final static String lowLeft = "⥣";
	public final static String space = "*";
	public final static String spaces = "**";
	public static void serialiseRecursive(Node t) {		
		if(t != null) {
			System.out.print(t.value+",");
			serialiseRecursive(t.left);
			serialiseRecursive(t.right);
		}else {
			System.out.print("$,");
		}
	}
	
	public static void printTheTree(Node node) {
		printTheTree(node,"");
	}
	
	public static void printTheTree(Node node,String data) {
		if(node == null) return;
		String rightData = spaces+upLeft+horz;
		String leftData = spaces+lowLeft+horz;
		String temp = "";
		if(data.indexOf(upLeft) != -1) {//right node
			String str = data.substring(0, data.indexOf(upLeft));
			rightData = str+spaces+upLeft+horz;
			leftData = str+vert+space+lowLeft+horz;
		}else if(data.indexOf(lowLeft) != -1){//left node
			String str = data.substring(0, data.indexOf(lowLeft));
			leftData = str+spaces+lowLeft+horz;
			rightData = str+vert+space+upLeft+horz;
		}
		printTheTree(node.right,rightData);
		if(data == "") {
			System.out.println("=="+node.value);
		}else {
			System.out.println(data+node.value);
		}
		printTheTree(node.left, leftData);
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
		n1.right = root;
		root.right = n4;
		root.left = n6;
		n6.left = n0;
		n1.left = n3;
//		serialiseRecursive(n1);
		printTheTree(n1);*/
		root.right = n2;
		n2.right = n5;
		root.left = n1;
		n1.left = n3;
		n1.right = n7;
		n7.left = n6;
		printTheTree(root);
	}
}
