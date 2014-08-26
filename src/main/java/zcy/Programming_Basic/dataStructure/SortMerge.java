package zcy.Programming_Basic.dataStructure;

import java.util.Random;

public class SortMerge {

	public static void main(String[] args) {

		int[] arr = new int[10];
		Random r = new Random();
		for (int i=0;i<arr.length;i++) {
			arr[i] = r.nextInt(100);
		}
		
		SortMerge s = new SortMerge();
		s.ms(arr, 0, arr.length-1, new int[arr.length]);
		
		for (int i:arr)
			System.out.println(i);

	}
	
	private void ms (int[] arr, int start, int end, int[] buf) {
		
		if (start>=end)
			return;
		
		int mid = (start+end)/2;
		
		ms(arr, start, mid, buf);
		ms(arr, mid+1, end, buf);
		
		int s1 = start;
		int e1 = mid;
		int s2 = mid+1;
		int e2 = end;
		int p = start;
		
		while (s1<=e1 && s2<=e2) {
			
			if (arr[s1]<arr[s2]) {
				buf[p] = arr[s1];
				p++;
				s1++;
			} else {
				buf[p] = arr[s2];
				p++;
				s2++;
			}
			
		}
		
		while (s1<=e1) {
			buf[p] = arr[s1];
			p++;
			s1++;
		}
		while (s2<=e2) {
			buf[p] = arr[s2];
			p++;
			s2++;
		}
		
		for (int i=start; i<=end; i++)
			arr[i] = buf[i];
		
//		int[] temp = arr;
//		arr = buf;
//		buf = temp;
		
	}

}
