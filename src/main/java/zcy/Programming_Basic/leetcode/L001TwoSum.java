package zcy.Programming_Basic.leetcode;
import java.util.*;

public class L001TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public int[] twoSum(int[] numbers, int target) {
        
        if (numbers == null || numbers.length<2)
            return null;
        
        
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        for (int i:numbers) {
            
            if (!ht.containsKey(i))
                ht.put(i, 1);
            else 
                ht.put(i, ht.get(i)+1);
        }
        
        int i=0;
        int a = 0;
        int b = 0;
        for (; i<numbers.length; i++) {
            a = numbers[i];
            b = target-a;
            
            if (ht.containsKey(b)) {
                if (a!=b) {
                    break;
                } else {
                    if (ht.get(a)==2)
                        break;
                }
            } 
        }
        
        int j = i+1;
        for (;j<numbers.length; j++) {
            if (numbers[j] == b)
                break;
        }
        
        int[] ret = new int[2];
        ret[0] = i+1;
        ret[1] = j+1;
        
        return ret;
    }

}
