import java.util.*;
public class inorder_iterative {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
		 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		inorder_iterative demo = new inorder_iterative();
		TreeNode root = demo.new TreeNode(1);
		root.right = demo.new TreeNode(2);
		root.right.left = demo.new TreeNode(3);
//		root.left = demo.new TreeNode(x);
//		root.left = demo.new TreeNode(x);
//		root.left = demo.new TreeNode(x);
		 Stack<TreeNode> one = new Stack<>();
			Stack<TreeNode> two = new Stack<>();
	        List<Integer> answer = new ArrayList<>();
			
			if(root!=null) {

				one.push(root);
			}
			while(!one.isEmpty()) {
				TreeNode temp = one.pop();
				two.push(temp);
	            if(temp.left!=null)
	                one.push(temp.left);
	            else{
	                while(!two.isEmpty()){
	                    TreeNode n = two.pop();
	                    answer.add(n.val);
	                    if(n.right!=null){
	                        one.push(n.right);
	                        break;
	                    }
	                    
	                }
	            }
			}

	        System.out.println(answer);

	}

}
