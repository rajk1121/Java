import java.util.*;

public class validateBST {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
}
	public static boolean isValid(TreeNode root, int min, int max, boolean[][]dp) {
		if(root==null)
			return true;
		boolean left,right;
	    left=false;
	    right=false;
	    // if(min==Integer.MI)
	  if(root.val<max && root.val>min || root.val==Integer.MIN_VALUE && !dp[0][0] && root.val<max && root.val>=min){
	        dp[0][0]= true;
	            left= isValid(root.left, min, root.val,dp);
	        
	            right=isValid(root.right,root.val,max ,dp);
	    }
	  else if(root.val<max && root.val>min || root.val==Integer.MAX_VALUE && !dp[0][1] && root.val<=max && root.val>min){
	        dp[0][1]=true;
          left= isValid(root.left, min, root.val,dp);
      
          right=isValid(root.right,root.val,max ,dp);
  }
	    return left&&right;
		
	    }
    public static boolean isValidBST(TreeNode root) {
       if(root==null){
           return true;
       }
       boolean[][]dp = new boolean[1][2];
       boolean left = isValid(root.left, Integer.MIN_VALUE, root.val,dp);
        boolean right = isValid(root.right, root.val, Integer.MAX_VALUE,dp);
        return left && right;
	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		validateBST demo = new validateBST();
		TreeNode root = demo.new TreeNode(Integer.MIN_VALUE);
		root.right = demo.new TreeNode(Integer.MAX_VALUE);
//		root.right.left = demo.new TreeNode(Integer.MIN_VALUE);
//		root.left = demo.new TreeNode(-2147483648);
//		System.out.println(Integer.MAX_VALUE+1 > Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE-1);
		System.out.println(isValidBST(root));
	}

}
