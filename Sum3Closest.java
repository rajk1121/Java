import java.util.*;
public class Sum3Closest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,4,8,16,32,64,128};
		int target = 82;
		System.out.println(threeSumClosest(nums, target));

	}
	 public static int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
	       
        int sum=nums[0]+nums[1]+nums[2];
	        for(int i=0 ; i<nums.length ; i++){
	            int j=i+1;
	            int k=nums.length-1;
	            while(j<k){
	                    
	                    
	                        int isum = nums[j]+nums[k]+nums[i];
//	                        System.out.println(Math.abs(target-isum));
//	                        System.out.println(Math.abs(target-sum));
	                        if(isum==target) {
	                        	System.out.println(target);
	                        }
	                        if(Math.abs(isum-target) <= Math.abs(sum-target) || target==isum){
                                sum=isum;
//                               if(j+1<k) {
                            	   if(isum<target) {
                            		   j++;
                            	   }else {
                            		   k--;
                            	   }
//                               }
                            }
	                        else if(isum<target) {
	                        	j++;
	                        }
	                         else{
	                            k--;
	                        }
	                        
	                }
	            }
	        
	        return sum;
        
    }

}
