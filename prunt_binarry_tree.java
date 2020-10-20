/*
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

Example 1:
Input: [1,null,0,0,1]
Output: [1,null,0,null,1]
 
Explanation: 
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.
 */
public class prunt_binarry_tree {
	  public TreeNode pruneTree(TreeNode root) {
	        if(root==null)
	            return null;
	        root.left = pruneTree(root.left);
	        root.right = pruneTree(root.right);
	        
	        if(root.val==0 && root.left==null && root.right==null)
	            return null;
	        return root;
	    }
}
