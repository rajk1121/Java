class TreeNodes {
	      int val;
	      TreeNodes left;
	      TreeNodes right;
	      TreeNodes(int x) { val = x; }
}

public class tree_from_inorder_and_preorder {


public static TreeNodes buildTree(int[] preorder, int[] inorder) {
    if(preorder.length==0){
        TreeNodes root = null;
    return root;
    }
    int i=0;
    int j=0;
    boolean found=false;
    while(i < preorder.length && preorder[i]==Integer.MAX_VALUE) {
    	i++;
    }
    if(i==preorder.length) {
    	return null;
    }
    for(j=0;j<inorder.length;j++){
//    	System.out.println(inorder[j]+" "+preorder[i]);
        if(inorder[j]==preorder[i]){
            found=true;
            break;
        }
    }

    if(!found){
        return null;
    }

    TreeNodes root = new TreeNodes(preorder[i]);
    preorder[i]=Integer.MAX_VALUE;

   
    int[] leftnewin = new int[inorder.length-(inorder.length-j)];
    for( i=0 ; i<j ; i++){
        leftnewin[i] = inorder[i];
    }
    int k=0;
    int[] rightnewin = new int[inorder.length-j-1];
    for( i=j+1;  i<inorder.length ; i++){
        rightnewin[k] =inorder[i]; 
        k++;
    }
    root.left = buildTree(preorder, leftnewin);
    root.right = buildTree(preorder, rightnewin);
//    System.out.println(preorder);
    return root;
    
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = {9,3,15,20,7};
		int[] preorder = {3,9,20,15,7};
		TreeNodes ans = buildTree(preorder, inorder);
		System.out.println(ans.right.right.val);
	}

}
