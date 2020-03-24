
class Node{
	int val;
	Node left;
	Node right;
	public Node(int x) {this.val = x;}
	
}
public class binary_tree_from_sorted_arr {
	 public  static Node sortedArrayToBST(int[] nums) {
	     if(nums.length==0)
	         return null;
	     Node root = new Node(nums[nums.length/2]); 
	     System.out.println(nums[nums.length/2]);
	     root.left = buildTree(nums, 0, nums.length/2-1);
	     root.right = buildTree(nums, nums.length/2+1 , nums.length-1);
	     return root;
	    }
	    public static Node buildTree(int[] nums, int left, int right){
	        System.out.println(left+" "+right);
	        if(left>right)
	            return null;
	        System.out.println(nums[(right+left)/2]);
	        Node root = new Node(nums[(right+left)/2]);
	     root.left = buildTree(nums, left, (right+left)/2-1);
	     root.right = buildTree(nums, (right+left)/2+1 ,right);
	    return root;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-10,-3,0,5,9};
		Node root = sortedArrayToBST(nums);
		System.out.println(root.left.val);
	}

}
