package zcy.Programming_Basic.cc150;

public class CC0905FindStringInStrArr {
	
	public int findStr(String[] arr, String target) {
		
		if (arr == null || arr.length == 0)
			return -1;
		
		return recur(arr, target, 0, arr.length-1);
		
	}
	private int recur(String[] arr, String target, int start, int end) {
		if (start>end)
			return -1;
		if (start == end) {
			if (arr[start].equals(target))
				return start;
			else
				return -1;
		}
		
		int mid = (start+end)/2;
		if (arr[mid].equals(target))
			return mid;
		if (arr[mid].equals("")) {
			int nextIndex = getNextStrIndex(arr, mid+1, end);
			if (nextIndex == -1)
				return recur(arr, target, start, mid-1);
			else {
				int res = arr[nextIndex].compareTo(target);
				if (res < 0)
					return recur(arr, target, nextIndex+1, end);
				else if (res == 0)
					return nextIndex;
				else
					return recur(arr, target, start, mid-1);
			}
				
		} else {
			
			int res = arr[mid].compareTo(target);
			if (res <0)
				return recur(arr, target, mid+1, end);
			else
				return recur(arr, target, start, mid-1);
		}
	}
	
	private int getNextStrIndex(String[] arr, int start, int end) {
		for (int i=start; i<=end; i++)
			if (arr[i].equals("") == false)
				return i;
		
		return -1;
	}

}
