import java.util.*;
public class reverse_Node_in_k_Group {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	 public static ListNode reverseKGroup(ListNode head, int k) {
	        int i=0;
	        ListNode ref =head;
	        while(ref!=null){
	            i++;
	            ref = ref.next;
	        }
	        System.out.println(i);
	        head = reverse(head, k,0, i);
	        return head;
	        
	    }
	    public static ListNode reverse(ListNode head, int k, int processed, int total){
	        if(total-processed<k || head==null){
	            System.out.println("base "+head.val);
	            return head;
	        }
	        int i=1;
	        ListNode p1 = head;
	        ListNode p2= head.next;
	        ListNode p3= p2.next;
	        if(k==1){
	            return head;
	        }
	        while(i<k){
	            p2.next = p1;
	            System.out.println(p1.val+" "+p2.val);
	            i++;
	            p1=p2;
	            p2=p3;
	            if(p2==null){
	                break;
	            }
	            p3=p3.next;
	            
	        }
	        processed+=k;
	        head.next = reverse(p2, k, processed,total);
	        
	            System.out.println(head.val+" old  head");
	            System.out.println(p1.val+" new head");
	        return p1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse_Node_in_k_Group ref = new reverse_Node_in_k_Group();
		ListNode head = ref.new ListNode(1);
		head.next = ref.new ListNode(2);
		head.next.next = ref.new ListNode(3);
		head.next.next.next = ref.new ListNode(4);
		head.next.next.next.next = ref.new ListNode(5);
		reverseKGroup(head, 2);
		
	}

}
