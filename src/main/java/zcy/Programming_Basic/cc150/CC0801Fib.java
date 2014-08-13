package zcy.Programming_Basic.cc150;

public class CC0801Fib {
	
	// fib0=1, fib1=1, fib2=2, fib3=3, fib4=5, fib5=8, fib6=13...
	public int getFib(int n) {
		
		if (n==0 || n==1)
			return 1;
		
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		
		for (int i=2; i<=n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[n];
	}

}
