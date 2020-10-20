
public class missing_number {
	 public static int missingNumber(int[] nums) {
	        boolean last = false, zero = false;
	        int n=  nums.length;
	        for(int i=0 ;i<n ; i++){
	            if(Math.abs(nums[i])==n)
	                last = true;
	            else if(nums[Math.abs(nums[i])]==0){
	                zero=true;
	            }else{
	                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
	            }
	        }
	        if(!last)
	            return n;
	        int ans =0;
	        for(int i=0 ; i<n ; i++){
	            if(nums[i]==0 && !zero)
	                return i;
	            if(nums[i]>0)
	                ans = i;
	        }
	        
	    return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1};
		System.out.println(missingNumber(nums));
	}

}
