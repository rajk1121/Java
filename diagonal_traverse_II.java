/*
 * Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.

 

Example 1:

Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]

 */
import java.util.*;
class TraverseNode{
    int i,j, data;
    public TraverseNode(int a, int b, int d){
        i=a;
        j=b;
        data=d;
    }
}
public class diagonal_traverse_II {
	 public static int[] findDiagonalOrder(List<List<Integer>> nums) {
	        int total = 0;
	        for(int i=0 ; i<nums.size() ; i++){
	            total = total+nums.get(i).size();
	        }
	        
	        int[] ans=new int[total];
	        Queue<TraverseNode> q = new LinkedList<>();
	        TraverseNode x = new TraverseNode(0,0,nums.get(0).get(0));
	        q.add(x);
	        int j=0;
	        int crow  = 0;
	        boolean found = false;
	        while(q.size()!=0){
	            int size = q.size();
	            
	            for(int i=0 ; i<size; i++){
	                
	                if(i==0){
	                    TraverseNode a = q.remove();
	                    ans[j] = a.data;
	                    j++;
	                    System.out.println(a.data);
	                    if(a.i<nums.size()-1 && a.j<nums.get(a.i+1).size()){
	                           TraverseNode n = new TraverseNode(a.i+1, 0, nums.get(a.i+1).get(0));
	                            q.add(n);
	                    }
	                    if(a.j!=nums.get(a.i).size() - 1){
	                        TraverseNode n = new TraverseNode(a.i, a.j +1, nums.get(a.i).get(a.j+1));
	                        q.add(n);
	                    }
	                }
	                else{
	                    TraverseNode a = q.remove();
	                ans[j] = a.data;
	                j++;
	                System.out.println(a.data);
	                if(a.j!=nums.get(a.i).size() - 1){
	                    TraverseNode n = new TraverseNode(a.i, a.j +1, nums.get(a.i).get(a.j+1));
	                    q.add(n);
	                }
	                }
	            }
	            
	            
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> nums=  new ArrayList<>();
		List<Integer> o = new ArrayList<>();
		o.add(14);
		o.add(12);
		o.add(19);
		o.add(16);
		o.add(9);
		nums.add(o);
		o = new ArrayList<>();
		o.add(13);
		o.add(14);
		o.add(15);
		o.add(8);
		o.add(11);

		nums.add(o);

		o = new ArrayList<>();
		o.add(11);
		o.add(13);
		o.add(1);
		nums.add(o);
		System.out.println(findDiagonalOrder(nums));
		
	}

}
