import java.util.*;
//Given a linked list, remove the n-th node from the end of list and return its head.
public class Nth_node_from_last {
	 class ListNode {
		      int val;
		      ListNode next;
		     ListNode(int x) { val = x; }
	}
		 
	
public static void main(String[] args) {
	// TODO Auto-generated method stub
	Nth_node_from_last ref = new Nth_node_from_last();
	ListNode head  = ref.new ListNode(5);
	head.next  = ref.new ListNode(4);
	head.next.next = ref.new ListNode(4);
	System.out.println(removeNthFromEnd(head, 2));
	 

}
		    public static ListNode removeNthFromEnd(ListNode head, int n) {
		        int i=0;
		        ListNode sol = head;
		        ListNode ref= head;
		        if(head.next==null){
		            return null;
		        }
		        while(i<n){
		            head = head.next;
		            i++;
		        }
		        if(head==null){
		            ref = ref.next;
		            return ref;
		        }
		        while(head.next!=null){
		            head = head.next;
		            sol = sol.next;
		        }
		        sol.next = sol.next.next;
		        return ref;
		    }


}
