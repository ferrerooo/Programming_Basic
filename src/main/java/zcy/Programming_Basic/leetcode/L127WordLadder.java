package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L127WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int ladderLength(String start, String end, Set<String> dict) {
        
        dict.add(start);
        dict.add(end);
        
        HashSet<String> visited = new HashSet<String>();
        List<List<String>> layers = new ArrayList<List<String>>();
        List<String> layer1 = new ArrayList<String>();
        layer1.add(start);
        visited.add(start);
        layers.add(layer1);
        
        while ( ! layers.get(layers.size()-1).isEmpty() ) {
            List<String> pre = layers.get(layers.size()-1);
            List<String> cur = new ArrayList<String>();
            
            for (String s:pre) {
                
                for (int i=0;i<s.length();i++) {
                    
                    char[] arr = s.toCharArray();
                    
                    for (char c='a'; c<='z'; c++) {
                        arr[i] = c;
                        String newstr = new String(arr);
                        if (dict.contains(newstr) && !visited.contains(newstr)) {
                            cur.add(newstr);
                            visited.add(newstr);
                        }
                    }
                    
                }
                
            }
            
            layers.add(cur);
            if (cur.contains(end))
                return layers.size();
        }
        
        return 0;
    }

}
