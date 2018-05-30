package sort;

import java.util.Arrays;

public class InsertSort implements InteSort{
	public static void main(String[] args) {
		int[] arr = {1,2,55,22,11,33,66,11};
		new InsertSort().sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void sort(int[] arr) {
		int j;
		for(int i = 1; i < arr.length; ++i) {
			int temp = arr[i];
			for( j= i; j > 0 && temp < arr[j-1]; --j) {
					arr[j] = arr[j-1];
			}
			arr[j] = temp;
		}
	}

}
