import java.util.*;
class WordNode{
    String s;
    int cost;
    public WordNode(String x, int a){
        s = x;
        cost = a;
    }
}
class word_ladder {
	 public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
	     
	      
	        HashSet<String> set = new HashSet<>(wordList);
	        // for(int i=0 ;i<wordList.get(0).length() ; i++) {
	        // 	HashSet<Character> hs = new HashSet<>();
	        // 	set.put(i,  hs);
	        // 	for(int j=0 ; j<wordList.size() ; j++) {
	        // 		if(!set.get(i).contains(wordList.get(j).charAt(i))) {
	        // 			set.get(i).add(wordList.get(j).charAt(i));
	        // 		}
	        // 	}
	        // 	set.put(i, hs);
	        // }
	        // HashSet<String> global= new HashSet<>();
	       System.out.println(set);
	        Queue<WordNode> q = new LinkedList<>();
	        WordNode one = new WordNode(beginWord, 0);
	        q.add(one);
	        while(q.size()!=0){
	            WordNode temp  =q.remove();
	           System.out.println(temp.s+"********************* "+temp.cost);
	            if(temp.s.compareTo(endWord)==0){
	                return temp.cost+1;
	            }
	            for(int i=0 ; i<temp.s.length(); i++) {
	            	// if(temp.s.charAt(i)!=endWord.charAt(i)) {
	            		
	            		for(char c = 'a'; c<='z' ; c++) {
	            			// char c = (char)it.next();

	            			String strToAdd = temp.s.substring(0, i) + c + temp.s.substring(i+1, temp.s.length());
	            			if(set.contains(strToAdd)) {
	            				WordNode cNode = new WordNode(temp.s.substring(0, i) + c + temp.s.substring(i+1, temp.s.length()), temp.cost+1);
	            				q.add(cNode);
	                            set.remove(strToAdd);
	            			}
	            		}
	            	// }
	            }
	            
	        }
	        return 0;
	    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	List<String> wordList = new ArrayList<>();
    	wordList.add("ymann");
    	wordList.add("yycrj");
    	wordList.add("oecij");
    	wordList.add("ymcnj");
    	wordList.add("yzcrj");
    	wordList.add("yycij");
    	wordList.add("xecij");
    	wordList.add("yecij");
    	wordList.add("ymanj");
    	wordList.add("ymain");
    	wordList.add("yzcnj");
//    	wordList.add("cog");
    	System.out.println(ladderLength("ymain", "oecij", wordList));

	}
}
