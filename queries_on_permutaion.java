
import java.util.*;
class DLL{
    class PNode{
    int data;
    PNode pre;
    PNode next;
        public PNode(int d, PNode p, PNode n){
            this.data = d;
            this.pre = p;
            this.next = n;
        }
    }
    List<Integer> ans;
    PNode head;
    PNode tail;
    HashMap<Integer, PNode> set ;
    public DLL(int m){
        set = new HashMap<>(); 
        ans = new ArrayList<>();
        head = new PNode(0, null, null);
        tail = new PNode(0, null, null);
        PNode node = head;
        for(int i=1 ; i<=m ; i++){
            if(i==1){
                PNode newNode = new PNode(i, head,null);
                set.put(i, newNode);
                head.next = newNode;
                node = newNode;
            }else if(i==m){
                PNode newNode = new PNode(i, node,tail);
                 set.put(i, newNode);
                 node.next=newNode;
                tail.pre = newNode;
            }else{
                PNode newNode = new PNode(i, node,null);
                 set.put(i, newNode);
                node.next = newNode;
                node = newNode;
                if(i==4) {
                }
            }
        }
        PNode n = head.next;
        while(n.data!=0) {
        	System.out.println(n.data+" "+n.pre.data+" "+n.next.data);
        	n=n.next;
        }
    }
    public int[] generate(){
    	
        int[] arr = new int[ans.size()];
//        PNode node = head.next;
        for(int i=0 ; i<ans.size() ; i++){
            arr[i]= ans.get(i);
        }
        return arr;
    }
    public void removeAndAdd(int data){
    	PNode node = head.next;
    	int index =0;
    	while(node.data!=data) {
//    		System.out.println(node.data);
    		node=node.next;
    		index++;
    	}
    	
//    	System.out.println(index);
//    	System.out.println("----------------------------");
    	ans.add(index);
    	if(index==0) {
    		return;
    	}
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
}
class queries_on_permutaion {
    public static int[] processQueries(int[] queries, int m) {
           
        DLL link = new DLL(m);
       
        for(int i=0 ; i<queries.length ; i++){
            link.removeAndAdd(queries[i]);
        }
        int[] arr =link.generate();
        return arr;
    }
    public static void main(String[] ar) {
    	int[] queries = {2,5,5,8,3};
    	int[] arr = processQueries(queries, 8);
    	for(int i=0 ; i<arr.length ; i++)
    		System.out.println(arr[i]);
    }
}