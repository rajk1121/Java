import java.util.*;
public class Sum4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-2,-1,0,0,1,2};
		int target = 0;
		System.out.println(fourSum(nums, target));
	}
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		  Arrays.sort(nums);
	         List<List<Integer>> answer = new ArrayList<>();
	        HashMap<String, Integer> set = new HashMap<>();
	        for(int i=0 ; i<nums.length ; i++){
	          for(int j=i+1 ; j<nums.length-1 ; j++){
	           int k=j+1;
	              int l=nums.length-1;
	          
	            while(k<l){
	               int sum = nums[i]+nums[j]+nums[k]+nums[l];
	                if(sum<target){
	                    k++;
	                }else if(sum>target)
	                    l--;
	                else{
	                    String str = nums[i]+":"+nums[j]+":"+nums[k]+":"+nums[l];
	                    if(set.containsKey(str)){
	                        k++;
	                        l--;
	                        continue;
	                    }
	                    List<Integer> ianswer=new ArrayList<>();
	                        ianswer.add(nums[i]);
	                        ianswer.add(nums[j]);
	                        ianswer.add(nums[k]);
	                        ianswer.add(nums[l]);
	                        answer.add(ianswer);
	                    set.put(str,1);
	                     k++;
	                        l--;
	                }
	            }
	          }     
	        }
	        return answer;

   }

}
