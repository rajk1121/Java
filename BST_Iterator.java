import java.util.*;
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        while(root!=null){
            st.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        if(st.size()==0)
            return -1;
        TreeNode x = st.pop();
        int val = x.val;
        // System.out.println(val+" 8888");
        x = x.right;
        if(x!=null){
        // System.out.println(x.right.val);
            st.push(x);
            x = x.left;
        }
        if(x!=null){
                // x = x.left;
                while(x!=null){
                st.push(x);
                x = x.left;
            }
        }
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        // System.out.println(st.peek().val+"eeer");
        return st.size()!=0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */