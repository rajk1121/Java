/*
 * Given an array of integers arr and an integer k.

A value arr[i] is said to be stronger than a value arr[j] if |arr[i] - m| > |arr[j] - m| where m is the median of the array.
If |arr[i] - m| == |arr[j] - m|, then arr[i] is said to be stronger than arr[j] if arr[i] > arr[j].

Return a list of the strongest k values in the array. return the answer in any arbitrary order.

Median is the middle value in an ordered integer list. More formally, if the length of the list is n, the median is the element in position ((n - 1) / 2) in the sorted list (0-indexed).

    For arr = [6, -3, 7, 2, 11], n = 5 and the median is obtained by sorting the array arr = [-3, 2, 6, 7, 11] and the median is arr[m] where m = ((5 - 1) / 2) = 2. The median is 6.
    For arr = [-7, 22, 17, 3], n = 4 and the median is obtained by sorting the array arr = [-7, 3, 17, 22] and the median is arr[m] where m = ((4 - 1) / 2) = 1. The median is 3.

 

Example 1:

Input: arr = [1,2,3,4,5], k = 2
Output: [5,1]
Explanation: Median is 3, the elements of the array sorted by the strongest are [5,1,4,2,3]. The strongest 2 elements are [5, 1]. [1, 5] is also accepted answer.
Please note that although |5 - 3| == |1 - 3| but 5 is stronger than 1 because 5 > 1
 */
import java.util.*;
class StrongNode{
    int x;
    public StrongNode(int a){
        x = a;
    }
}
class StrongComp implements Comparator<StrongNode>{
    private int median;
    public StrongComp(int m){
        median = m;
    }
    public int compare(StrongNode a, StrongNode b){
        if(Math.abs(a.x - median) > Math.abs(b.x - median))
            return 5;
        if(Math.abs(a.x - median) < Math.abs(b.x - median))
            return -1;
        else{
            return a.x - b.x;
        }
    }
}
class k_Strongest_Values_in_an_Array {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int median = (arr.length - 1)/2;
        median = arr[median];
        List<StrongNode> list = new ArrayList<>();
        for(int i=0 ; i<arr.length ; i++){
            StrongNode a = new StrongNode(arr[i]);
            list.add(a);
        }
        Collections.sort(list, new StrongComp(median));
        int[] ans = new int[k];
        int i = 0;
        while(i<k){
            ans[i] = list.get(list.size() - 1 - i).x;
            i++;
        }
        return ans;
    }
}
