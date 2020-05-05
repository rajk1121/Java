import java.util.*;
class KNode{
    int occ ;
    int elem;
    KNode(int o, int e){
        occ = o;
        elem = e;
    }
}
class KNodeComp implements Comparator<KNode>{
    public int compare(KNode a, KNode b){
        return -(a.occ - b.occ);
    }
}
class k_most_frequent_elements {
    public int[] topKFrequent(int[] nums, int k) {
     HashMap<Integer, Integer> set = new HashMap<>();
        for(int i=0 ; i<nums.length;  i++){
            if(set.containsKey(nums[i])){
                set.put(nums[i], set.get(nums[i])+1);
            }else{
                set.put(nums[i], 1);
            }
        }
        
        // System.out.println(set);
        List<KNode> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> s : set.entrySet()){
            KNode n = new KNode(s.getValue(), s.getKey());
            list.add(n);
        }
        Collections.sort(list, new KNodeComp());
        // System.out.println(list);
        int []arr = new int[k];
        for(int i=0 ; i<k ; i++){
            arr[i] = list.get(i).elem;
        }
        return arr;
    }
}