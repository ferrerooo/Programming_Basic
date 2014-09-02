package zcy.Programming_Basic.leetcode;

import java.util.*;

public class L096UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<TreeNode> generateTrees(int n) {

		List<TreeNode> al = new ArrayList<TreeNode>();
		if (n <= 0) {
			al.add(null);
			return al;
		}

		return recur(1, n);
	}

	private List<TreeNode> recur(int start, int end) {
		if (start > end) {
			List<TreeNode> al = new ArrayList<TreeNode>();
			al.add(null);
			return al;
		}
		if (start == end) {
			List<TreeNode> al = new ArrayList<TreeNode>();
			al.add(new TreeNode(start));
			return al;
		}
		List<TreeNode> al = new ArrayList<TreeNode>();
		for (int i = start; i <= end; i++) {

			List<TreeNode> left = recur(start, i - 1);
			List<TreeNode> right = recur(i + 1, end);

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode tn = new TreeNode(i);
					tn.left = l;
					tn.right = r;
					al.add(tn);
				}
			}
		}
		return al;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
}
