package zcy.Programming_Basic.dataStructure;

import java.util.Random;

public class SortSelect {

	public static void main(String[] args) {

		int[] arr = new int[10];
		Random r = new Random();
		for (int i=0;i<arr.length;i++) {
			arr[i] = r.nextInt(100);
		}
		
		SortSelect s = new SortSelect();
		s.ss(arr);
		
		for (int i:arr)
			System.out.println(i);

	}
	
	private void ss(int[] arr) {
		
		if (arr == null  || arr.length<2)
			return;
		
		int len = arr.length;
		
		for (int i=0;i<len-1;i++) {
			
			int minIndex = i;
			int minVal = arr[i];
			
			for (int j=i+1; j<len; j++) {
				if (arr[j]<minVal) {
					minVal = arr[j];
					minIndex = j;
				}
			}
			
			swap(arr, i, minIndex);
		}
		
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
