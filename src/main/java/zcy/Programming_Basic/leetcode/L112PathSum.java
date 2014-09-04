package zcy.Programming_Basic.leetcode;

public class L112PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return false;

		return recur(root, sum, 0);

	}

	private boolean recur(TreeNode root, int sum, int cur) {

		if (root.left == null && root.right == null) {
			if (sum == cur + root.val)
				return true;
			else
				return false;
		}

		if (root.left != null) {

			if (recur(root.left, sum, cur + root.val))
				return true;

		}

		if (root.right != null) {
			if (recur(root.right, sum, cur + root.val))
				return true;
		}

		return false;
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
