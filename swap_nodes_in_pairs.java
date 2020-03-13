import java.util.*;

public class swap_nodes_in_pairs {
	
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
	 
	
	    public static ListNode swapPairs(ListNode head) {
	        
	        if(head==null || head.next==null ){
	            return head;
	        }
	        ListNode p1 = head;
	        ListNode p2 = head.next;
	        ListNode p3 = p2.next;
	        head=p2;
	        while(true){
	        p2.next = p1;
	        if(p3==null || p3.next==null){
	            p1.next=p3;
	            break;
	        }else{
	            p1.next=p3.next;
	            p1=p3;
	            p2=p3.next;
	            p3=p2.next;
	        }
	        
	        }
	        return head;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		swap_nodes_in_pairs ref = new swap_nodes_in_pairs();
		ListNode head  = ref.new ListNode(5);
		head.next  = ref.new ListNode(4);
		head.next.next = ref.new ListNode(4);
		swapPairs(head);
		 

	}

}
