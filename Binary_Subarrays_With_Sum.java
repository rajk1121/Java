import java.util.*;
/*
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?

 

Example 1:

Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation: 
The 4 subarrays are bolded below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]

 */
public class Binary_Subarrays_With_Sum {
	public int numSubarraysWithSum(int[] A, int S) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int ans= 0;
        int sum = 0;
        set.put(0, 1);
        for(int i=0 ; i<A.length ; i++){
            
                sum = sum+A[i];
            
                if(set.containsKey(sum-S))
                    ans = ans + set.get(sum-S);
            
                if(set.containsKey(sum)){
                    set.put(sum, set.get(sum)+1);
                }else{
                    set.put(sum, 1);
                }
            
        }
        return ans;   
    }
}
