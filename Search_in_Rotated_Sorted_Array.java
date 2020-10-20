import java.util.*;
public class Search_in_Rotated_Sorted_Array {
	 public static int search(int[] nums, int target) {
		   int low = 0;
	        int high = nums.length-1;
	        if(nums.length==0 || nums[low]>target && nums[high]<target){
	            return -1;
	        }
       if(nums.length==1){
           if(nums[0]==target){
               return 0;
           }else{
               return -1;
           }
       }
	        int ans=Integer.MAX_VALUE;
	        while(low<=high){
	            int mid = (low+high)/2;
	            if(target==nums[mid]){
	                    ans=mid;
	                break;
	        }
               if(nums[low]>nums[high]){
                   if(nums[low]<=nums[mid]){
                       if(target<nums[mid] && target>=nums[low])
                           high=mid-1;
                       else 
                           low=mid+1;
                   }else{
                       if(target>nums[mid] && target<=nums[high])
                           low=mid+1;
                       else
                           high=mid-1;
                   }
               }else{
                   if(target>nums[mid])
                       low=mid+1;
                   else
                       high=mid-1;
               }
	            
	    }
	        if(ans==Integer.MAX_VALUE)
	        	return -1;
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  nums = {3,1};
		int target = 1;
		System.out.println(search(nums, target));
	}

}
