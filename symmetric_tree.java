
public class symmetric_tree {
	public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return tell(root.left, root.right);
    }
    public boolean tell(TreeNode n1, TreeNode n2){
        if(n1==null || n2==null){
            return n1==null && n2==null;
        }
        if(n1.val!=n2.val)
            return false;
        return tell(n1.left, n2.right) && tell(n1.right, n2.left);
    }
}
