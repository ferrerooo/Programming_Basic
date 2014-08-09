package zcy.Programming_Basic.cc150;

public class CC0406FindInorderNextNode {
	
	public TreeNode findInorderNext(TreeNode node) {
		
		if (node == null)
			return null;
		
		if (node.right != null) {
			
			TreeNode cur = node.right;
			while (cur.left != null)
				cur = cur.left;
			return cur;
		} 
		
		if (node.parent == null)
			return null;
		
		if (node == node.parent.left)
			return node.parent;
		
		TreeNode cur = node.parent;
		
		while (cur.parent != null && cur == cur.parent.right) {
			cur = cur.parent;
		}
		
		if (cur.parent == null)
			return null;
		else
			return cur.parent;
		
	}
	
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	public TreeNode(int _val) {
		this.val = _val;
		left = null;
		right = null;
		parent = null;
	}
}
