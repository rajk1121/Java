/*
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

    Return true if there exists i, j, k
    such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.

Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true

Example 2:

Input: [5,4,3,2,1]
Output: false


 */
public class longest_triplet_subsequence {
	  public boolean increasingTriplet(int[] nums) {
	        if(nums.length<3)
	            return false;
	        int min = nums[0];
	        int max = 0;
	        int i=1;
	        while(i<nums.length){
	            if(nums[i]>min){
	                max = nums[i];
	                break;
	            }
	            min = nums[i];
	            i++;
	        }
	        if(i==nums.length)
	            return false;
	        for( ; i<nums.length ; i++){
	            if(nums[i]>max)
	                return true;
	            if(nums[i]<min)
	                min = nums[i];
	            else if(nums[i]>min && nums[i]<max)
	                max = nums[i];
	                
	        }
	        return false;
	    }
}
