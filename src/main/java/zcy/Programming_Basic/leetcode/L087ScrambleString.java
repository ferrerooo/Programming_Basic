package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L087ScrambleString {
	
	public boolean isScramble(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length()==0 || s2.length()==0 || s1.length()!=s2.length())
            return false;
        
        if (containSameChar(s1, s2)==false)
            return false;
        
        if (s1.equals(s2))
            return true;
        
        return recur(s1, s2);
    }
    
    private boolean recur(String s1, String s2) {
        
        if (s1.length()!=s2.length() || containSameChar(s1, s2)==false)
            return false;
        if (s1.equals(s2))   // without this, it will be timeout
            return true;
        
        for (int i=1; i<s1.length() ;i++) {
            
            String s11 = s1.substring(0, i);
            String s21 = s2.substring(0, i);
            String s12 = s1.substring(i);
            String s22 = s2.substring(i);
            
            if (recur(s11, s21) && recur(s12, s22))
                return true;
            
            String s31 = s2.substring(s1.length()-i);
            String s32 = s2.substring(0, s1.length()-i);
            
            if (recur(s11, s31) && recur(s12, s32))
                return true;
            
        }
        return false;
    }
    
    private boolean containSameChar(String s1, String s2) {
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        for (int i=0;i<s1.length();i++) {
            if (ht.containsKey(s1.charAt(i))) {
                ht.put(s1.charAt(i), ht.get(s1.charAt(i))+1);
            } else {
                ht.put(s1.charAt(i), 1);
            }
        }
        
        
        for (int i=0;i<s2.length(); i++) {
            if (ht.containsKey(s2.charAt(i))==false)
                return false;
            else {
                ht.put(s2.charAt(i), ht.get(s2.charAt(i))-1);
                if (ht.get(s2.charAt(i))==0)
                    ht.remove(s2.charAt(i));
            }
        }
        
        return true;
    }

}
