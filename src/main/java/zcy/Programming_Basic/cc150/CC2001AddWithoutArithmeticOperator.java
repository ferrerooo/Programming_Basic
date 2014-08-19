package zcy.Programming_Basic.cc150;

public class CC2001AddWithoutArithmeticOperator {
	
	public static void main(String[] args) {
		System.out.println(add(-2,-3));
	}
	
	public static int add(int a, int b) {
		
		while (a!=0) {
			
			int temp1 = (a&b)<<1;
			b = a^b;
			a = temp1;
		}
		return b;
	}

}
