package zcy.Programming_Basic.cc150;

public class CC2004Count2 {

	public static void main(String[] args) {

		CC2004Count2 c = new CC2004Count2();
		System.out.println(c.howManyTwo(23));

	}
	
	public int howManyTwo(int n) {
		
		int[] result = new int[1];
		recur(n, result);
		return result[0];
	}
	private void recur(int n, int[] result) {
		
		int len = getLen(n);
		if (len == 1) {
			if (n>=2) {
				result[0]++;
			}
			return ;
		}
		
		int num = getTwoAmount(len-1);
		int base = getBase(len);
		int bnum = (n/base);
		
		if (bnum<2)
			result[0] += num;
		else if (bnum>2)
			result[0] += bnum*num;
		else 
			result[0] += 2*num + ((n%base)+1);
		
		recur(n%base, result);
		
	}
	
	private int getBase(int len) {
		return (int)Math.pow(10, len-1);
	}
	
	private int getTwoAmount(int len) {
		if (len == 1)
			return 1;
		int[] arr = new int[len+1];
		arr[1] = 1;
		for (int i=2; i<=len; i++)
			arr[i] = 10*arr[i-1] + (int)Math.pow(10, i-1);
		return arr[len];
	}
	
	private int getLen(int n) {
		if (n==0)
			return 1;
		
		int len = 1;
		while (n/10 != 0) {
			n = n/10;
			len++;
		}
		return len;
	}

}
