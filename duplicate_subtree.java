import java.util.*;
public class duplicate_subtree {
	static HashMap<String,Integer> set = new HashMap<>();
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        find(root , list);
        return list;
    }
    public static String find(TreeNode root, List<TreeNode> list){
        if(root == null)
            return "null ";
        String left = find(root.left, list);
//        System.out.println(left);
        String right = find(root.right, list);
//        System.out.println(right);
        String inorder  = root.val+ " " + left +  right;
//        System.out.println(set);
//        System.out.println(inorder);
//        System.out.println("*****");
        if( set.containsKey(inorder) ){
        	if(set.get(inorder)==0) {

                list.add(root);
                set.put(inorder, 1);	
        	}
        }else{
            set.put(inorder, 0);
        }
        return inorder;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(0);

		root.left.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(0);
		root.right.right = new TreeNode(0);
		root.right.right.right = new TreeNode(0);
		root.right.right.left = new TreeNode(0);
		System.out.println(findDuplicateSubtrees(root).size());
	}

}
