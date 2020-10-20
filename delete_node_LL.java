/*
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following
 */
public class delete_node_LL {
	public void deleteNode(ListNode node) {
        while(node.next.next!=null){
            node.val=node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next= null;
    }

}
