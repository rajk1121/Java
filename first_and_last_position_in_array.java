import java.util.*;
public class first_and_last_position_in_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,4,4,4,5,5,5,5,6,7,8,8,9,9,9,9,9,9,10};
		nums = searchRange(nums, 9);
		for(int i=0 ; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	 public static int[] searchRange(int[] nums, int target) {
	        int []arr = {-1,-1};
	        int low=0;
	        int high=nums.length-1;
	        while(low<=high){
	            int mid = (low+high)/2;
	            if(nums[mid]==target){
	                arr[0]=mid;
	                arr[1]=mid;
	                break;
	            }
	            if(nums[mid]< target){
	                low=mid+1;
	            }else{
	                high=mid-1;
	            }
	        }
	        if(arr[0]==-1 && arr[1]==-1){
	            return arr;
	        }else{
	             low=0;
	        high=arr[0]-1;
	        while(low<=high){
	            int mid = (low+high)/2;
	            if(nums[mid]==target && mid<=arr[0]){
	                arr[0]=mid;
	                high--;
	            }
	            else if(nums[mid]< target){
	                low=mid+1;
	            }else{
	                high=mid-1;
	            }
	        }
	                low=arr[1]+1;
	        high=nums.length-1;
	        while(low<=high){
	            int mid = (low+high)/2;
	            if(nums[mid]==target && mid>=arr[1]){
	                arr[1]=mid;
	                low++;
	            }
	            else if(nums[mid]< target){
	                low=mid+1;
	            }else{
	                high=mid-1;
	            }
	        }
	        }
	        return arr;
	        
	    }

}
