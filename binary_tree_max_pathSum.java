
public class binary_tree_max_pathSum {
	int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // max = root.val;
        generate(root);   
        return max;
    }
    public int generate(TreeNode root){
        if(root==null)
            return 0;
        int left = generate(root.left);
        int right = generate(root.right);
        max = Math.max(max, root.val+left);
        max = Math.max(max, root.val+right);
        max = Math.max(max, root.val);
        max = Math.max(max, left+right+root.val);
        return Math.max(left+root.val,Math.max(root.val, right+root.val));
        
    }
}
