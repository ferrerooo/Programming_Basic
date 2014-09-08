package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L103BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (root == null)
			return lists;

		LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
		ll.add(root);
		int count = 1;
		int level = 0;

		while (!ll.isEmpty()) {

			level++;
			List<Integer> al = new ArrayList<Integer>();
			int curCount = 0;

			while (count > 0) {
				count--;
				if (level % 2 == 1) {
					TreeNode tn = ll.pollFirst();
					al.add(tn.val);
					if (tn.left != null) {
						ll.add(tn.left);
						curCount++;
					}
					if (tn.right != null) {
						ll.add(tn.right);
						curCount++;
					}
				} else {
					TreeNode tn = ll.pollLast();
					al.add(tn.val);
					if (tn.right != null) {
						ll.push(tn.right);
						curCount++;
					}
					if (tn.left != null) {
						ll.push(tn.left);
						curCount++;
					}

				}

			}
			count = curCount;
			lists.add(al);

		}
		return lists;
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
