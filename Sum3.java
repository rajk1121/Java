import java.util.*;
public class Sum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,-2,-1};
		 List<List<Integer>> ans  = threeSum(nums);
		 System.out.println(ans);
	}
	  public static List<List<Integer>> threeSum(int[] nums) {
		  Arrays.sort(nums);
	        List<List<Integer>> answer = new ArrayList<>();
	        HashMap<String, Integer> set = new HashMap<>();
	        for(int i=0 ; i<nums.length ; i++){
	            int j=i+1;
	            int k=nums.length-1;
	            while(j<k){
	                    
	                    
	                        int sum = nums[j]+nums[k];
	                        if(sum==-nums[i]){
	                            if(set.containsKey(nums[i]+":"+nums[j]+":"+nums[k])){
	                               continue; 
	                            }
	                           List<Integer> ianswer = new ArrayList<>();
	                           
	                            ianswer.add(nums[i]);
	                            ianswer.add(nums[j]);
	                            ianswer.add(nums[k]);
	                            answer.add(ianswer);
	                            String str =  nums[i]+":"+nums[j]+":"+nums[k];
	                            set.put(str,1);
	                            j++;
	                            k--;
	                            
	                        }else if(sum<-nums[i]){
	                            j++;
	                        }else{   
	                            k--;
	                        }
	                        
	                }
	            }
	        
	        return answer;
	    }

}
