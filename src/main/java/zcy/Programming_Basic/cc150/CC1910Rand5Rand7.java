package zcy.Programming_Basic.cc150;

public class CC1910Rand5Rand7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int Rand7() {
		
		int num = getRandNum();
		
		while (num > 21)
			num = getRandNum();
		
		return (num-1)/3+1;
		
	}
	
	private int getRandNum() {
		
		return (Rand5()-1)*5 + Rand5();
		
	}
	
	
	private int Rand5() {
		return 1;
	}

}
