/*
 * Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1

Example 2:

Input: 16
Output: true
Explanation: 24 = 16
 */
public class power_of_two {
	 public boolean isPowerOfTwo(int n) {
	        int ans = 0;
	        if(n<0)
	            return false;
	        while(n!=0){
	            int temp = n&1;
	            if(temp==1)
	                ans++;
	            n = n>>1;
	        }
	        return ans==1 ? true : false;
	    }
}
