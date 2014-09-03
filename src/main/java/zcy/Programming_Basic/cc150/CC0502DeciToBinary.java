package zcy.Programming_Basic.cc150;

public class CC0502DeciToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private String deciToBinary(String num) {
		
		String[] arr = num.split("\\.");
		String inte = convertInte(arr[0]);
		String deci = convertDeci(arr[1]);
		if (deci.equals("ERROR"))
			return null;
		else
			return inte+"."+deci;
		
	}
	
	private String convertInte(String s) {
		int num = Integer.valueOf(s);
		StringBuilder sb = new StringBuilder();
		 
		while (num != 0) {
			int val = num%2;
			sb.append(val);
			num = num/2;
		}
		return sb.reverse().toString();
	}
	
	private String convertDeci(String s) {
		
		StringBuilder sb = new StringBuilder();
		double num = Double.valueOf("0."+s);
		int i=0;
		for (;i<20;i++) {
			num = num*2;
			if (num>=1) {
				sb.append(1);
				num = num-1;
			} else {
				sb.append(0);
			}
			if (num == 0)
				break;
		}
		if (i == 20)
			return "ERROR";
		else
			return sb.toString();
	}
}
