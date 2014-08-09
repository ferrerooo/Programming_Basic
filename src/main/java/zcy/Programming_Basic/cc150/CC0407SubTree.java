package zcy.Programming_Basic.cc150;
import java.util.*;
public class CC0407SubTree {
	
	public boolean isSubTree(TreeNode t1, TreeNode t2) {
		
		if (t2==null)
			return true;
		if (t1 == null)
			return false;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = t1;
		while (p!=null || !stack.isEmpty()) {
			if (p!=null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				
				if (isSub(p, t2))
					return true;				
				p = p.right;
			}
		}
		return false;
	}
	
	private boolean isSub(TreeNode t1, TreeNode t2) {
		if (t1==null && t2 == null)
			return true;
		if (t1==null && t2!=null)
			return false;
		if (t1!=null && t2==null)
			return true;
		if (t1.val != t2.val)
			return false;
		if (isSub(t1.left, t2.left) && isSub(t1.right, t2.right))
			return true;
		else
			return false;
	}

}

