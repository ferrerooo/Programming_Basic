package zcy.Programming_Basic.leetcode;

public class L081SearchRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean search(int[] A, int target) {
        if (A== null || A.length == 0)
            return false;
        
        return recur(A, target, 0, A.length-1);
    }
    
    private boolean recur(int[] A, int target, int start, int end) {
        if (start > end)
            return false;
        if (start == end) {
            if (A[start] == target)
                return true;
            else
                return false;
        }
        
        int mid = (start+end)/2;
        
        if (A[mid] == target){
            return true;
        } else {
            
            if (isInorder(A, start, mid)) {
                if (target>=A[start] && target<A[mid]) {
                    return recur(A, target, start, mid-1);
                } else {
                    return recur(A, target, mid+1, end);
                }
            } else {
                if (target>A[mid] && target<=A[end])
                    return recur(A, target, mid+1, end);
                else
                    return recur(A, target, start, mid-1);
            }
            
        }
    }
    
    private boolean isInorder(int[] A, int start, int end) {
        if (start == end)
            return true;
        
        int pre = A[start];
        for (int i=start+1; i<=end; i++) {
            if (pre <= A[i]) {
                pre = A[i];
            } else {
                return false;
            }
        }
        return true;
    }

}
