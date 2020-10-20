/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.


 */
public class jump_game {

	public boolean canJump(int[] nums) {
        boolean [] canTake = new boolean[nums.length];
        canTake[nums.length-1] = true;
     boolean ans = find(nums, nums.length-1, canTake);
        return ans;
    }
    public boolean find(int[] nums, int start, boolean[] canTake){
        int latest = nums.length-1;
        if(latest==0){
            return true;
        }
        for(int i=nums.length - 2 ; i>=0  ; i--){
            if(nums[i]>=latest - i){
                canTake[i] = true;
                latest = i;
            }
        }
        return canTake[0];
    }
}
