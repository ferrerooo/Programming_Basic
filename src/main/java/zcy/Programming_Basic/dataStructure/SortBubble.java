package zcy.Programming_Basic.dataStructure;

import java.util.*;

public class SortBubble {

	public static void main(String[] args) {

		int[] arr = new int[10];
		Random r = new Random();
		for (int i=0;i<arr.length;i++) {
			arr[i] = r.nextInt(100);
		}
		
		SortBubble s = new SortBubble();
		s.bs(arr);
		
		for (int i:arr)
			System.out.println(i);
	}
	
	private void bs(int[] arr) {
		
		if (arr == null || arr.length <2)
			return;
		
		int len = arr.length;
		
		for (int i=0;i<len;i++) {
			
			for (int j=0;j<len-1-i;j++) {
				
				if (arr[j]<=arr[j+1])
					continue;
				else {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				
			}
			
		}
		
	}

}
