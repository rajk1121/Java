//Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.
import java.util.*;

public class bstToGreaterTree{

	   public class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	
		// TODO Auto-generated method stub
		private int sum = 0;
	    public TreeNode bstToGst(TreeNode root) {
	        if(root==null){
	            return null;
	        }
	        TreeNode right = bstToGst(root.right);
	        sum+=root.val;
	        root.val = sum;
	        System.out.println(root.val +" "+ sum);
	        TreeNode left = bstToGst(root.left);
	        
	        return root;
	    }
	

}
