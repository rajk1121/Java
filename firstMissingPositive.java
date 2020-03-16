import java.util.*;
public class firstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=  {1,2,0};
		HashMap<Integer, Integer> set = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]>=1) {
            	set.put(nums[i],1);
            }
        }
        int i=1;
        while(true){
            if(!set.containsKey(i)){
                break;
            }else{
                i++;
            }
        }
        System.out.println(i);

	}

}
