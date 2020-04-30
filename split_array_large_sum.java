/*
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

    1 ≤ n ≤ 1000
    1 ≤ m ≤ min(50, n)

Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

 */
public class split_array_large_sum {
	 public int splitArray(int[] nums, int m) {
	        int n= nums.length;
	        int[] left = new int[n];
	        int[] right = new int[n];
	        left[0] = nums[0];
	        right[n-1] = nums[n-1];
	        
	        for(int i=1 ; i<nums.length ; i++)
	            left[i] = left[i-1]+nums[i];
	    
	        if(m>=nums.length){
	            int min = Integer.MIN_VALUE;
	            for(int i=0 ; i<nums.length ; i++)
	                min = Math.max(min, nums[i]);
	            return min;
	        }
	        int[][] dp = new int[m+1][nums.length];
	        for(int i=0 ; i<nums.length ; i++)
	            dp[1][i] = left[i];
	        for(int k=2 ; k<=m ; k++){
	            for(int i=k-1; i<nums.length ; i++){
	                int max = Integer.MAX_VALUE;
	                for(int j=k-2 ; j<i ; j++){
	                    max = Math.min(max, Math.max(dp[k-1][j], left[i]-left[j]));
	                }
	                dp[k][i]= max;
	            }
	        }
	        
	        return dp[m][nums.length-1];
	    }
}
