/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"

Example 2:

Input: [3,30,34,5,9]
Output: "9534330"

Note: The result may be very large, so you need to return a string instead of an integer.

 */
import java.util.*;
class LNode{
    int x;
    public LNode(int a){
        x = a;
    }
}
class Comp implements Comparator<LNode>{
    public int compare(LNode p, LNode q){
        // System.out.println(p.x+" "+q.x);
        String x ="" + p.x;
        String y ="" + q.x;
        return (y+x).compareTo(x+y);
    }
}
class largest_number {
    public String largestNumber(int[] nums) {
        List<LNode> l=new ArrayList();
        for(int i=0; i<nums.length; i++){
            LNode a=new LNode(nums[i]);
            l.add(a);
        }
        String ans = "";
        Collections.sort(l, new Comp());
       
        if(l.size()>0 && l.get(0).x==0)
            return "0";
        for(int i=0; i<nums.length; i++){
            
            ans = ans + l.get(i).x;
        }
            
    return ans;
    }
}