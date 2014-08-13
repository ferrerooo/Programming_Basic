package zcy.Programming_Basic.others;

public class LSubStrInOrder {
	
	public int getLSubStrInOrder(String s) {
		
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		
		int[] dp = new int[s.length()+1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i=2; i<=s.length(); i++)
			dp[i] = 1;
		
		for (int i=2; i<=s.length(); i++) {
			
			for (int j=1;j<i; j++) {
				
				if (s.charAt(j-1)<=s.charAt(i-1))
					dp[i] = Math.max(dp[i], dp[j]+1);
				
			}
			
		}
		return dp[s.length()];
	}

}
