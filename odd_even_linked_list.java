
public class odd_even_linked_list {
	public ListNode oddEvenList(ListNode head) {
	      if(head==null)
	          return null;
	        ListNode nHead = head;
	        ListNode x = nHead.next;
	        ListNode nX = x;
	        int i=0;
	        // System.out.println(nX.val+" "+nHead.val);
	        while(nHead.next!=null && nX.next!=null){
	            nHead.next = nX.next;
	            nHead = nHead.next;
	            nX.next = nHead.next;
	            nX = nX.next;
	            
	        // System.out.println(nX.val+" "+nHead.val);
	          
	        }
	        nHead.next = x;
	        return head;
	        
	    }
}
