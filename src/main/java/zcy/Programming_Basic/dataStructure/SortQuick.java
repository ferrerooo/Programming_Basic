package zcy.Programming_Basic.dataStructure;
import java.util.*;
public class SortQuick {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		Random r = new Random();
		for (int i=0;i<arr.length;i++) {
			arr[i] = r.nextInt(100);
		}
		
		SortQuick s = new SortQuick();
		s.qs(arr, 0, arr.length-1);
		
		for (int i:arr)
			System.out.println(i);
	}
	
	private void qs (int[] arr, int start, int end) {
		
		if (start>=end)
			return;
		
		int index = partition(arr, start, end);
		qs(arr, start, index-1);
		qs(arr, index+1, end);
		
	}
	
	private int partition(int[] arr, int start, int end) {
		
		Random r = new Random();
		int ranNum = r.nextInt(end-start+1)+start;
		swap(arr, start, ranNum);
		
		int buf = arr[start];
		
		while (start < end) {
			
			while (buf <= arr[end] && start < end)
				end -- ;
			if (start == end)
				break;
			else {
				arr[start] = arr[end];
				start++;
			}
			
			while (buf >= arr[start] && start < end)
				start ++;
			if (start == end)
				break;
			else {
				arr[end] = arr[start];
				end--;
			}			
		}
		arr[start] = buf;
		
		return start;
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
