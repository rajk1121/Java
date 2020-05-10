import java.public int findJudge(int N, int[][] trust) {
    HashMap<Integer, Integer> set = new HashMap<>();
    HashMap<Integer, Integer> followedBy = new HashMap<>();
    int max = 0;
    int elem = -1;
    if(N==1 && trust.length==0)
        return N;
    for(int i=0 ; i<trust.length ;i++){
        if(set.containsKey(trust[i][0])){
            set.put(trust[i][0],set.get(trust[i][0])+1);
            
        }else{
            set.put(trust[i][0],1);
        }
        if(!set.containsKey(trust[i][1])){
            set.put(trust[i][1],0);
            
        }
        if(!followedBy.containsKey(trust[i][1])){
            followedBy.put(trust[i][1], 1);
            if(max<followedBy.get(trust[i][1])){
                max= followedBy.get(trust[i][1]);
                elem = trust[i][1];
            }
        }else{
            followedBy.put(trust[i][1], followedBy.get(trust[i][1])+1);
            if(max<followedBy.get(trust[i][1])){
                max= followedBy.get(trust[i][1]);
                elem = trust[i][1];
            }
        }
    }
    // System.out.println(elem);
    if(followedBy.get(elem)==N-1 && set.get(elem)==0){
        return elem;
    }
    return -1;
    
}
public class judge_of_town {

}
