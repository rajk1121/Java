
public class sameTree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
}
	public static boolean isSame(TreeNode r1, TreeNode r2) {
		if(r1==null && r2==null)
			return true;
		if(r1==null || r2==null)
			return false;
		if(r1.val == r2.val) {
			boolean left = isSame(r1.left, r2.left);
			if(!left)
				return left;
			boolean right = isSame(r1.right, r2.right);
			return left && right;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sameTree demo = new sameTree();
		TreeNode root = demo.new TreeNode(Integer.MIN_VALUE);
		root.right = demo.new TreeNode(Integer.MAX_VALUE);
		root.right.left = demo.new TreeNode(Integer.MIN_VALUE);
		root.left = demo.new TreeNode(-2147483648);
//		sameTree demo = new sameTree();
		TreeNode root1 = demo.new TreeNode(Integer.MIN_VALUE);
		root1.right = demo.new TreeNode(Integer.MAX_VALUE);
		root1.right.left = demo.new TreeNode(Integer.MIN_VALUE);
		root1.left = demo.new TreeNode(8);
		System.out.println(isSame(root, root1));
	}

}
