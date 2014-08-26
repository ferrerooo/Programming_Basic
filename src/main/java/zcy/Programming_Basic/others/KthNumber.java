package zcy.Programming_Basic.others;
import java.util.*;
public class KthNumber {

	public static void main(String[] args) {
		
		int[] arr = {2,1,4,3,5,6,8,10,9,7};
		
		KthNumber km = new KthNumber();
		
		System.out.println ( km.getkth(arr, 5, 0, arr.length-1) );
		System.out.println ( km.getK(arr, 5) );
	}
	
	//----------------------- Implementation 1 >>>> start -----------------------------------
	private int getkth(int[] arr, int k, int start, int end) {
		
		if (start == end)
			return arr[start];
		
		int index = partition(arr, start, end);
		
		if (k-1 == index-start)
			return arr[index];
		else if (k-1 < index-start)
			return getkth(arr, k, start, index-1);
		else
			return getkth(arr, k-index-1+start, index+1, end);
	}
	
	
	
	//----------------------- Implementation 1 <<<<< END-----------------------------------

	//----------------------- Implementation 2 >>>> start -----------------------------------
	
	private int getK(int[] arr, int k) {
		
		int index = partition(arr, 0, arr.length-1);
		
		if (k-1 == index) {
			return arr[index];
		} else if (k-1<index) {
			int[] newarr = new int[index];
			for (int i=0;i<newarr.length; i++) {
				newarr[i] = arr[i];
			}
			return getK(newarr, k);
		} else {
			int newk = k-index-1;
			int[] newarr = new int[arr.length-index-1];
			for (int i=0;i<newarr.length;i++)
				newarr[i] = arr[index+1+i];
			return getK(newarr, newk);
		}
	}
	
	
	//----------------------- Implementation 2 <<<<< END-----------------------------------
	
	// ------------- utility --------------------
	
	private int partition(int[] arr, int start, int end) {
		
		Random r = new Random();
		int randIndex = r.nextInt(end-start+1)+start;
		swap(arr, randIndex, start);
		
		int buf = arr[start];
		int p1 = start;
		int p2 = end;
		
		while (p1<p2) {
			
			while (buf <= arr[p2] && p1<p2)
				p2--;
			if (p1 == p2) {
				break;
			} else {
				arr[p1] = arr[p2];
				p1++;
			}
			
			while (buf>=arr[p1] && p1<p2) 
				p1++;
			if (p1 == p2) {
				break;
			} else {
				arr[p2] = arr[p1];
				p2--;
			}
			
		}
		arr[p1] = buf;
		return p1;
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
