/*
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 Note: Your solution should run in O(log n) time and O(1) space.
 */
public class search_unique_logN_sorted {
	 public int singleNonDuplicate(int[] nums) {
	        int left = 0;
	        int right = nums.length-1;
	        int ans = 0;
	        while(left<=right){
	            // System.out.println(left+" "+right);
	            int mid = (left+right)/2;
	            
	            if(mid!=nums.length -1 && nums[mid]==nums[mid+1]){
	                
	                if((mid+1)%2==0){
	                    right = mid-1;
	                }else{
	                    left = mid+1;
	                }
	            }else if(mid!=0 && nums[mid]==nums[mid-1]){
	                 if((mid+1)%2==0){
	                    left= mid+1;
	                }else{
	                    right=mid-1;
	                }
	            }else{
	                ans = nums[mid];
	                break;
	            }
	        }
	        return ans;
	    }
}
