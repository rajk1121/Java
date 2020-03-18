import java.util.*;
public class maximum_path_sum_between_two_leaves_of_a_binary_tree {
	
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
			this.right=null;
			this.left=null;
		}
	}
	static int max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		maximum_path_sum_between_two_leaves_of_a_binary_tree answer = new maximum_path_sum_between_two_leaves_of_a_binary_tree();
		Node n = answer.new Node(-15); 
          n.left = answer.new Node(5); 
          n.right = answer.new Node(6); 
          n.left.left = answer.new Node(-8); 
          n.left.right = answer.new Node(1); 
          n.left.left.left = answer.new Node(2); 
          n.left.left.right = answer.new Node(6); 
          n.right.left = answer.new Node(3); 
          n.right.right = answer.new Node(9); 
          n.right.right.right = answer.new Node(0); 
          n.right.right.right.left = answer.new Node(4); 
          n.right.right.right.right = answer.new Node(-1); 
          n.right.right.right.right.left = answer.new Node(10); 
//          System.out.println(max);
          findSum(n);
          System.out.println(max);
	}
	private static int findSum(Node n) {
		if(n==null) {
			return 0;
		}
		int left = findSum(n.left);
		int right = findSum(n.right);
		int sum = left+right+n.data;
		if(sum>max) {
//			System.out.println(left+" "+right+" "+max+ " "+n.data+" "+sum);
			max = sum;
		}
		return Math.max(right+n.data, left+n.data);
		
	}	

}
