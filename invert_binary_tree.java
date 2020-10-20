/*
 * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class invert_binary_tree {
	public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
