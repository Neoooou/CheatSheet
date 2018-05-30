package sort;

import java.util.Arrays;

public class SelectSort implements InteSort{
	
	public static void main(String[] args) {
		int[] arr = {1,2,55,22,11,33,66,11};
		SelectSort ins = new SelectSort();
		ins.sort(arr);
		System.out.println(Arrays.toString(arr));
		ins.swapValue(arr[0], arr[1]);
		System.out.println("a:"+arr[0]);
		System.out.println("b:"+arr[1]);
	}

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		if(arr == null || arr.length ==0) return;
		final int len = arr.length;
		for(int i = 0; i < len ; ++i) {
			int minPtr = i;
			for(int j = i+1; j < len; ++j) {
				if(arr[j] < arr[minPtr]) minPtr = j;
			}
			/*
			int temp = arr[i];
			arr[i] = arr[minPtr];
			arr[minPtr] = temp;
			*/
			arr[i] = arr[minPtr] ^ arr[i];
			arr[minPtr] = arr[minPtr] ^ arr[i];
			arr[i] = arr[minPtr] ^ arr[i];
		}
	}
	
	public void swapValue(int a, int b) {
		
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("inner:a:"+a);
		System.out.println("inner:b:"+b);
	}

}
