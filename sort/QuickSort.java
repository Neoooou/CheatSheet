package sort;

import java.util.Arrays;

public class QuickSort implements InteSort{
	
	public void sort(int[] arr,int len) {
		if(len <= 1) return;
		else {
			int index = len/2;
			int ele = arr[index];
			int[] helper0 = new int[len];//store smaller-value ele
			int[] helper1 = new int[len];//store same-value ele
			int[] helper2 = new int[len];//store bigger-value ele
			int j =0, k = 0, l = 0;
			for(int i = 0; i < len; ++i) {
				int temp = arr[i];
				if(temp < ele) {
					helper0[j] = temp;
					++j;
				}else if(temp == ele){
					helper1[k] = temp;
					++k;
				}else {
					helper2[l] = temp;
					++l;
				}
			}
			sort(helper0,j);
			sort(helper2,l);
			for(int i = 0; i < j; ++i) {
				arr[i] = helper0[i];
			}
			for(int i = 0; i < k; ++i) {
				arr[j+i] = helper1[i];
			}
			for(int i = 0; i < l; ++i) {
				arr[j+k+i] = helper2[i];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,55,22,11,33,66,11};
		new QuickSort().sort(arr,arr.length);
		System.out.println(Arrays.toString(arr));
	}

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		sort(arr,arr.length);
	}
}
