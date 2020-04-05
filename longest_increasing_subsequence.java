/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

Note:

    There may be more than one LIS combination, it is only necessary for you to return the length.
    Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

 */
public class longest_increasing_subsequence {
	public static int lengthOfLIS(int[] nums) {
		if(nums.length==0) return 0;
		int[] arr= new int[nums.length];
		int n=  nums.length;
		arr[0] = 1;
		int answer = 1;
		for(int i=1 ; i<n ; i++) {
			int max = 0;
			for(int j=0 ; j< i ;j++) {
				if(nums[i]>nums[j]) {
					max = Math.max(max,  arr[j]+1);
				}
			}
			arr[i] = Math.max(max, 1);
			answer = Math.max(answer, max);
		}
//		for(int i=0 ; i<n ; i++)
//			System.out.println(arr[i]);
			
		return answer;
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));

	}

}
