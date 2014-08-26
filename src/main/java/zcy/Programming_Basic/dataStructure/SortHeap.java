package zcy.Programming_Basic.dataStructure;

import java.util.*;

public class SortHeap {

	public static void main(String[] args) {

		int[] arr = new int[10];
		Random r = new Random();
		for (int i=0;i<arr.length;i++) {
			arr[i] = r.nextInt(100);
		}
		
		SortHeap s = new SortHeap();
		s.hs(arr);
		
		for (int i:arr)
			System.out.println(i);

	}
	
	private void hs(int[] arr) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i:arr)
			pq.offer(i);
		
		for (int i=0;i<arr.length;i++) {
			arr[i] = pq.poll();
		}
		
	}

}
