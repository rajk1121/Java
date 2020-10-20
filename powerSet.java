/*
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
import java.util.*;
public class powerSet {
	   public static List<List<Integer>> subsets(int[] nums) {
	        HashSet<String> gSet = new HashSet<>();
			return generate(nums, 0, gSet);
	    }
	   public static List<List<Integer>> generate(int[] nums, int i, HashSet<String> gSet) {
	        if(i==nums.length){
	            List<List<Integer>> ans = new ArrayList<>();
	            List<Integer> temp = new ArrayList<>();
	            ans.add(temp);
//	            System.out.println(ans.size());
	            return ans;
	        }
	        List<List<Integer>> ians = generate(nums, i+1, gSet);
	        List<List<Integer>> ans = new ArrayList<>();
	        for(int j = 0 ; j<ians.size() ; j++){
	            ans.add(ians.get(j));
	            List<Integer> temp = new ArrayList<>(ians.get(j));
	            temp.add(0,nums[i]);
//	            if(!gSet.contains(temp.toString())){
                   ans.add(temp);
                   gSet.add(temp.toString());
//               }
	        }
	        return ans;
	    
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=  {1,3,3,2};
		
		System.out.println(subsets(nums));

	}

}
