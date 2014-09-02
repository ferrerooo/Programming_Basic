package zcy.Programming_Basic.leetcode;

import java.util.*;

public class L076MinWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String minWindow(String S, String T) {
	
        if (S == null || T == null|| S.length() < T.length() || T.length() == 0)
            return "";
        
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        
        for (int i=0;i<T.length();i++) {
            if (ht.containsKey(T.charAt(i))==false) {
                ht.put(T.charAt(i), 1);
            } else {
                ht.put(T.charAt(i), ht.get(T.charAt(i))+1);
            }
        }
        
        int minLen = Integer.MAX_VALUE;
        String minstr = "";
        
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        
        while (p1 < S.length()) {
            
            char c = S.charAt(p1);
            
            if (!ht.containsKey(c)) {
                p1++;
            } else {
                
                ht.put(c, ht.get(c)-1);
                
                if (ht.get(c) >= 0) {
                    count ++;
                    
                    while (count == T.length()) {
                        
                        char h = S.charAt(p2);
                        if (!ht.containsKey(h)) {
                            p2++;
                        } else {
                            ht.put(h, ht.get(h)+1);
                            if (ht.get(h)>0) {
                                count--;
                                if (p1-p2+1 < minLen) {
                                    minLen = p1-p2+1;
                                    minstr = S.substring(p2, p1+1);
                                }
                            }
                            p2++;
                        }
                    }
                    
                }
                
                p1++;
            }
            
        }
        
        return minstr;
        
    }

}
