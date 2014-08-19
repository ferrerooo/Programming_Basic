package zcy.Programming_Basic.cc150;

public class CC2004Count2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int howManyTwo(int n) {
		
		int[] result = new int[1];
		recur(n, result);
		
	}
	private void recur(int n, int[] result) {
		
		int len = getLen(n);
		if (len == 1) {
			if (len>=2) {
				result[0]++;
			}
			return ;
		}
		
		int num = getTwoAmount(len-1);
		int base = getBase(len);
		(n/base)
		
	}
	
	

}
