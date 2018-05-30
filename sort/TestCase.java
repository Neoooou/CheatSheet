package sort;

import java.util.Arrays;

import org.junit.Test;

import graph.Node;


public class TestCase {
	private static final int len = 100000;
	static {
		System.out.println("load static resource..");
	}
	@Test
	public void testSort() {
		testSort(new BubbleSort());
		testSort(new InsertSort());
		testSort(new MergeSort());
		testSort(new QuickSort());
	}
	
	public void testSort(InteSort sort) {
		long t1= System.currentTimeMillis();
		int[] arr = new int[len];
		for(int i = 0; i < len; ++i) {
			arr[i] = (int)(len*(Math.random()));
		}
		sort.sort(arr);
//		System.out.println(Arrays.toString(arr));
		long t2 = System.currentTimeMillis();
		long consume = t2 -t1;
		System.out.println(sort.getClass() + ": "+consume);
	}
	public static int getMedian(BST bst) {
		Node head = bst.root;
//		System.out.println(head.right.right.left.value);
		Node fast = head, slow = head;
		while(fast != null && slow != null) {
			if(fast.right == null) {
				return slow.value;
			}else if(fast.right != null && fast.right.right == null) {
				return slow.value;
			}else {
				fast = fast.right.right;
				slow = slow.right;
			}
		}
		return -1;
	}
	public static Node baseconvert(Node root, Node lastNode) {

		if (root == null)

		return lastNode;

		Node current = root;

		if (current.left != null)

		lastNode=baseconvert(current.left, lastNode);

		current.left = lastNode;

		if (lastNode != null)

		lastNode.right = current;

		lastNode = current;

		if (current.right != null)

		lastNode=baseconvert(current.right, lastNode);

		return lastNode;

		}
	
	public static Node convert(Node root) {

		Node lastNode = null;

		lastNode=baseconvert(root, lastNode);

		Node headNode = lastNode;

		while (headNode.left != null)

		headNode = headNode.left;

		return headNode;

		}
	
}
