package zcy.Programming_Basic.cc150;

public class CC0501BitReplacement {

	public static void main(String[] args) {
		

	}
	
	public int repplace(int N, int M, int i, int j) {
		
		int filter = ~0;
		filter = filter - ( (1<<(j+1) )-1);
		filter = filter + ( (1<<i)-1 )  ;
		N = N & filter;
		M = M << 2;
		return N | M;
	}

}
