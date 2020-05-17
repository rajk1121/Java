import java.util.*;
public class foobar1 {
	public static int[] solution(int[] data, int n) {
        // Your code here
		
        HashMap<Integer, Integer> set = new HashMap<>();
        HashSet<Integer> hash = new HashSet<>();
        for(int i=0 ; i<data.length; i++){
            if(set.containsKey(data[i])){
                int occ = set.get(data[i]);
                if(occ>=n && !hash.contains(data[i])){
                    hash.add(data[i]);
                }
                set.put(data[i], occ+1);
            }else{
                set.put(data[i], 1);
                if(n==0 && !hash.contains(data[i])) {
                	hash.add(data[i]);
                }
            }
        }
        int j=0;
        HashSet<Integer> s = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<data.length ; i++){
            if(!hash.contains(data[i]) && !s.contains(data[i])){
               list.add(data[i]);
               s.add(data[i]);
            }
        }
//        System.out.println(hash);
        int[] ans = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {97,5,10,15,10,7,8,7,5,15,2,3,42};
		int[] ans = solution(arr, 1);
		for(int i=0; i<ans.length ; i++)
			System.out.println(ans[i]);

	}

}
