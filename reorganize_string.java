/*
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"

Example 2:

Input: S = "aaab"
Output: ""

 */
import java.util.*;
class listComp implements Comparator<List<Character>>{
	public int compare(List<Character> a, List<Character> b) {
		return -(a.size()- b.size());
	}
}
public class reorganize_string {
	 public static String reorganizeString(String S) {
	        HashMap<Character, List<Character>> set = new HashMap<>();
	        for(int i=0 ; i<S.length() ; i++) {
	        	if(set.containsKey(S.charAt(i))) {
//	        		System.out.println(set.get(S.charAt(i)).size()+1);
//	        		System.out.println(Math.ceil((double)S.length() / 2));
	        		if(set.get(S.charAt(i)).size()+1 <= Math.ceil((double)S.length()/2)) {
	        			set.get(S.charAt(i)).add(S.charAt(i));
	        		}else {
	        			return "";
	        		}
	        	}else {
	        		List<Character> temp = new ArrayList<>();
	        		temp.add(S.charAt(i));
	        		set.put(S.charAt(i), temp);
	        	}
	        }
	        
	        PriorityQueue<List<Character>> q = new PriorityQueue<>(new listComp());
	        for(Map.Entry<Character, List<Character>> s: set.entrySet()) {
	        	q.add(s.getValue());
	        }
//	        int x = q.size();
//	        for(int i=0 ; i< x; i++) {
//	        	List<Character> l = q.remove();
//	        	System.out.println(l.get(0)+" "+l.size());
//	        }
	        String sol = "";
	        while(q.size()!=0) {
	        	List<Character> x = q.remove();
	        	List<Character> y = null;
	        	if(q.size()!=0) {
	        		y = q.remove();
	        	}
	        	sol = sol+x.remove(x.size()-1);
	        	if(y!=null)
	        		sol = sol+y.remove(y.size()-1);
	        	if(x.size()!=0) {
	        	q.add(x);
	        	}
	        	if(y!=null && y.size()!=0) {
	        	q.add(y);
	        	}
	        }
	        
	        
		 return sol;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(3/2);
		System.out.println(reorganizeString("vvvol"));
				}

}
