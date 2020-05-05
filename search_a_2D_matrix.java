/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.

 */
public class search_a_2D_matrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; 
        if(m==0)
            return false;
        int n = matrix[0].length;
        if(m>n){
            for(int i=0 ; i<n ; i++){
                if(matrix[0][i]<=target && matrix[m-1][i]>=target){
                    int low = 0;
                    int high = m-1;
                    while(low<=high){
                        int mid = (low+high)/2;
                        if(matrix[mid][i]==target)
                            return true;
                        if(matrix[mid][i]>target)
                            high = mid-1;
                        else
                            low = mid+1;
                    }
                }
                
            }
        }else{
            
            for(int i=0 ; i<m ; i++){
                if(matrix[i][0]<=target && matrix[i][n-1]>=target){
                    int low = 0;
                    int high = n-1;
                    while(low<=high){
                        int mid = (low+high)/2;
                        if(matrix[i][mid]==target)
                            return true;
                        if(matrix[i][mid]>target)
                            high = mid-1;
                        else
                            low = mid+1;
                    }
                }
            }
        }
        return false;
    }
}
