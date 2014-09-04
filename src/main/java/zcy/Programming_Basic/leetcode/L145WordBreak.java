package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L145WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean wordBreak(String s, Set<String> dict) {
        
        if (dict==null || dict.isEmpty() || s==null || s.length()==0)
            return false;
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for (int i=1;i<=s.length();i++) {
            
            for (int j=1;j<=i;j++) {
                
                if (dp[j-1]==true && dict.contains(s.substring(j-1, i)) ) {
                    dp[i] = true;
                    break;
                }
                
            }
            
        }
        return dp[s.length()];
    }

}
