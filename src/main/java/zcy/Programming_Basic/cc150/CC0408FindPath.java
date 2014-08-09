package zcy.Programming_Basic.cc150;
import java.util.*;
public class CC0408FindPath {
	
	public List<List<Integer>> findAllPath(TreeNode root, int target) {
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (root == null)
			return lists;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p!=null || !stack.isEmpty()) {
			
			if (p!=null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				recur(p, target, lists, new ArrayList<Integer>(), 0);
				p = p.right;
			}
			
		}
		return lists;
	}
	
	private void recur(TreeNode root, int target, List<List<Integer>> lists, List<Integer> al, int sum) {
		
		sum = sum + root.val;
		al.add(root.val);
		
		if (sum == target){
			lists.add(new ArrayList<Integer>(al));
		}
		
		if (root.left != null)
			recur(root.left, target, lists, al, sum);
		if (root.right != null)
			recur(root.right, target, lists, al, sum);
		
		al.remove(al.size()-1);
	}

}
