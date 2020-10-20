/*
 * 
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

    A[i] == B[j];
    The line we draw does not intersect any other connecting (non-horizontal) line.

Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.
 */
public class uncrossed_lines {
	 public int maxUncrossedLines(int[] A, int[] B) {
	        
	        int[][] dp = new int[B.length][A.length];
	        int a = A.length;
	        int b = B.length;
	        dp[b-1][a-1] = A[a-1]==B[b-1] ? 1 : 0;
	        int ans= 0;
	        for(int i=a-2 ; i>=0 ; i--){
	             if(A[i] == B[b-1])
	                 dp[b-1][i] = 1;
	            else
	                dp[b-1][i] = dp[b-1][i+1];
	            ans = Math.max(ans, dp[b-1][i]);
	    
	        }
	        for(int i=b-2 ; i>=0 ; i--){
	            if(A[a-1]==B[i])
	                dp[i][a-1] = 1;
	            else
	                dp[i][a-1] = dp[i+1][a-1];
	            
	            ans = Math.max(ans, dp[i][a-1]);
	        }
	        for(int i=a-2; i>=0 ;i--){
	            for(int j=b-2 ; j>=0 ; j--){
	                if(A[i]==B[j]){
	                    dp[j][i] = Math.max(dp[j+1][i], dp[j+1][i+1]+1);
	                }else{
	                    
	                    dp[j][i] = Math.max(dp[j+1][i], dp[j][i+1]);
	                }
	                ans = Math.max(ans, dp[j][i]);
	            }
	        }
	        return ans;

	    }
}
