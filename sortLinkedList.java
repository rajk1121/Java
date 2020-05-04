 import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class sortLinkedList {
	static int max  = Integer.MIN_VALUE;
	static int pos = 0;
	public static ListNode sortList(ListNode head) {
        if( head==null || head.next==null)
            return head;
//        System.out.println(head.val);
        ListNode p1,p2;
        p1 = head;
        p2 = head.next;
        while(p2!=null){
        	p2 = p2.next;
            if(p2!=null)
                p2 = p2.next;
            else
            	break;
        	p1 = p1.next;
            
        }
        p2 = p1.next;
        p1.next = null;
//        System.out.println(p2.val);
        ListNode x1 = sortList(head);
        ListNode x2 = sortList(p2);
        return merge(x1, x2);
    }
    public static ListNode merge(ListNode x1, ListNode x2){
        ListNode newHead = null;
        ListNode parent = null;
        if(x1.val<x2.val){
            newHead = x1;
            x1 = x1.next;
        }else{
            newHead = x2;
            x2 = x2.next;
        }
        parent = newHead;
        while(x1!=null && x2!=null){
            if(x1.val<x2.val){
                newHead.next = x1;
                x1 = x1.next;
                newHead = newHead.next;
            }else{
                
                newHead.next = x2;
                x2 = x2.next;
                newHead = newHead.next;
            }
        }
        while(x1!=null){
            newHead.next = x1;
            x1 = x1.next;
            newHead = newHead.next;
        }
        
        while(x2!=null){
            newHead.next = x2;
            x2 = x2.next;
            newHead = newHead.next;
        }
        return parent;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListNode x1 = new ListNode(4);
//		x1.next = new ListNode(2);
//		x1.next.next = new ListNode(1);
//		x1.next.next.next = new ListNode(3);
//		x1.next.next.next.next = new ListNode(0);
////		x1.next = new ListNode(2);
//		x1 = sortList(x1);
//		while(x1!=null) {
//			System.out.println(x1.val);
//			x1 = x1.next;
//		}
		int[][] mat  = {{1,10,10},{1,4,5},{2,3,6}};
		int k = 7;
        int ans = 0;
        int passed = 0;
        int row = mat.length;
        int col = 0;
        int arow = 0;
        while(true){
            System.out.println(Math.pow(mat[0].length, row-1));
            if(passed+(int)Math.pow(mat[0].length, row-1)>k){
                ans = ans+mat[arow][col];
                arow++;
                row--;
                col=0;
            }else if(passed+(int)Math.pow(mat[0].length, row-1)<k){
                passed = passed + (int)Math.pow(mat[0].length, row-1);
                col++;
            }else{
                ans = ans+mat[arow][col];
                break;
            }
        }
      System.out.println(ans);
	
	}
	
	

}
