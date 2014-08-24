package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L097InterleavingString {

	public static void main(String[] args) {
		

	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s1==null || s2==null || s3==null|| s1.length()+s2.length() != s3.length() || containSameChar(s1+s2, s3) == false)
            return false;
        
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        int m = s1.length();
        int n = s2.length();
        
        dp[0][0] = true;  // set true for the situation: s1=""  s2=""  s3=""
        
        for (int i=1;i<=n; i++) {
            
            if (s2.substring(0, i).equals(s3.substring(0,i)))
                dp[0][i] = true;
            else
                dp[0][i] = false;
        }
        
        for (int i=1;i<=m;i++) {
            if(s1.substring(0,i).equals(s3.substring(0,i)))
                dp[i][0] = true;
            else
                dp[i][0] = false;
        }
        
        for (int i=1;i<=m;i++ ) {
            for (int j=1;j<=n;j++) {
                
                if (s1.charAt(i-1)!=s3.charAt(i+j-1) && s2.charAt(j-1)!=s3.charAt(i+j-1))
                    dp[i][j] = false;
                else if (s1.charAt(i-1)==s3.charAt(i+j-1) && s2.charAt(j-1)!=s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i-1][j];
                } else if (s1.charAt(i-1)!=s3.charAt(i+j-1) && s2.charAt(j-1)==s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        
        return dp[m][n];
    }
    
    private boolean containSameChar(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        String s3 = new String(arr1);
        String s4 = new String(arr2);
        
        return s3.equals(s4) ? true:false;
    }

}
