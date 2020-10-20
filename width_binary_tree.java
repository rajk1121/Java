/*
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).

Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).



 */
import java.util.*;
public class width_binary_tree {
		static int max_width = 0;
	    static HashMap<Integer, Integer> set;
	    public static int widthOfBinaryTree(TreeNode node) {
	     set = new HashMap<>();
	        calculate(node, 0 ,1);
	        return max_width;
	     
	    } 
	    
	    public static void calculate(TreeNode root, int depth, int pos){
	        if(root==null)
	            return;
	        
	        if(!set.containsKey(depth)){
	            set.put(depth, pos);
	        }
	        max_width = Math.max(max_width, pos - set.get(depth)  + 1);
	        calculate(root.left, depth + 1 , pos*2);
	        calculate(root.right , depth+1 , pos*2+1);
	        
	    }
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(3);
//		root.left.left.left = new TreeNode(6);
		root.right.left = new TreeNode(5);
//		root.right.right.right = new TreeNode(7);
		System.out.println(widthOfBinaryTree(root));

	}

}
