package tree;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class Anagrams {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		while(!("EXIT".equals(str1.toUpperCase()) || "EXIT".equals(str2.toUpperCase()))) {
			judgeAnagrams(str1,str2);
			str1 = sc.nextLine();
			str2 = sc.nextLine();
		}
	}

	private static void judgeAnagrams(String str1, String str2) {
		// TODO Auto-generated method stub
		Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
		if(str1.length() != str2.length()) {
			System.out.println("not anagrams");
			return;
		}
		char[] chrs = str1.toCharArray();
		for(char c: chrs) {
			if(ht.containsKey(c)) {
				ht.put(c, ht.get(c) + 1);
			}else {
				ht.put(c, 1);
			}
		}
		System.out.println(ht);
		char[] chrs2 = str2.toCharArray();
		System.out.println(Arrays.toString(chrs2));
		for(int i = 0; i < chrs2.length; ++i){
			char c = chrs2[i];
			if(ht.containsKey(c)) {
				int freq = ht.get(c);
				if(freq > 1) {
					ht.put(c, freq-1);
				}else {
					ht.remove(c);
				}
			}else {
				System.out.println("not anagrams");
				return;
			}
		}
		System.out.println("anagrams");
	}

}
