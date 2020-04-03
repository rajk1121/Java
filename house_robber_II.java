
public class house_robber_II {
	  public static int rob(int[] nums) {
	        int n= nums.length;
	        if(n==0)
	            return 0;
	        else if(n==1) return nums[0];
	        
	        int[] answer= new int[n];
	        boolean[] includedLast = new boolean[n];
	        answer[n-1] = nums[n-1];
	        includedLast[n-1]= true;
	        if(nums[n-2]>=nums[n-1]){
	            answer[n-2] = nums[n-2];
	            includedLast[n-2] = false;
	        }else{
	            answer[n-2] = answer[n-1];
	            includedLast[n-2] = true;
	        }
	        for(int i=n-3 ; i>=0 ; i--){
	            if(nums[i]+answer[i+2]>=answer[i+1]){
	                if(nums[i]+answer[i+2]==answer[i+1]){
	                    if(!includedLast[i+1]){
	                        answer[i] = answer[i+1];
	                        includedLast[i] = includedLast[i+1];
	                    }else{
	                        answer[i] = answer[i+1];
	                        includedLast[i] = includedLast[i+2];
	                    }
	                }else{
	                answer[i] = nums[i]+answer[i+2];
	                includedLast[i] = includedLast[i+2];
	                }
	            }else {
	                answer[i] = answer[i+1];
	                includedLast[i] = includedLast[i+1];
	            }
	        }
	        if(includedLast[0] ){
	            if(n==2){
	                return Math.max(nums[0],nums[1]);
	            }
	            int max = answer[1];
	            answer[n-2] = nums[n-2];
	            if(nums[n-3]>nums[n-2]){
	                answer[n-3] = nums[n-3];
	            }else{
	                answer[n-3] = answer[n-2];
	            }
	            for(int i=n-4 ; i>=0 ; i--){
//	            	System.out.println(nums[i]+" "+answer[i+1]+" "+answer[i+2]);
	            if(nums[i]+answer[i+2]>answer[i+1]){
	                answer[i] = nums[i]+answer[i+2];
	            }else{
	                answer[i] = answer[i+1];
	            }
	        }
	            for(int i=0 ; i<n-1 ; i++)
	            	System.out.println(answer[i]);
	            return Math.max(max, answer[0]);
	        }
	            
	        else
	            return answer[0];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {8,2,8,9,2};
		System.out.println(rob(nums));

	}

}
