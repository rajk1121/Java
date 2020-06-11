/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2

Example 2:

Input: [1,3,5,6], 2
Output: 1

 */
public class search_insert_position {
	public int searchInsert(int[] nums, int target) {
        if(nums.length==0)
            return 0;
        int l = 0;
        int h = nums.length-1;
        int mid=0;
        while(l<=h){
            System.out.println(l+" "+h+" "+mid);
            mid = (l+h)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
            System.out.println(l+" "+h+" "+mid);
        if(nums[mid]>target){
            return mid;
        }else{
            return mid+1;
        }
    }
}
