package zcy.Programming_Basic.cc150;
import java.util.*;
public class CC0406FirstCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public TreeNode firstAncestor(TreeNode root, TreeNode tn1, TreeNode tn2) {
		
		if (root == null || tn1 == null || tn2 == null)
			return null;
		
		if (tn1 == tn2)
			return tn1;
		
		return recur(root, tn1, tn2);
		
	}
	private TreeNode recur(TreeNode root, TreeNode tn1, TreeNode tn2) {
		
		if (root == tn1 || root == tn2)
			return root;
		
		boolean tn1InLeft = findTreeNode(root.left, tn1);
		boolean tn2InLeft = findTreeNode(root.right, tn2);
		
		if (tn1InLeft == false && tn2InLeft == false)
			return recur(root.right, tn1, tn2);
		else if (tn1InLeft == true && tn2InLeft == true)
			return recur(root.left, tn1, tn2);
		else 
			return root;
	}
	private boolean findTreeNode(TreeNode root, TreeNode tn) {
		if (root == null)
			return false;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p!=null || !stack.isEmpty()) {
			
			if (p!=null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				if (p == tn)
					return true;
				p = p.right;
			}
			
		}
		return false;
	}
	
	//-------------------------------------------------------------------------------------------
	
	
	//-------------------------------------------------------------------------------------------
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int _val) {
			this.val = _val;
			left = null;
			right =  null;
		}
	}

}
