import java.util.*;
/*
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 */
public class next_permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,2,1};
		boolean found=  false;
		int i;
		for(i=nums.length-2 ; i>=0 ; i--) {
			if(nums[i]<nums[i+1]) {
				int maxsofar=i+1;
				for(int j=i+1 ; j<nums.length ; j++) {
					if(nums[j]<=nums[maxsofar] && nums[j]>nums[i]) {
					maxsofar = j;	
					}
				}
				int temp  =nums[maxsofar];
				nums[maxsofar]=nums[i];
				nums[i]=temp;
				found=true;
				break;
			}
		}
		System.out.println(i);
		i++;
		int j=nums.length-1;
		int limit = (i+j)/2;
		for(int k=i ; k<=limit ; k++) {
			System.out.println(nums[k]+" "+nums[j]);
			int temp = nums[k];
//			System.out.println(j-k);
			nums[k] = nums[j];
			nums[j] = temp;
			j--;
		}
		for(int k=0 ; k<nums.length ; k++) {
			System.out.print(nums[k]+" ");
		}

	}
	

}
