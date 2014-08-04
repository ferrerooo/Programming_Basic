package zcy.Programming_Basic.leetcode;

import java.util.*;

public class L126WordLadderII {
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        
        dict.add(start);
        dict.add(end);
        
        HashSet<String> visited = new HashSet<String>();
        HashSet<String> traced = new HashSet<String>();
        
        List<List<String>> layers = new ArrayList<List<String>>();
        Hashtable<String, List<String>> traceMap = new Hashtable<String, List<String>>();
        
        List<String> firstLayer = new ArrayList<String>();
        firstLayer.add(start);
        layers.add(firstLayer);
        visited.add(start);
        traced.add(start);
        
        while ( !layers.get(layers.size()-1).isEmpty() ) {
            
            List<String> pre = layers.get(layers.size()-1);
            List<String> cur = new ArrayList<String>();
            
            for (String s:pre) {
                
                String key = s;
                List<String> val = new ArrayList<String>();
                
                for (int i=0;i<s.length();i++) {
                    
                    char[] arr = s.toCharArray();
                    
                    for (char c='a'; c<='z'; c++) {
                        
                        arr[i] = c;
                        String newstr = new String(arr);
                        if (dict.contains(newstr) && !visited.contains(newstr)) {
                            visited.add(newstr);
                            cur.add(newstr);
                        }
                        
                        if (dict.contains(newstr) && !traced.contains(newstr)) {
                            val.add(newstr);
                        }
                    }
                }
                traceMap.put(key, val);
            }
            
            layers.add(cur);
            for (String s:cur)
                traced.add(s);
            if (cur.contains(end)) {
                return getPath(traceMap, start, end);
            }
            
        }
        return new ArrayList<List<String>>();
    }
    
    private List<List<String>> getPath(Hashtable<String, List<String>> traceMap, String start, String end ) {
        List<List<String>> lists = new ArrayList<List<String>>();
        recur(traceMap, start, end, lists, new ArrayList<String>());
        return lists;
    }
    private void recur(Hashtable<String, List<String>> traceMap, String cur, String end, List<List<String>> lists, List<String> al) {
        if (cur.equals(end)) {
            al.add(cur);
            lists.add(new ArrayList<String>(al));
            al.remove(al.size()-1);
            return ;
        }
        
        if (!traceMap.containsKey(cur))
            return;
        
        List<String> tracedNodes = traceMap.get(cur);
        al.add(cur);
        for (String s:tracedNodes) {
            recur(traceMap, s, end, lists, al);
        }
        al.remove(al.size()-1);
    }

}
