package zcy.Programming_Basic.cc150;

import java.util.Stack;

public class CC0406FirstCommonAncestor_v2 {

	// public TreeNode findFirstCommonAncestor(TreeNode root, TreeNode p1,
	// TreeNode p2) {
	//
	// if (root == null || p1 == null || p2 == null)
	// return null;
	//
	// return recur(root, p1, p2);
	//
	// }
	// private TreeNode recur(TreeNode root, TreeNode p1, TreeNode p2) {
	// if (root == p1 || root == p2)
	// return root;
	// if (contains(root.left, p1) && contains(root.left, p2))
	// return recur(root.left, p1, p2);
	// if (contains(root.right, p1) && contains(root.right, p2))
	// return recur(root.right, p1, p2);
	// return root;
	// }
	//
	// private boolean contains(TreeNode root, TreeNode p) {
	// if (root == null)
	// return false;
	// if (root == p)
	// return true;
	// return contains(root.left, p)||contains(root.right, p);
	// }

	public TreeNode findFirstCommonAncestor(TreeNode root, TreeNode p1,
			TreeNode p2) {
		if (root == null || p1 == null || p2 == null)
			return null;
		return recur(root, p1, p2);
	}

	private TreeNode recur(TreeNode root, TreeNode p1, TreeNode p2) {
		if (root == p1 || root == p2)
			return root;
		int number = getNumber(root.left, p1, p2);
		if (number == 0)
			return recur(root.right, p1, p2);
		else if (number == 1)
			return root;
		else
			return recur(root.left, p1, p2);
	}

	private int getNumber(TreeNode root, TreeNode p1, TreeNode p2) {
		int count = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (cur == p1)
					count++;
				if (cur == p2)
					count++;
				cur = cur.right;
			}
		}
		return count;
	}

	private class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int value) {
			val = value;
			left = null;
			right = null;
		}
	}

}
