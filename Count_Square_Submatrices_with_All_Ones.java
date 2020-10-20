/*
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.

 */
public class Count_Square_Submatrices_with_All_Ones {
	 public int countSquares(int[][] matrix) {
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int[][] dp = new int[m][n];
	        int ans = 0;
	      
	        
	        for(int i=m-1 ; i>=0 ; i--){
	            for(int j=n-1 ;j>=0 ; j--){
	                if(i==m-1 || j==n-1){
	                    if(matrix[i][j]==1){
	                        dp[i][j] = 1;
	                        ans++;
	                    }
	                }
	                else if(matrix[i][j]==1){
	                    int sub = Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1])) + 1;
	                    ans = ans+sub;
	                    dp[i][j] = sub;
	                    
	                }
	            }
	        }
	        return ans;
	    }
}
