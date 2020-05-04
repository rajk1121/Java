import java.util.*;
public class kth_smallest_element_in_sorted_matrix {
	  public int kthSmallest(int[][] matrix, int k) {
	        int m = matrix.length;
	        int n = matrix[0].length;
	        PriorityQueue<Integer> q = new PriorityQueue<>();
	        for(int i=0; i<m ; i++){
	            for(int j=0 ; j<n ; j++)
	                q.add(matrix[i][j]);
	        }
	        for(int i=0 ; i<k-1 ; i++){
	            q.remove();
	        }
	        return q.remove();
	    }
}
