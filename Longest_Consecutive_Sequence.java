import java.util.*;
import java.util.Map.Entry;
public class Longest_Consecutive_Sequence {
/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.


 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {100, 4, 200, 1, 3, 2};
		
        HashMap<Integer, Integer> set = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
        	 if(set.containsKey(nums[i]))
                 continue;
            if(set.containsKey(nums[i]-1) && set.containsKey(nums[i]+1)){
            	int count = set.get(nums[i]-1);
                int start = nums[i]-count;
                int countend = set.get(nums[i]+1);
                int end = nums[i]+countend;
                int newCount = count+countend+1;
                set.put(start, newCount);
                set.put(end, newCount);
                set.put(nums[i],newCount);
            }else if(set.containsKey(nums[i]-1)){
                int count = set.get(nums[i]-1);
                int start = nums[i]-count;
                set.put(start, count+1);
                set.put(nums[i]-1, count+1);
                set.put(nums[i], count+1);
            }else if(set.containsKey(nums[i]+1)){
            	int count = set.get(nums[i]+1);
                int start = nums[i]+count;
                set.put(start, count+1);
                set.put(nums[i]+1, count+1);
                set.put(nums[i], count+1);
            }else{
                set.put(nums[i], 1);
            }
        }
        int max= 0;
        for(Map.Entry<Integer, Integer> value: set.entrySet()) {
        	if(max<value.getValue())
        		max = value.getValue();
        }

	}

}
