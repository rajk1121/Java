/*
 *  Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree.

Example 1:

Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1

 */
public class max_binary_tree {
	   public TreeNode constructMaximumBinaryTree(int[] nums) {
	        System.out.println(nums.length);
	        return construce(nums, 0 , nums.length-1);
	    }
	    public TreeNode construce(int[] nums,  int s, int e){
	        // System.out.println(s+ " "+ e);
	        if(s==e){
	            TreeNode n = new TreeNode(nums[s]);
	            return n;
	        }
	        if(s>e){
	            return null;
	        }
	        
	        int index =s;
	        for(int i=s; i<=e; i++){
	           if(nums[index]<nums[i])
	               index = i;
	        }
	        TreeNode root = new TreeNode(nums[index]);
	        root.left = construce(nums, s, index-1);
	        root.right = construce(nums ,index+1 , e);
	        return root;
	        
	    }
}
