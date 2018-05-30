package sort;

import java.util.Stack;

import graph.Node;

public class BST{
	public Node root;
	
	private int getLeaveCount(Node n) {
		if(n == null) return 0;
		return (n.left == null ? 0:n.left.key+1) + (n.right == null ? 0: n.right.key+1);
	}
	private static final boolean RED   = true;
	private static final boolean BLACK = false;
	private boolean isRed(Node x) {
		if(x == null) return false;
		return x.color == RED;
	}
	public void put(int value){
		root = put(root,1,value);
	}
	private Node put(Node h, int key, int value)
	 {
	    if (h == null) return new Node(key, value, RED);
	    int cmp = value - h.value;
	    if      (cmp  < 0) h.left  = put(h.left,  1, value);
	    else h.right = put(h.right, 1, value);
	    h.key++;
	    if (isRed(h.right) && !isRed(h.left))     h = rotateLeft(h);
	    if (isRed(h.left)  && isRed(h.left.left)) h = rotateRight(h);
	    if (isRed(h.left)  && isRed(h.right))     flipColors(h);
	    return h;
	 }
	private Node resetRoot(Node root) {
		int leftLeave = root.left == null? 0 : root.left.key;
		int rightLeave = root.right == null? 0 : root.right.key;
		Node x ;
		if(leftLeave - rightLeave >= 1) {
			
			
			x = root.left;
			
			//change key
			
			
			root.left = x.right;
			x.right = root;
			
			return x;
		}else if(rightLeave - leftLeave >= 2) {
			x = root.right;
			
			//change key
			int a = x.right == null?0 : x.right.key;
			int b = root.left == null?0 : root.left.key;
			root.key = root.key - a - 1;
			x.key = x.key + b + 1;
			
			root.right = x.left;
			x.left = root;
			return x;
		}
		return root;
		
	}
	 private Node rotateLeft(Node h)
	 {
	    assert isRed(h.right);
	    Node x = h.right;
	    
	    //change key
		int a = x.right == null?0 : x.right.key;
		int b = h.left == null?0 : h.left.key;
		h.key = h.key - a - 1;
		x.key = x.key + b + 1;
		
	    h.right = x.left;
	    x.left = h;
	    x.color = h.color;
	    h.color = RED;
	    
	    
	    return x;
	 }
	 private Node rotateRight(Node h)
	 {
	    assert isRed(h.left);
	    Node x = h.left;
	    //change key
	    int a = x.left == null?0 : x.left.key;
		int b = h.right == null?0 : h.right.key;
		h.key = h.key - a - 1;
		x.key = x.key + b + 1;
	    
	    h.left = x.right;
	    x.right = h;
	    x.color = h.color;
	    h.color = RED;
	    return x;
	 }
	 private void flipColors(Node h)
	 {
	    assert !isRed(h);
	    assert isRed(h.left);
	    assert isRed(h.right);
	    h.color = RED;
	    h.left.color = BLACK;
	    h.right.color = BLACK;
	 }


	public int get(int  key)
	{
	   Node x = root;
	   while (x != null)
	   {
	      int cmp = key - x.key;
	      if      (cmp  < 0) x = x.left;
	      else if (cmp  > 0) x = x.right;
	      else if (cmp == 0) return x.value;
	   }
	   return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {10,5,1,2,15};
		BST bst = new BST();
		for(int i = 0; i < a.length; i++) {
			bst.put(a[i]);
		}
		viewTree(bst.root,"top");
		int i = a.length % 2 == 0? a.length/2:(a.length+1)/2; 
		System.out.println(getMedian(bst.root,i));
	}
	
	public static void viewTree(Node node,String posi) {
		System.out.println(posi+node.toString());
		if(node.left != null)
			viewTree(node.left,"left");
		if(node.right != null)
			viewTree(node.right,"right");
		System.out.println("--");
	}
	
	private static int getMedian(Node n,int kth) {
		int leftLeave = n.left == null ?0 : n.left.key;
		int dif = kth - leftLeave;
		if(dif == 1) {
			return n.value;
		}else if(dif > 1) {
			return getMedian(n.right,dif);
		}else {
			return getMedian(n.left,kth);
		}
	}
		public int kthSmallest(Node root, int k) {
	        if (root == null || k <= 0) {
	            return -1;
	        }
	
	        Stack<Node> stack = new Stack<Node>();
	        stack.push(root);
	        Node node = root;
	        while(!stack.isEmpty()) {
	            //Left first
	            while (node != null && node.left != null) { 
	                stack.add(node.left);
	                node = node.left;
	            }
	            //Process left/curr
	            node = stack.pop();
	            k--;
	            if (k == 0) {
	                return node.value;
	            }
	            node = node.right;
	            if (node != null) {
	                stack.push(node);
	            }
	         }
	
	         return -1;
	    }
}
