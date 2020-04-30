import java.util.*;
/*
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */
public class Four_sum_II {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> set1 = new HashMap<>();
        HashMap<Integer, Integer> set2 = new HashMap<>();
        for(int i=0 ;i<A.length ; i++){
            for(int j=0 ; j<B.length ; j++){
                int sum = A[i]+B[j];
                if(set1.containsKey(sum)){
                    set1.put(sum, set1.get(sum)+1);
                }else{
                    set1.put(sum, 1);
                }
            }
        }
        for(int i=0 ;i<C.length ; i++){
            for(int j=0 ; j<D.length ; j++){
                int sum = C[i]+D[j];
                if(set2.containsKey(sum)){
                    set2.put(sum, set2.get(sum)+1);
                }else{
                    set2.put(sum, 1);
                }
            }
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> so : set1.entrySet()){
            int sum = -so.getKey();
            if(set2.containsKey(sum)){
                ans = ans + so.getValue()*set2.get(sum);
            }
        }
        return ans;
    }
}
