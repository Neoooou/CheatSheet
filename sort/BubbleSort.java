package sort;

import java.util.Arrays;

public class BubbleSort implements InteSort{
	public static void main(String[] args) {
		int len = 10;
		int[] arr = new int[len];
		for(int i = 0; i < len; ++i) {
			arr[i] = (int)(len*(Math.random()));
		}
		System.out.println(Arrays.toString(arr));
		new BubbleSort().sort(arr);
		System.out.println(Arrays.toString(arr));
		
		int a = 111;
		int b = 92;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a:"+a);
		System.out.println("b:"+b);
	}
	
	public void sort(int[] arr) {
		for(int i = 0 ;i < arr.length; i++) {
			for(int j = 0; j < arr.length-i-1; ++j) {
				if(arr[j] > arr[j+1]) {
					arr[j] = arr[j] ^ arr[j+1];
					arr[j+1] = arr[j] ^ arr[j+1];
					arr[j] = arr[j] ^ arr[j+1];
				}
			}
		}
	}

}
