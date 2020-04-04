
public class maximal_Square {
	 public static int maximalSquare(char[][] matrix) {
	        int max = 0;
	        if(matrix.length==0)
	            return max;
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int[][] dp = new int[m][n];
	        for(int i=m-1 ; i>=0 ; i--){
	            for(int j = n-1 ; j>=0 ; j--){
	                if(j==n-1 || i==m-1){
	                    dp[i][j] = matrix[i][j]-'0';
	                    max = Math.max(max, dp[i][j]);
	                    
	                }
	                else{
	                    if(matrix[i][j]-'0'==0)
	                        dp[i][j] = 0;
	                    else{
	                        dp[i][j] = matrix[i+1][j]-'0'==1 && matrix[i+1][j+1]-'0'==1 && matrix[i][j+1]-'0'==1 ? Math.min( dp[i+1][j] , Math.min( dp[i][j+1] , dp[i+1][j+1]) )+1 : 1;
	                        max = Math.max(max, dp[i][j]);
	                    }
	                }
	            }
	        }
	        
	        return max*max;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] nums = {{'1','1', '1', '1', '1'}, {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'},{'1', '1', '1', '1', '1'}, {'0', '0', '0', '0', '0'}};
		System.out.println(maximalSquare(nums));
	}

}
