import java.util.*;
/*
 * Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 
 */
class NodeVertical{
    TreeNode node;
    int X;
    NodeVertical(TreeNode n , int X){
        this.node = n;
        this.X=  X;
    }
}

	
	class vertical_order_tree {
	    
	    public List<List<Integer>> verticalTraversal(TreeNode root) {
	        int lower= Integer.MAX_VALUE;
	        int higher = Integer.MIN_VALUE;
	 List<List<Integer>>answer = new ArrayList<>();
	        if(root == null)
	            return answer;
	        Queue<NodeVertical> q = new LinkedList<>();
	        NodeVertical n = new NodeVertical(root, 0);
	        q.add(n);
	        HashMap<Integer, List<Integer>> set = new HashMap<>();
	        while(q.size()!=0){
	        	NodeVertical temp = q.remove();
	            if(lower>temp.X){
	                lower = temp.X;
	            }
	            if(higher<temp.X){
	                higher = temp.X;
	            }
	            System.out.println(temp.node.val);
	            if(set.containsKey(temp.X)){
	                List<Integer> tempList = set.get(temp.X);
	                System.out.println(set.get(temp.X));
	                tempList.add(temp.node.val);
	                set.put(temp.X , tempList);
	            }else{
	                 List<Integer> tempList = new ArrayList<>();
	                tempList.add(temp.node.val);
	                set.put(temp.X , tempList);
	                System.out.println(set.get(temp.X));
	            }
	            System.out.println("*****");
	            if(temp.node.left!=null){
	            	NodeVertical x = new NodeVertical(temp.node.left , temp.X - 1);
	                q.add(x);
	            }
	            if(temp.node.right!=null){
	            	NodeVertical x = new NodeVertical(temp.node.right , temp.X + 1);
	                q.add(x);
	            }
	        }
	        for(int i=lower ; i<=higher ; i++){
	            answer.add(set.get(i));
	        }
	        
	     
	     return answer;
	    }
	  
	}
