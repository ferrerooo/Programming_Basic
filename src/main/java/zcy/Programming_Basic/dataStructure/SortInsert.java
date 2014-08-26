package zcy.Programming_Basic.dataStructure;

import java.util.Random;

public class SortInsert {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		Random r = new Random();
		for (int i=0;i<arr.length;i++) {
			arr[i] = r.nextInt(100);
		}
		
		SortInsert s = new SortInsert();
		s.is(arr);
		
		for (int i:arr)
			System.out.println(i);

	}
	
	private void is(int[] arr) {
		
		if(arr == null|| arr.length<2)
			return;
		
		for (int i=1; i<arr.length; i++) {
			
			int buf = arr[i];
			
			int j=i-1;
			for (; j>=0;j--) {
				
				if (buf>=arr[j]) {
					arr[j+1] = buf;
					break;
				} else {
					arr[j+1] = arr[j];
				}
				
			}
			
			if (j == -1)
				arr[0] = buf;
		}
		
	}

}
