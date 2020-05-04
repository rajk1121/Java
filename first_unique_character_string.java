import java.util.*;
class FNode{
    int index;
    int val;
    FNode(int i, int v){
        index=i;
        val=v;
    }
}
class FNodeCom implements Comparator<FNode>{
    public int compare(FNode a, FNode b){
        if(a.val<b.val)
            return -1;
        if(a.val==b.val){
            return a.index<b.index?-1:1;
        }
        return 1;
    }
}
public class first_unique_character_string {
	 public int firstUniqChar(String s) {
	        if(s.length()==0)
	            return -1;
	        PriorityQueue<FNode> q = new PriorityQueue<>(new FNodeCom());
	        HashMap<Character, FNode> set = new HashMap<>();
	        for(int i=0 ; i<s.length() ; i++){
	            if(set.containsKey(s.charAt(i))){
	                set.get(s.charAt(i)).val = set.get(s.charAt(i)).val+1;
	            }else{
	                FNode n = new FNode(i, 1);
	                set.put(s.charAt(i), n);
	            }
	        }
	        for(Map.Entry<Character, FNode> so:set.entrySet()){
	            q.add(so.getValue());
	        }
	        return q.peek().val==1?q.remove().index:-1;
	    }
}
