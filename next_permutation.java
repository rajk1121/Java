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
					if(nums[j]<nums[maxsofar] && nums[j]>nums[i]) {
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
//		System.out.println(i+"sdsd");
		int[] sor = mergeSort(nums, ++i, nums.length-1);
		for(int j=0;i<nums.length;i++,j++) {
			nums[i] =sor[j]; 
		}
		for(int j=0 ; j<nums.length ; j++) {
			System.out.print(nums[j]+" ");
		}

	}
	public static int[] mergeSort(int[] arr ,int  low ,int   high) {
		if(low==high) {
			int[] base=new int[1];
			base[0]=arr[low];
			return base;
		}
		int mid=(low+high)/2;
		int[]one=mergeSort(arr , low , mid);
		int[] two = mergeSort(arr , mid+1, high);
		int[] sorted = merge(one , two);
		return sorted;
	}
	public static int[] merge(int[] one , int[] two) {
		
		
		int i=0 ;
		int j=0;
		int k=0;
		int[] three=new int[one.length+two.length];
		while(i<one.length && j<two.length) {
			if(one[i]<=two[j]) {
				three[k]=one[i];
				i++;
				
			}
			else {
				three[k]=two[j];
				j++;
				
			}
			k++;
			
		}
		while(i<one.length) {
			
				three[k]=one[i];
				i++;
				k++;
			
		}
		while(j<two.length) {
			three[k]=two[j];
			j++;
			k++;
		}
		return three;
	}

}
