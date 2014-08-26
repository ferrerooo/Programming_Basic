package zcy.Programming_Basic.others;
import java.util.*;
public class FindKthNumber {

public static void main(String[] args) {
		
		FindKthNumber kk = new FindKthNumber();
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(kk.findkth(arr, 8, 0, arr.length-1));
		
	}
	
	// return the value of the kth number
	private int findkth(int[] arr, int k, int start, int end) {
		if (arr==null || arr.length == 0)
			return -1;
		
		int mid = partition(arr, k, start, end);
		
		if (mid-start == k-1)
			return arr[mid];
		else if (mid-start > k-1)
			return findkth(arr, k, start, mid-1);
		else 
			return findkth(arr, k-mid-1, mid+1, end);
	}
	
	private int partition(int[] arr, int k, int start, int end) {

		Random r = new Random();
		int temp = r.nextInt(end-start+1)+start;
		swap(arr, temp, start);
		int buf = arr[start];
		
		while (start < end) {
			
			while (buf <= arr[end] && start < end) {
				end--;
			}
			if (start == end)
				break;
			else {
				arr[start] = arr[end];
				start++;
			}
			
			while (buf >= arr[start] && start < end) {
				start ++;
			}
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
