package zcy.Programming_Basic.leetcode;

public class L009PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPalindrome(int x) {
        
        if (x <0)
            return false;
        if (x == 0)
            return true;
        
        int len = getLen(x);
        
        int p1 = 1;
        int p2 = len;
        
        while (p1<p2) {
            if (getPosition(x, p1) != getPosition(x, p2))
                return false;
            else {
                p1++;
                p2--;
            }
        }
        return true;
    }
    
    private int getLen(int x) {
        
        int count = 0;
        while (x!=0) {
            x = x/10;
            count++;
        }
        return count;
    }
    private int getPosition(int x, int p) {
        
        for (int i=0;i<p-1; i++)
            x = x/10;
        
        return x%10;
    }

}
