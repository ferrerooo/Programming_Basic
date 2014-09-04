package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L131PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> partition(String s) {
        
        List<List<String>> lists = new ArrayList<List<String>>();
        
        boolean[][] isp = new boolean[s.length()][s.length()];
        
        for (int j=0;j<s.length();j++) {
            for (int i=0;i<=j; i++) {
                if (s.charAt(i)==s.charAt(j) && (j-i<=2 || isp[i+1][j-1] == true))
                    isp[i][j] = true;
            }
        }
        
        recur(s, 0, lists, new ArrayList<String>(), isp);
        return lists;
    }
    
    private void recur(String s, int index, List<List<String>> lists, List<String> al, boolean[][] isp) {
        if (index == s.length()) {
            lists.add(new ArrayList<String>(al));
            return;
        }
        
        for (int i=index; i<s.length(); i++) {
            
            if (isp[index][i]==true) {
                al.add(s.substring(index, i+1));
                recur(s, i+1, lists, al, isp);
                al.remove(al.size()-1);
            }
            
        }
    }

}
