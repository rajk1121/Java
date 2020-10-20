/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

 */
import java.util.*;
public class zig_zag_level_order {
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	       Stack<TreeNode> s1 = new Stack<>();
	        Stack<TreeNode> s2 = new Stack<>();
	        boolean dir = true;
	        if(root!=null){
	            s1.push(root);
	        }else{
	            List<List<Integer>> answer = new ArrayList<>();
	            return answer;
	        }
	        List<List<Integer>> answer = new ArrayList<>();
	        while(true){
	            List<Integer> ians = new ArrayList<>();
	            
	            while(!s1.isEmpty()){
	            TreeNode temp = s1.pop();
	            ians.add(temp.val);
	            if(dir){
	                if(temp.left!=null)
	                    s2.push(temp.left);
	                if(temp.right!=null)
	                    s2.push(temp.right);
	            }else{
	               if(temp.right!=null)
	                   s2.push(temp.right);
	                if(temp.left!=null)
	                    s2.push(temp.left);
	            }
	        }
	            answer.add(ians);
	            if(s2.isEmpty())
	                break;
	            s1=s2;
	            s2=new Stack<>();
	            dir = !dir;
	        }
	        return answer;
	    }
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
}
	

}
