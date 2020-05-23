import java.util.*;
class Node{
    char x;
    int size;
    public Node(char a){
        x = a;
        size = 1;
    }
}
class ListComp implements Comparator<Node>{
    public int compare(Node a, Node b){
        return a.size - b.size ;
    }
}

class sort_frequency {
    public String frequencySort(String s) {
        List<Node> list = new ArrayList<>();
        HashMap<Character, Node> set = new HashMap<>();
        for(int i=0 ; i<s.length() ; i++){
            if(set.containsKey(s.charAt(i))){
                set.get(s.charAt(i)).size = set.get(s.charAt(i)).size + 1; 
            }else{
                Node n = new Node(s.charAt(i));
                set.put(s.charAt(i), n);
            }
        }
        for(Map.Entry<Character, Node> l:set.entrySet()){
            list.add(l.getValue());
        }
        Collections.sort(list, new ListComp());
        String ans = "";
        for(int i=list.size()-1 ; i>=0 ; i--){
            char x = list.get(i).x;
            int j=0;
            while(j<list.get(i).size){
                ans = ans+x;
                j++;
            }
        }
        return ans;
            
    }
}

