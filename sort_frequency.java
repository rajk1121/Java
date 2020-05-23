import java.util.*;
class SortNode{
    char x;
    int size;
    public SortNode(char a){
        x = a;
        size = 1;
    }
}
class xistComp implements Comparator<SortNode>{
    public int compare(SortNode a, SortNode b){
        return a.size - b.size ;
    }
}

class sort_frequency {
    public String frequencySort(String s) {
        List<SortNode> list = new ArrayList<>();
        HashMap<Character, SortNode> set = new HashMap<>();
        for(int i=0 ; i<s.length() ; i++){
            if(set.containsKey(s.charAt(i))){
                set.get(s.charAt(i)).size = set.get(s.charAt(i)).size + 1; 
            }else{
                SortNode n = new SortNode(s.charAt(i));
                set.put(s.charAt(i), n);
            }
        }
        for(Map.Entry<Character, SortNode> l:set.entrySet()){
            list.add(l.getValue());
        }
        Collections.sort(list, new xistComp());
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

