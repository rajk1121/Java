/*
 * Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5


 */
public class remove_linked_list_elements {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	    public ListNode removeElements(ListNode head, int val) {
	        if(head==null)
	            return head;
	        while(head!=null &&head.val==val){
	            head = head.next;
	        }
	        ListNode node = head;
	        while(node !=null && node.next!=null){
	            if(node.next.val==val){
	                node.next = node.next.next;
	                
	            }else{
	                
	            node = node.next;
	            }
	        }
	        return head;
	    }
	
}
