import java.util.*;
public class bunary_strings_without_1 {
/*Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.

Examples:

Input:  N = 2
Output: 3
// The 3 strings are 00, 01, 10

Input: N = 3
Output: 5
// The 5 strings are 000, 001, 010, 100, 101
 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 43;
		int [][]dp = new int[n][2];
		if(n==0)
			System.out.println(0);
		else {
			dp[0][0] = 1;
			dp[0][1] = 1;
			for(int i=1 ; i<n ; i++) {
				dp[i][0] = dp[i-1][0]+dp[i-1][1];
				dp[i][1] = dp[i-1][0];
			}
			System.out.println(dp[dp.length-1][0]+dp[dp.length-1][1]);
		}
	}

}
