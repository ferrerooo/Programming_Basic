package zcy.Programming_Basic.cc150;

import java.util.Arrays;

public class CC0503NextBigNextSmallNumber {
	
	public int findNextBig(int number) {
		int[] arr = convert(number);
		
		int i=30;
		for (; i>=0; i--) {
			if (arr[i]<arr[i+1] ) {
				break;
			}
		}
		if (i==-1)
			return -1;
		
		Arrays.sort(arr, i+1, 32);
		for (int j=i+1; j<32;j++){
			if (arr[j]==1) {
				arr[j] = 0;
				arr[i] = 1;
				break;
			}
		}
		
		return convertBack(arr);
	}
	
	public int findNextSmall(int number) {
		
		int[] arr = convert(number);
		int i = 30;
		for (; i>=0;i--) {
			if (arr[i]>arr[i+1])
				break;
		}
		if (i==-1) {
			return -1;
		}
		
		decendingOrder(arr, i+1, 32);
		
		for (int j=i+1; j<32;j++) {
			if (arr[j]==0) {
				arr[j]=1;
				arr[i]=0;
				break;
			}
		}
		return convertBack(arr);
	}
	
	private void decendingOrder(int[] arr, int start, int end) {
		int oneNum = 0;
		for (int i=start; i<end; i++) {
			if (arr[i]==1)
				oneNum++;
		}
		int i=start;
		for (; i<start+oneNum; i++)
			arr[i] = 1;
		
		for (; i<32; i++)
			arr[i] = 0;
		
	}
	
	private int[] convert(int num) {
		
		int[] arr = new int[32];
		for (int i=0;i<32;i++) {
			arr[i] = get(num, 31-i);
		}
		return arr;
	}
	private int get(int num, int position) {
		int temp = 1<<position;
		if ( (num & temp) == 0 )
			return 0;
		else
			return 1;
	}
	private int convertBack(int[] arr) {
		int num = 0;
		for (int i=0;i<32;i++) {
			if (arr[i]==1) {
				int temp = 1<<(31-i);
				num = num | temp;
			}
		}
		return num;
	}

}
