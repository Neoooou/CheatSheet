package tree;

import java.util.HashMap;

public class FirstOcu {
	public static void main(String[] args) {
		String str = "accommodation";
		HashMap<Character,Integer> times = new HashMap<Character,Integer>();
		for(int i = 0; i < str.length(); ++i) {
			char chr = str.charAt(i);
			if(!times.containsKey(chr)) {
				System.out.print(chr);
				times.put(chr, 1);
			}
		}
		/**
		 * time complexity analysis: two declaration statements take O(1) time.The loop executes n time.Inside loop
		 * The API string.charAt() takes O(1) complexity and searching and insert operations on hash map also executes
		 * an constant time.So the overall complexity of the algorithm is O(n)! 
		 */
	}
}
