/*
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b. 
 The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval. 
 For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 */
import java.util.*;
public class interval_list_intersections {
	 public static List<List<Integer>> intervalIntersection(int[][] A, int[][] B) {
	        int i=0, j=0;
	        List<List<Integer>> ans = new ArrayList<>();
	        while(i<A.length && j<B.length){
	            int sA = A[i][0];
	            int eA = A[i][1];
	            int sB = B[j][0];
	            int eB = B[j][1];
	            if(sB>=sA && sB<=eA){
	                List<Integer> ians = new ArrayList<>();
	                ians.add(sB);
	                if(eB>=eA){
	                    ians.add(Math.min(eB, eA));
	                    i++;
	                }else{
	                    ians.add(Math.min(eB, eA));
	                    j++;
	                }
	                ans.add(ians);
	            }else  if(sA>=sB && sA<=eB){
	                List<Integer> ians = new ArrayList<>();
	                ians.add(sA);
	                if(eA>=eB){
	                    ians.add(Math.min(eB, eA));
	                    j++;
	                }else{
	                    ians.add(Math.min(eB, eA));
	                    i++;
	                }
	                
	                ans.add(ians);
	            }else if(sA>eB) {
	            	j++;
	            }else {
	            	i++;
	            }
	            
	        }
	        return ans;
//	        int[][] arr = new int[ans.size()][2];
//	        for( i=0 ;i<ans.size(); i++){
//	            arr[i][0] = ans.get(i).get(0);
//	            arr[i][1] = ans.get(i).get(1);
//	        }
//	        return arr;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{0,2},{5,10},{13,23},{24,25}};
		int[][] B = {{1,5},{8,12},{15,24},{25,26}};
		System.out.println(intervalIntersection(A, B));
		
	}

}
