package zcy.Programming_Basic.leetcode;

public class L096UniqueBinarySearchTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numTrees(int n) {
        
        if (n<=1)
            return 1;
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i=2;i<=n;i++) {
            int total = 0;
            for (int j=1;j<=i;j++) {
                
                total += dp[j-1-1+1]*dp[i-(j+1)+1];
                
            }
            dp[i] = total;
        }
        return dp[n];
    }

}
