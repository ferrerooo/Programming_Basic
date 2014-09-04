package zcy.Programming_Basic.leetcode;

public class L132PalindromePartitioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minCut(String s) {
        
        if (s.length()<=1)
            return 0;
        
        boolean[][] isp = new boolean[s.length()][s.length()];
        for (int j=0;j<s.length();j++) {
            for (int i=0;i<=j;i++) {
                if ( s.charAt(i)==s.charAt(j) && (j-i<=2 || isp[i+1][j-1]==true) )
                    isp[i][j] = true;
            }
        }
        
        int[] dp = new int[s.length()+1];
        for (int i=0;i<dp.length;i++)
            dp[i] = i-1;
        
        for (int i=2;i<=s.length(); i++) {
            
            for (int j=1; j<=i;j++ ) {
                
                if (isp[j-1][i-1]==true) {
                    dp[i] = Math.min(dp[i], 1+dp[j-1]);
                }
                
            }
            
        }
        
        return dp[s.length()];
    }

}
