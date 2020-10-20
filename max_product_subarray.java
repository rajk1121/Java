
public class max_product_subarray {
	 public static int maxProduct(int[] nums) {
	        if(nums.length==0)
	            return 0;
	        int[] prefix = new int[nums.length];
	        int[] index = new int[nums.length];
	        prefix[0] = nums[0];
	        index[0] = 0;
	        for(int i=1  ;i<nums.length ;i++){
	            if(prefix[i-1] == 0){
	                prefix[i] = nums[i];
	                index[i] = i;
	            }else{
	                index[i] = index[i-1];
	                prefix[i] = prefix[i-1]*nums[i];
	            }
	        }
	        int max = prefix[0];
	        for(int i=1 ; i<nums.length ;i++){
	            if(prefix[i]==0){
	                if(max<0)
	                    max = 0;
	                
	            }
	            
	           else{
	               if(prefix[i]>max){
	                max = prefix[i];
	            }
	            else{
	                for(int j=index[i] ; j<i ; j++){
	                    int imax = prefix[i]/prefix[j];
	                    if(imax>max)
	                        max = imax;
	                }
	            }
	           }
	        }
	        return max;
	    }
	   public static int DPmaxProduct(int[] nums) {
	        if(nums.length==0)
	            return 0;
	        int current_max = nums[0];
	        int current_min = nums[0];
	        int final_max=  nums[0];
	        for(int i=1 ; i<nums.length ; i++){
	            int temp =current_max;
	            current_max= Math.max(Math.max(current_max*nums[i], current_min*nums[i]), nums[i]);
	            current_min = Math.min(Math.min(temp*nums[i], current_min*nums[i]), nums[i]);
	            if(final_max<current_max)
	                final_max = current_max;
	        }
	        return final_max;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,0,-1};
		System.out.println(maxProduct(nums));
		System.out.println(DPmaxProduct(nums));
	}

}
