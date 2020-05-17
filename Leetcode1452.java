/*
 * Given the array favoriteCompanies where favoriteCompanies[i] is the list of favorites companies for the ith person (indexed from 0).

Return the indices of people whose list of favorite companies is not a subset of any other list of favorites companies. You must return the indices in increasing order.

 

Example 1:

Input: favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
Output: [0,1,4] 
Explanation: 
Person with index=2 has favoriteCompanies[2]=["google","facebook"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] corresponding to the person with index 0. 
Person with index=3 has favoriteCompanies[3]=["google"] which is a subset of favoriteCompanies[0]=["leetcode","google","facebook"] and favoriteCompanies[1]=["google","microsoft"]. 
Other lists of favorite companies are not a subset of another list, therefore, the answer is [0,1,4].

 */
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
