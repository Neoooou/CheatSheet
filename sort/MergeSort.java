package sort;

import java.util.Arrays;

public class MergeSort implements InteSort{
	public static void main(String[] args) {
		int[] arr = {1,30,4,6,2,3,100,55,33};
		new MergeSort().sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public void sort(int[] arr) {
		int len = arr.length;
		if(len<=1) return;
		else {
			int[] left = Arrays.copyOfRange(arr, 0, len/2);
			int[] right = Arrays.copyOfRange(arr, len/2,len);
			sort(left);
			sort(right);
			merge(left,right,arr);
		}
	}

	private void merge(int[] left, int[] right, int[] arr) {
		// TODO Auto-generated method stub
		int i = 0, j = 0 , k = 0;
		while(i< left.length && j < right.length) {
			if(left[i] >= right[j]) {
				arr[k] = right[j];
				++j;
			}else {
				arr[k] = left[i];
				++i;
			}
			++k;
		}
		while(i < left.length) {
			arr[k] = left[i];
			++i;
			++k;
		}
		while(j < right.length) {
			arr[k] = right[j];
			++j;
			++k;
		}
	}

}
