import java.util.HashSet;

public class element_more_than_N_div_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {2 ,2 ,3 ,1 ,3 ,2 ,1 ,1};
		int count1 = 0,count2 = 0,first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		for(int i=0 ; i<nums.length ; i++) {
			if(nums[i]==first) {
				count1++;
			}else if(nums[i]==second) {
				count2++;
			}else if(count1==0) {
				first = nums[i];
			}else if(count2==0) {
				second = nums[i];
			}else {
				count1--;
				count2--;
			}
		}
		count1=0;count2=0;
		for(int i=0 ; i<nums.length; i++) {
			if(nums[i]==first) {
				count1++;
			}else if(nums[i]==second)
				count2++;
		}
		if(count1>nums.length/3)
			System.out.println(first+" ");
		if(count2>nums.length/3)
			System.out.println(second);
		return;
	}

}
