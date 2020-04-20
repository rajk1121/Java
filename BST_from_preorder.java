
public class BST_from_preorder {
	static int i=0;
	    public static TreeNode bstFromPreorder(int[] preorder) {
	        TreeNode root  = new TreeNode(preorder[0]);
	        i++;
	        root.left = generate( preorder, Integer.MIN_VALUE, preorder[0]);
	        root.right = generate(  preorder, preorder[0], Integer.MAX_VALUE);
	        return root;
	    }
	    public static TreeNode generate(int[] preorder,int min,int max ){
	        if(i>=preorder.length)
	            return null;
	        if(preorder[i]>min && preorder[i]<max){
	            TreeNode node = new TreeNode(preorder[i]);
	            i++;
	            node.left=generate( preorder, min, node.val);
	            node.right = generate( preorder, node.val, max);
	            return node;
	        }else{
	            return null;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {8,5,1,7,10,12};
		bstFromPreorder(preorder);
	}

}
