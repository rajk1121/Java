/*
 * 
 * Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6


 */
import java.util.*;
public class flatten_binary_tree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val=  x;
		}
	}
	//Real COde
	
	
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Stack<TreeNode> s = new Stack<>();
//		
//        if(root==null)
//            return;
//        if(root.right!=null)
//            s.push(root.right);
//        if(root.left!=null)
//            s.push(root.left);
//        
//        while(!s.isEmpty()){
//        root.left=null;    
//        TreeNode temp = s.pop();
//        root.right = temp;
//        if(temp.right!=null)
//            s.push(temp.right);
//        if(temp.left!=null)
//            s.push(temp.left);
//        root =root.right;
//        
//        }
//	}

}
