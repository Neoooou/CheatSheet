package sort;

import java.util.Arrays;

public class MyMergeSort1 {
	public static void main(String[] args) {
		int [] a = {1,3,4,2,5,7,3,6,2};
		for(int e:a) {
			System.out.println(e);
		}
		a = mergeSort(a);
		int i = 1;
		i ^= 2;
		System.out.println(i);
	//	System.out.println(Arrays.toString(a));
	}
	public static int[] mergeSort(int[] a) {
		int n = a.length;
		if(n <= 1) {
			return a;
		}else {
			int middle = n / 2;
			int[] b = new int[middle];
			for(int i = 0; i < middle;i++) {
				b[i] = a[i];
			}
			mergeSort(b);
			int[] c = new int[n-middle];
			int j = 0;
			for(int i = middle; i < n;i++) {
				c[j] = a[i];
				++j;
			}
			mergeSort(c);
			merge(a,b,c);
			return a;
		}
	}
	
	public static void merge(int[] a, int[] b, int[] c) {
		int i = 0,j = 0, k = 0;
		while(i < b.length && j < c.length) {
			if(b[i] <= c[j]) {
				a[k] = b[i];
				++i;
			}else {
				a[k] = c[j];
				++j;
			}
			++k;
		}
		while(i < b.length) {
			a[k] = b[i];
			++k;
			++i;
		}
		while(j < c.length) {
			a[k] = c[j];
			++k;
			++j;
		}
	}

}
