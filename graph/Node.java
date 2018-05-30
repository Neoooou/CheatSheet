package graph;


public class Node{
	public int key;
	public int value;
	public Node left,right;
	public boolean color;
	public Node(int value) {
		super();
		this.value = value;
	}
	public Node(int key,int value,boolean color){
		this.key = key;
		this.value = value;
		this.color = color;
	}
	public String toString() {
		return "color " + color + " key " + key + " value " + value;
	}
}
