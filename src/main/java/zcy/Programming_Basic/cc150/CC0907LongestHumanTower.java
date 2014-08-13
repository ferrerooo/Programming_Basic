package zcy.Programming_Basic.cc150;

import java.util.*;

public class CC0907LongestHumanTower {
	
	public int LongestTower(Human[] arr) {
		
		if (arr==null ||arr.length==0)
			return 0;
		if (arr.length==1)
			return 1;
				
		Arrays.sort(arr, new Comparator<Human>() {
			@Override
			public int compare(Human h1, Human h2) {
				return h1.ht - h2.ht;
			}
		});
		
		int[] dp = new int[arr.length+1];
		
		dp[0] = 0;
		for (int i=1; i<=arr.length;i++)
			dp[i] = 1;
		
		for (int i=2; i<=arr.length; i++) {
			for (int j=1; j<i; j++) {
				if (arr[j-1].wt<=arr[i-1].wt)
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		return dp[arr.length];
	}
	
	
}
class Human {
	int ht;
	int wt;
	public Human(int _ht, int _wt) {
		ht = _ht;
		wt = _wt;
	}
}
