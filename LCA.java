/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 */
public class LCA {
	   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root==null)
	            return null;
	        if(root==p || root == q)
	            return root;
	        TreeNode r1 = lowestCommonAncestor(root.left , p , q);
	        TreeNode r2 = lowestCommonAncestor(root.right , p , q);
	        if(r1!=null && r2!=null)
	            return root;
	        if(r1!=null)
	            return r1;
	        else
	            return r2;
	    }

}
