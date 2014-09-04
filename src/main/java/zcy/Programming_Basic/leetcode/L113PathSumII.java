package zcy.Programming_Basic.leetcode;
import java.util.*;

import zcy.Programming_Basic.leetcode.L112PathSum.TreeNode;
public class L113PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null)
            return lists;
        
        recur(root, sum, 0, lists, new ArrayList<Integer>());
        return lists;
    }
    
    private void recur(TreeNode root, int sum, int cur, List<List<Integer>> lists, List<Integer> al) {
        if (root.left == null && root.right == null) {
            if (cur+root.val == sum) {
                al.add(root.val);
                lists.add(new ArrayList<Integer>(al));
                al.remove(al.size()-1);
            }
            return ;
        }
        
        al.add(root.val);
        if (root.left != null) {
            recur(root.left, sum, cur+root.val, lists, al);
        }
        if (root.right != null) {
            recur(root.right, sum, cur+root.val, lists, al);
        }
        al.remove(al.size()-1);
    }
    
    class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
