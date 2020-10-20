import java.util.*;
public class Most_Frequent_Subtree_Sum {
	  HashMap<Integer, Integer> set = new HashMap<>();
	    public int[] findFrequentTreeSum(TreeNode root) {
	        find(root);
	        if(set.size()==0)
	            return new int[0];
	        int max = 0;
	        // System.out.println(set);
	        for(Map.Entry<Integer, Integer> s: set.entrySet()){
	            if(s.getValue()>max)
	                max = s.getValue();
	        }
	        List<Integer> ans = new ArrayList<>();
	        for(Map.Entry<Integer, Integer> s: set.entrySet()){
	            if(s.getValue() == max)
	                ans.add(s.getKey());
	        }
	        int[] arr = new int[ans.size()];
	        for(int i=0 ; i<ans.size() ; i++){
	            arr[i] = ans.get(i);
	        }
	        return arr;
	        
	    }
	    public int find(TreeNode root){
	        if(root==null){
	            return 0;
	        }
	        
	        int left = find(root.left);
	        int right = find(root.right);
	        if(set.containsKey(left+right+root.val)){
	           set.put(left+right+root.val, set.get(right+left+root.val)+1);
	            
	        }else{
	            set.put(left+right+root.val, 1);
	        }
	        return left+right+root.val;
	    }
}
