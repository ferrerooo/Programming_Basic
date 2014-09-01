package zcy.Programming_Basic.leetcode;

public class L028ImplementSubStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String strStr(String haystack, String needle) {
        
        if (haystack == null || needle == null || haystack.length() < needle.length())
            return null;
        if (needle.length() == 0)
            return haystack;
        
        int[] next = getNext(needle);
        
        int p1 = 0;
        int p2 = 0;
        
        while (p1 < haystack.length()) {
            
            if (haystack.charAt(p1) == needle.charAt(p2)) {
                p1++;
                p2++;
            } else {
                if (p2 == 0){
                    p1++;
                } else {
                    p2 = next[p2-1];
                }
            }
            
            if (p2 == needle.length()) 
                return haystack.substring(p1-needle.length());
        }
        
        return null;
    }
    
    private int[] getNext(String needle) {
        
        int[] arr = new int[needle.length()];
        
        arr[0] = 0;
        
        for (int i=1;i<arr.length; i++) {
            
            int k = arr[i-1];
            
            while (needle.charAt(i) != needle.charAt(k) && k != 0 )
                k = arr[k-1];
            
            if (needle.charAt(i) == needle.charAt(k) )
                arr[i] = k+1;
            else
                arr[i] = 0;
        }
        return arr;
    }

}
