import java.util.*;
class TreeNodess{
	int val;
	TreeNodess left;
	TreeNodess right;
	TreeNodess(int x){
		this.val = x;
	}
}
public class tree_from_postorder_inorder {
	public static TreeNodess buildTree(int[] inorder, int[]postorder) {
		  if(postorder.length==0){
		        TreeNodess root = null;
		    return root;
		    }
		    int i=postorder.length-1;
		    int j=0;
		    boolean found=false;
		    while(i >= 0 && postorder[i]==Integer.MAX_VALUE) {
		    	i--;
		    }
		    if(i == -1) {
		    	return null;
		    }
		    for(j=0;j<inorder.length;j++){
		    	System.out.println(inorder[j]+" "+postorder[i]);
		        if(inorder[j]==postorder[i]){
		            found=true;
		            break;
		        }
		    }

		    if(!found){
		        return null;
		    }

		    TreeNodess root = new TreeNodess(postorder[i]);
		    postorder[i]=Integer.MAX_VALUE;

		   
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
		    root.right = buildTree( rightnewin, postorder);
		    root.left = buildTree( leftnewin,postorder);
//		    System.out.println(preorder);
		    return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNodess ans = buildTree(inorder,  postorder);
		System.out.println(ans.right.val);

	}

}
