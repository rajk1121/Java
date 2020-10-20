/*
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 
 */
import java.util.*;
public class cousins_binary_tree {
	  public boolean isCousins(TreeNode root, int x, int y) {
	        HashMap<Integer, Integer> parent = new HashMap<>();
	        HashMap<Integer, Integer> depth = new HashMap<>();
	        partTwo(root, 0, parent, depth);
	        if(parent.get(x)!=parent.get(y) && depth.get(x)==depth.get(y))
	            return true;
	        return false;
	    }
	    public void partTwo(TreeNode root,int d, HashMap<Integer, Integer> parent,HashMap<Integer, Integer> depth ){
	        if(root.left!=null){
	            parent.put(root.left.val,root.val);
	            depth.put(root.left.val, d+1);
	            partTwo(root.left, d+1, parent, depth);
	        }
	        if(root.right!=null){
	            parent.put(root.right.val,root.val);
	            depth.put(root.right.val, d+1);
	            partTwo(root.right, d+1, parent, depth);
	        }
	    }
}
