package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L144WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> wordBreak(String s, Set<String> dict) {
        
        List<String> al = new ArrayList<String>();
        if (dict==null || dict.isEmpty() || s==null || s.length() == 0)
            return al;
        
        HashMap<Integer, List<String>> ht = new HashMap<Integer, List<String>>();
        
        al =  recur(s, dict, ht, 0);
        if (al == null)
            return new ArrayList<String>();
        else
            return al;
    }
    private List<String> recur(String s, Set<String> dict, HashMap<Integer, List<String>> ht, int index) {
        if (ht.containsKey(index))
            return ht.get(index);
        
        if (index == s.length()) {
            ht.put(s.length(), new ArrayList<String>());
            return ht.get(index);
        }
        
        List<String> al = new ArrayList<String>();
        for (int i=index; i<s.length(); i++) {
            String str = s.substring(index, i+1);
            if (dict.contains(str)) {
                List<String> list = recur(s, dict, ht, i+1);
                if (list == null) {
                    continue;
                } else if (list.isEmpty()) {
                    al.add(str);
                } else {
                    
                    for (String s1:list) {
                        al.add(str+" "+s1);
                    }
                    
                }
            }
        }
        if (al.isEmpty())
            ht.put(index, null);
        else
            ht.put(index, al);
        return ht.get(index);
    }

}
