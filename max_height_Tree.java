import java.util.*;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class max_height_Tree {
public int maxDepth(TreeNode root) {
	if(root==null)
        return 0;
    int left = 1+maxDepth(root.left);
    int right = 1+maxDepth(root.right);
    return Math.max(left, right);
    }
}
