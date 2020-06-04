/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6


 */
import java.util.*;
class MergeComp implements Comparator<ListNode>{
    public int compare(ListNode a, ListNode b){
        return a.val - b.val;
    }
}
public class merge_k_sorted_lists {
	 public ListNode mergeKLists(ListNode[] lists) {
//       ListNode ans = new ListNode(0);
//       ListNode move = ans;
//       while(true){
//           int index = 0;
//           int min = Integer.MAX_VALUE;
//           boolean found = false;
//           for(int i=0 ; i<lists.length ; i++){
//               if(lists[i]!=null){
//                   found = true;
//                   if(min>=lists[i].val){
//                       index = i;
//                       min = lists[i].val;
//                   }
//               }
//           }
//           if(!found)
//               break;
          
//           move.next = lists[index];
//           move = move.next;
//           lists[index] = lists[index].next;
          
//       }
//       move.next = null;
//       return ans.next;
      PriorityQueue<ListNode> q = new PriorityQueue<>(new MergeComp());
      for(int i=0 ; i<lists.length; i++){
          ListNode x = lists[i];
          while(x!=null){
              q.add(x);
              x = x.next;
          }
      }
      // System.out.println(q.size());
      if(q.size()>=1){
      ListNode ans = q.remove();
      ListNode move = ans;
      while(q.size()!=0){
          move.next = q.remove();
          move = move.next;
      }
          move.next = null;
      return ans;
      }
      return null;
      
  }
}
