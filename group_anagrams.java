import java.util.*;
//Given an array of strings, group anagrams together.
public class group_anagrams {

	 public static List<List<String>> groupAnagrams(String[] strs) {
	        boolean[] included = new boolean[strs.length];
	        List<List<String>> solution = new ArrayList<>();
	        
	        for(int i=0 ; i<strs.length;i++){
	        	
	            HashMap<String,Integer> set = new HashMap<>();
	            List<String> isol = new ArrayList<>();
	            if(!included[i]){
//	            	System.out.println(strs[i]);
	            	isol.add(strs[i]);
	                for(int j=0 ; j<strs[i].length();j++){
	                    if(!set.containsKey(strs[i].substring(j, j+1))){
	                        set.put(strs[i].substring(j,j+1),1);
	                    }else{
	                        set.put(strs[i].substring(j,j+1),set.get(strs[i].substring(j,j+1))+1);
	                    }
	                }
	                for(int j=i+1;j<strs.length;j++){
	                	HashMap<String, Integer> jthstring = new HashMap<>();
	                    if(strs[i].length()==strs[j].length()) {
//	                    	System.out.println(strs[j]);
	                    	boolean match=true;
	                    	for(int k=0 ; k<strs[j].length();k++) {
	                    		  if(!set.containsKey(strs[j].substring(k, k+1))){
	                    			  match=false;
	      	                        break;
	      	                    }else{
	      	                        if(jthstring.containsKey(strs[j].substring(k,k+1))) {
	      	                        	int joccurence = jthstring.get(strs[j].substring(k,k+1));
	      	                        	int ioccurence = set.get(strs[j].substring(k,k+1));
		      	                        if(joccurence==ioccurence) {
		      	                        	match=false;
		      	                        	break;
		      	                        }
		      	                        jthstring.put(strs[j].substring(k,k+1), joccurence+1);
	      	                        }else {
	      	                        	 jthstring.put(strs[j].substring(k,k+1), 1);
	      	                        }
	      	                    }
	                    	}
	                    	if(match) {
	                    		isol.add(strs[j]);
	                    		included[j]=true;
	                    	}
	                    }
	                }
	                solution.add(isol);
	            }
	        }
	        return solution;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs =  {"owl","woo"};
		System.out.println(groupAnagrams(strs));

	}

}
