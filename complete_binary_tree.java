
public class complete_binary_tree {
	 public static int countNodes(TreeNode root) {
			int left = leftHeight(root);
	        int right = rightHeight(root);
	        // System.out.println(left);
	        if(left==right && right==0)
	        	return 0;
	        if(left==right){
	            // System.out.println(left+" "+root.val+" "+right);
	            return ((2<<(left-1)) - 1);
	        }
	        return countNodes(root.left) + countNodes(root.right)+1 ;
	    }
	    public static int leftHeight(TreeNode root){
	        int h = 0;
//	        System.out.println(root.val);
	        while(root!=null){
	            h++;
	            root = root.left;
	        }
	        // if(h==-1)

	        return h;
	    }
	    
	    public static int rightHeight(TreeNode root){
	        int h = 0;
	        TreeNode temp = root;
	        while(root!=null){
	            h++;
	            root = root.right;
	        }
//	        System.out.println(temp.val + " "+h);
	        return h;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		System.out.println(countNodes(root));
//		System.out.println((2<<1 )- 1 );
	}

}
