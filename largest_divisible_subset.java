import java.util.*;
public class largest_divisible_subset {
	 public static List<Integer> largestDivisibleSubset(int[] nums) {
		  if(nums.length==0)
	            return new ArrayList<>();  
		 Arrays.sort(nums);
		    int maxLength =0;
		    int maxIndex = 0;
		    List<List<Integer>> answer = new ArrayList<>();
		    for(int i=0 ; i<nums.length ; i++) {
		    	int index =-1;
		    	int max = 0;
		    	for(int j=0 ; j<i ; j++) {
		    		if(nums[i]%nums[j]==0) {
		    			index = max<answer.get(j).size() ? j : index;
			    		max = Math.max(max, answer.get(j).size());
		    		}
		    	}
		    	if(index==-1) {
		    		List<Integer> x = new ArrayList<>();
		    		x.add(nums[i]);
		    		answer.add(i,x);
		    	}else {
		    		List<Integer> x = new ArrayList<>();
			    	x.addAll(answer.get(index));
			    	x.add(nums[i]);

		    		answer.add(i,x);
		    	}
		    	maxIndex = max>=maxLength?i:maxIndex;
		    	maxLength = Math.max(max, maxLength);
		    	
		    	
		    }
		    return answer.get(maxIndex);
//		    return a;
		        
		    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			int[] nums= {3,6,9,2,4,8,5,10,15,50};
			System.out.println(largestDivisibleSubset(nums));
	}

}
