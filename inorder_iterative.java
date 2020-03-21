import java.util.*;
public class inorder_iterative {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
		 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		inorder_iterative demo = new inorder_iterative();
		TreeNode root = demo.new TreeNode(1);
		root.right = demo.new TreeNode(2);
		root.right.left = demo.new TreeNode(3);
//		root.left = demo.new TreeNode(x);
//		root.left = demo.new TreeNode(x);
//		root.left = demo.new TreeNode(x);
		Stack<TreeNode> one = new Stack<>();
		Stack<TreeNode> two = new Stack<>();
		
		if(root!=null) {

			two.push(root);
		}
		while(!two.isEmpty()) {
			TreeNode temp = two.pop();
			if(temp.right!=null) {
				two.push(temp.right);
			}
			if(temp.left==null) {
				System.out.println(temp.val);
				if(!one.isEmpty())
					System.out.println(one.pop().val);
			}else {
				two.push(temp.left);
				one.push(temp);
			}
		}

	}

}
