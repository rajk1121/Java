/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

 */
public class search_a_2d_matrix_II {
	public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        if(matrix.length==0 || matrix[0].length==0)
            return false;
        for( ; row<matrix.length ; row++){
            if(matrix[row][0]<=target && matrix[row][matrix[0].length-1]>=target){
                break;
            }
        }
        if(row==matrix.length)
            return false;
        for(int i=0 ; i<matrix[0].length ; i++){
            if(matrix[row][i]==target)
                return true;
        }
        return false;
    }
}
