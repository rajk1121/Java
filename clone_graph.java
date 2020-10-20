import java.util.*;

class GraphNode {
 public int val;
 public List<GraphNode> neighbors;
 
 public GraphNode() {
     val = 0;
     neighbors = new ArrayList<GraphNode>();
 }
 
 public GraphNode(int _val) {
     val = _val;
     neighbors = new ArrayList<GraphNode>();
 }
 
 public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
     val = _val;
     neighbors = _neighbors;
 }
}


public class clone_graph {

	 public GraphNode cloneGraph(GraphNode node) {
	     
	     // System.out.println(node.val);
	    if( node==null )
	        return null;
	     GraphNode n = new GraphNode(node.val);
	     HashMap<Integer,List<GraphNode>> set = new HashMap<>();
	     HashMap<GraphNode, Integer> include = new HashMap<>();
	     
	     Queue<GraphNode> q1 = new LinkedList<>();
	     Queue<GraphNode> q2 = new LinkedList<>();
	     q1.add(node);
	     q2.add(n);
	     List<GraphNode> t = new ArrayList();
	     t.add(node);
	     t.add(n);
	     set.put(n.val, t);
	     while(q1.size()!=0){
	         GraphNode p = q1.remove();
	         GraphNode q = q2.remove();
	         // System.out.println(p  + " "+q);
	         if(!include.containsKey(p.val)){
	             // System.out.println(q.val+" ***********");
	             for(int i=0 ; i<p.neighbors.size() ; i++){
	                 // if(p.neighbors.get(i).val==3 && set.containsKey(3)){
	                 //     System.out.println(set.get(p.neighbors.get(i).val).get(1));
	                 // }
	                 if(set.containsKey(p.neighbors.get(i).val)){
	                     GraphNode a = set.get(p.neighbors.get(i).val).get(1);
	                     q.neighbors.add(a);
	                 }else{
	                     GraphNode a = new GraphNode(p.neighbors.get(i).val);
	                     // if(a.val==3){
	                     //     System.out.println(a);
	                     // }
	                     q.neighbors.add(a);
	                     q1.add(p.neighbors.get(i));
	                     q2.add(a);
	                     if(!set.containsKey(a.val)){
	                         
	                         List<GraphNode> temp = new ArrayList<>();
	                         temp.add(p.neighbors.get(i));
	                         temp.add(a);
	                         set.put(a.val,temp);
	                     }
	                 }
	                 
	             // System.out.println(a.val);
	             }
	             include.put(p,1);
	         }
	         
	     }
	    
	     return n;
	 }

}
