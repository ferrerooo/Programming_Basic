package zcy.Programming_Basic.cc150;

public class CC1904CompareTwoNums {

	public static void main(String[] args) {
		
		CC1904CompareTwoNums c = new CC1904CompareTwoNums();
		
		System.out.println(c.getMax(3, 9));
		
		System.out.println( (-10)>>31 );
		System.out.println( (-5)>>31 );
	}

	int getMax(int a, int b) {
		int c = a - b;
		int k = (c >> 31) & 0x1;
		int max = a - k * c;
		return max;
	}

}
