import java.util.*;
public class longest_increasing_path {
	static int gMax = 0;
	    public static int longestIncreasingPath(int[][] matrix) {
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int[][] dp = new int[m][n];
	        boolean[][] recStack = new boolean[m][n];
	        boolean[][] visited = new boolean[m][n];
	        for(int i=0 ; i<m ; i++){
	            for(int j=0 ; j<n ; j++){
	                if(!visited[i][j]){
	                    System.out.println(i+" "+j);
	                    recStack[i][j] = true;
	                    int max = 1;
	                    if(isValid(i+1, j, m, n, recStack)){
	                        max = Math.max(max, 1 + process(i+1, j, m, n, recStack, visited, matrix, matrix[i][j], dp));
	                    }
	                    if(isValid(i-1, j, m, n, recStack)){
	                        max = Math.max(max, 1 + process(i-1, j, m, n, recStack, visited, matrix, matrix[i][j], dp));
	                    }
	                    if(isValid(i, j+1, m, n, recStack)){
	                        max = Math.max(max, 1 + process(i, j+1, m, n, recStack, visited, matrix, matrix[i][j], dp));
	                    }
	                    if(isValid(i, j-1, m, n, recStack)){
	                       max = Math.max(max, 1 + process(i, j-1, m, n, recStack, visited, matrix, matrix[i][j], dp));
	                    }
	                    dp[i][j] = max;
	                    gMax = Math.max(max, gMax);
	                    recStack[i][j] = false;
	                    visited[i][j]= true;
	                }
	            }
	        }
	        for(int i=0 ; i<m ; i++){
	            for(int j=0 ; j<n ; j++){
	                System.out.print(dp[i][j]+" ");
	                
	            }
	            System.out.println();
	        }
	        return gMax;
	    }
	    public static int process(int i, int j, int m, int n, boolean[][] recStack, boolean[][] visited, int[][] matrix, int parent, int[][] dp){
	        if(recStack[i][j]){
	            return 0;
	        }
	        
	        if(matrix[i][j]>parent){
	            if(visited[i][j]){
	                return dp[i][j];
	            }     
	            recStack[i][j] = true;
	            int max = 1;
	            if(isValid(i+1, j, m, n, recStack)){
	                max = Math.max(max, 1 + process(i+1, j, m, n, recStack, visited, matrix, matrix[i][j], dp));
	            }
	            if(isValid(i-1, j, m, n, recStack)){
	                max = Math.max(max, 1 + process(i-1, j, m, n, recStack, visited, matrix, matrix[i][j], dp));
	            }
	            if(isValid(i, j+1, m, n, recStack)){
	                max = Math.max(max, 1 + process(i, j+1, m, n, recStack, visited, matrix, matrix[i][j], dp));
	            }
	            if(isValid(i, j-1, m, n, recStack)){
	               max = Math.max(max, 1 + process(i, j-1, m, n, recStack, visited, matrix, matrix[i][j], dp));
	            }
	            dp[i][j] = max;
	            gMax = Math.max(max, gMax);
	            recStack[i][j] = false;
	            visited[i][j]= true;
	            
	        }else{
	            return 0;
	        }
	        
	        return dp[i][j];
	    }
	    public static boolean isValid(int i, int j, int m, int n, boolean[][] recStack){
	        
	        if(i>=0 && i<m && j>=0 && j<n){
	            if(recStack[i][j])
	                return false;
	            return true;
	        }
	        return false;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
		System.out.println(longestIncreasingPath(matrix));

	}

}
