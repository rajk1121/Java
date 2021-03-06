import java.util.Collection;

/*
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 � 1 = 1.

Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 � 3 � 4 = 36.

Note: You may assume that n is not less than 2 and not larger than 58.

 */
import java.util.*;
public class Integer_Break {
	public static int integerBreak(int n) {
	    
		if(n==0 || n==1)
			return 1;
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		dp[2]=1;
		for(int i=3 ; i<=n ; i++) {
			for(int j=1 ; j<i ; j++) {
				dp[i] = Math.max(dp[i], Math.max(j*dp[i-j], j*(i-j)));
			}
		}
//		for(int i=0 ; i<=n ; i++)System.out.print(dp[i]+" ");
//		Collections.sort(arg0, arg1);
		return dp[n];
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(integerBreak(2));
	}

}
