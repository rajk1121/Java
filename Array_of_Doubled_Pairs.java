/*
 * Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.

 

Example 1:

Input: [3,1,3,6]
Output: false

Example 2:

Input: [2,1,2,6]
Output: false

Example 3:

Input: [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].

 */
import java.util.*;
public class Array_of_Doubled_Pairs {
	 public boolean canReorderDoubled(int[] A) {
	        HashMap<Integer, Integer> set = new HashMap<>();
	        Arrays.sort(A);
	        for(int i=0 ; i<A.length ; i++){
	           // System.out.println(A[i]);
	                if(set.containsKey(A[i]/2) && A[i]%2==0){
	                    int occ = set.get(A[i]/2);
	                    if(occ==1)
	                         set.remove(A[i]/2);
	                    else
	                        set.put(A[i]/2, occ-1);
	                    // System.out.println(set);
	                }else if(set.containsKey(2*A[i])){
	                    int occ = set.get(2*A[i]);
	                    if(occ==1)
	                         set.remove(2*A[i]);
	                    else
	                        set.put(2*A[i], occ-1);
	                    // System.out.println(set);
	                }else{
	                    if(set.containsKey(A[i]))
	                        set.put(A[i], set.get(A[i])+1);
	                    else
	                        set.put(A[i], 1);
	                    // System.out.println(set);
	                }
	            
	        }
	        // System.out.print(set);
	        if(set.size()==0)
	            return true;
	        return false;
	    }
}
