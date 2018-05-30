package tree;

import java.util.HashMap;

public class Path {
	public static void main(String[] args) {
		HashMap bt = new HashMap();
		bt.put("a", "b");
		bt.put("b","c");
		bt.put("c","d");
		Object o = bt.get("a");
		while( o != null) {
			System.out.println(o);
			o = bt.get(o);
		}
	}

}
