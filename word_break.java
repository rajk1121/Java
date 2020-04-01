import java.util.*;
public class word_break {
	  public static boolean wordBreak(String s, List<String> wordDict) {
		  HashMap<String, Integer> set= new HashMap<>();
	        for(int i=0 ; i<wordDict.size() ; i++)
	            set.put(wordDict.get(i), 1);
		  boolean[] arr =new boolean[s.length()];
		  for(int i=s.length()-1; i>=0 ; i--) {
			  boolean found = false;
	    	  for(int j=i+1 ; j<s.length() ;j++) {
	    		  if(set.containsKey(s.substring(i, j)) && arr[j]) {
	    			  arr[i] = true;
	    			  found = true;
	    			  break;
	    		  }
	    	  }
	    	  if(!found && set.containsKey(s.substring(i))) {
	    		  arr[i] = true;
	    	  }
	    	  
	      }
		  return arr[0];
	        
	      }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wd = new ArrayList();
		wd.add("cats");
		wd.add("and");
		wd.add("sand");
		wd.add("cat");
		wd.add("dog");
		System.out.println(wordBreak("catsandog", wd));
	}

}
