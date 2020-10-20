import java.util.*;
public class Find_Minimum_in_Rotated_Sorted_Array {
	 public static int findMin(int[] nums) {
         int low = 0;
	        int high = nums.length-1;
	        if(nums.length==0 ){
	            return -1;
	        }
       if(nums.length==1){
          return nums[0];
       }
	        int ans=Integer.MAX_VALUE;
	        while(low<=high){
	            int mid = (low+high)/2;
	           if(nums[mid]<ans) {
	        	   ans=nums[mid];
	        	   System.out.println("/////"+nums[mid]);
	           }
               if(nums[low]>nums[high]){
                  if(nums[mid]<nums[high])
                      high=mid-1;
                   else
                       low=mid+1;
               }else{
                   if(nums[low]<ans) {
                	   ans=nums[low];
                   }
                   break;
               }
	            
	    }
	       
	        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {6,7,8,9,10,0,1,2,3,4,5};
		System.out.println(findMin(nums));
	}

}
