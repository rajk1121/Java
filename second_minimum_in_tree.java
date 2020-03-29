/*
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:

Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.

 

Example 2:

Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.

 */
import java.util.*;
public class second_minimum_in_tree {
	 public int findSecondMinimumValue(TreeNode root) {
	        
	        int left = find(root.left, root.val);
	        int right= find(root.right, root.val);
	        if(left==-1 || right==-1)
	                return Math.max(left, right);
	        else
	                return Math.min(left, right);
	        }
	    
	    public int find(TreeNode root, int rootVal){
	        if(root==null)
	            return -1;
	        
	        if(root.val == rootVal){
	          int left = find(root.left, root.val);
	            int right=  find(root.right, root.val);
	            if(left==-1 || right==-1)
	                return Math.max(left, right);
	            else
	                return Math.min(left, right);
	        }else{
	            return root.val;
	        }
	        
	        
	    }
}
