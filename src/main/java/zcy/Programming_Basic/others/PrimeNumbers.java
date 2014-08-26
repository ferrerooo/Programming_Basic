package zcy.Programming_Basic.others;
import java.util.*;
public class PrimeNumbers {

	public static void main(String[] args) {
		
		List<Integer> al = PrimeNumbers.getPrimeNumber(100);
		
		for (int i:al)
			System.out.println(i);
	}
	
	private static List<Integer> getPrimeNumber(int n) {
		
		List<Integer> al = new ArrayList<Integer>();
		
		boolean[] arr = new boolean[n+1];
		
		if (n<2)
			return al;
		if (n == 2) {
			al.add(2);
			return al;
		}
		if (n==3) {
			al.add(2);
			al.add(3);
			return al;
		}
		
		for (int i=2; i<=n/2; i++) {
			
			if (arr[i] == false) {
				for (int j=2; j*i <=n; j++) {
					arr[j*i] = true;
				}
			}
		}
		
		for (int i=2; i<=n;i++) {
			if (arr[i] == false)
				al.add(i);
		}
		
		return al;
	}

}
