import java.util.*;
class listComps implements Comparator<List<String>>{
    public int compare(List<String> a, List<String> b){
        return -(a.size() - b.size());
    }
}
public class Leetcode1452 {
	 public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
	        HashMap<List<String>,Integer> global = new HashMap<>();
	        for(int i=0 ; i<favoriteCompanies.size(); i++){
	            global.put(favoriteCompanies.get(i), i);
	        }
	        System.out.println(global);
	        Collections.sort(favoriteCompanies, new listComps());
	        List<Integer> ans = new ArrayList<>();
	        HashMap<Integer, Set<String>> set = new HashMap<>();
	        
	        for(int i=0;i<favoriteCompanies.size(); i++){
	            Set<String> x = new HashSet<>();
	            for(int j=0 ; j<favoriteCompanies.get(i).size() ; j++){
	                x.add(favoriteCompanies.get(i).get(j));
	                
	            }
	            boolean found = false;
	            for(Map.Entry<Integer, Set<String>> so: set.entrySet()){
	                // System.out.println(so.getValue());
	                // System.out.println(x);
	                // System.out.println("***************");
	                if(so.getValue().containsAll(x)){
	                    found = true;
	                    break;
	                }
	            }
	            if(!found)
	                ans.add(global.get(favoriteCompanies.get(i)));
	            set.put(i, x);
	        }
	        Collections.sort(ans);
	        return ans;
	    }
}
