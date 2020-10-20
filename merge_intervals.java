/*
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
import java.util.*;
class ArrNode{
    int[] arr;
    public ArrNode(int[] a){
        arr = a;
    }
}
class IntComp implements Comparator<ArrNode>{
    public int compare(ArrNode a, ArrNode b){
        return a.arr[0]-b.arr[0];
    }
}
class merge_intervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)
            return new int[0][0];
        PriorityQueue<ArrNode> q = new PriorityQueue<>(new IntComp());
        for(int i=0 ; i<intervals.length ; i++){
            ArrNode x = new ArrNode(intervals[i]);
            q.add(x);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        ArrNode x = q.remove();
        first.add(x.arr[0]);
        first.add(x.arr[1]);
        ans.add(first);
        while(q.size()!=0){
             x = q.remove();
            if(x.arr[0]<=ans.get(ans.size()-1).get(1)){
                ans.get(ans.size()-1).set(1, Math.max(x.arr[1] ,ans.get(ans.size()-1).get(1)));
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(x.arr[0]);
                temp.add(x.arr[1]);
                ans.add(temp);
            }
        }
        // System.out.println(ans);
        int[][] ArrAns = new int[ans.size()][2];
        for(int i=0 ; i<ans.size() ; i++){
            ArrAns[i][0] = ans.get(i).get(0);
            ArrAns[i][1] = ans.get(i).get(1);
        }
        return ArrAns;
    }
}