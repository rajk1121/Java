/*
 * Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
 */
public class max_consecutive_ones_1 {
	public int findMaxConsecutiveOnes(int[] arr) {
        int ans = 0, i=0;
       while(true){
           int iAns = 0;
           while(i<arr.length){
               if(arr[i]==1){
                   iAns++;
                   i++;
               }else{
                   break;
               }
           }
           ans = Math.max(ans, iAns);
           while(i<arr.length){
               if(arr[i]==0){
                   i++;
               }else{
                   // i--;
                   break;
               }
           }
           // System.out.println(ans+" "+i);
           if(i==arr.length)
               break;
       }
       return ans;
   }
}
