import java.util.*;
/*
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */
public class next_pointer {
    public static Node connect(Node root) {
        Queue<Node> s = new LinkedList<>();
        if(root!=null){
            s.add(root);
        }
        int j=1;
        Node nexts = null;
        while(s.size()!=0){
            for(int i=0 ; i<j ; i++){
                Node temp = s.remove();
                if(nexts!=null){
                        nexts.next = temp;
                    }
                if(temp.left!=null){
                    
                        
                    s.add(temp.left);
                    s.add(temp.right);
                    
                    
                }
                nexts = temp;
            }
            nexts.next=null;
            nexts = null;
            j=j*2;
            
        }
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connect(new Node(5));
	}

}
