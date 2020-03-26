import java.util.*;
public class left_view {
	 public static List<Integer> rightSideView(Node root) {
	        Queue<Node> q = new LinkedList<>();
	        if(root==null)
	            return new ArrayList<>();
	        
	        int i=1;
	        List<Integer> answer= new ArrayList<>();
	        q.add(root);
	        while(q.size()!=0){
	            int j=0;
	            for(int k=0 ; k<i-1 ; k++){
	                Node temp  =q.remove();
	                
	                if(temp.left!=null){
	                    j++;
	                    q.add(temp.left);
	                }
	                
	                if(temp.right!=null){
	                    j++;
	                    q.add(temp.right);
	                }
	            }
	            Node temp = q.remove();
	                if(temp.left!=null){
	                    j++;
	                    q.add(temp.left);
	                }
	                
	                if(temp.right!=null){
	                    j++;
	                    q.add(temp.right);
	                }
	            answer.add(temp.val);
	            i = j;
	            
	        }
	        return answer;
	    }
	

}
