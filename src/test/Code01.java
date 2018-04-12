package test;

import java.util.Arrays;

public class Code01 {
	public static void quickSort(int[] a, int low, int high) {
		if(low >= high)
			return;
		int i = low + 1;
		int j = high;
		while(true) {
			while(a[i] < a[low]) i++;
			while(a[j] > a[low]) j--;
			if(i >= j)
				break;
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;j--;
		}
		int temp = a[j];
		a[j] = a[low];
		a[low] = temp;
		
		quickSort(a, low, j - 1);
		quickSort(a, j + 1, high);
	}
	public static void main(String[] args) {
		int[] a = {5,3,2,1,4,65,1,3};
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}
