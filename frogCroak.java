import java.util.*;
public class frogCroak {
	 public static int minNumberOfFrogs(String s) {
	        
	        int ans = 0;
	        int free = 0;
	        HashMap<Character, Integer> set = new HashMap<>();
	        
	        if(s.charAt(0)=='c'){
	            set.put('r',1);
	        }else{
	            return -1;
	        }
	        for(int i=1 ; i<s.length() ; i++){
	            if(s.charAt(i)=='c'){
	            	if(free!=0)
	            		free--;
	                if(set.containsKey('r')){
	                    set.put('r', set.get('r')+1);
	                }else{
	                    set.put('r',1);
	                }
	            }
	             if(s.charAt(i)=='r'){
	                if(set.containsKey('r')){
	                    int occ = set.get('r');
	                    if(occ==1){
	                        set.remove('r');
	                    }else{
	                        set.put('r',occ-1);
	                    }
	                }else{
	                    return -1;
	                }
	                 if(set.containsKey('o')){
	                     set.put('o', set.get('o')+1);
	                 }else{
	                     set.put('o',1);
	                 }
	            }
	             if(s.charAt(i)=='o'){
	                if(set.containsKey('o')){
	                    int occ = set.get('o');
	                    if(occ==1){
	                        set.remove('o');
	                    }else{
	                        set.put('o',occ-1);
	                    }
	                }else{
	                    return -1;
	                }
	                 if(set.containsKey('a')){
	                     set.put('a', set.get('a')+1);
	                 }else{
	                     set.put('a',1);
	                 }
	                
	            }
	             if(s.charAt(i)=='a'){
	                if(set.containsKey('a')){
	                    int occ = set.get('a');
	                    if(occ==1){
	                        set.remove('a');
	                    }else{
	                        set.put('a',occ-1);
	                    }
	                }else{
	                    return -1;
	                }
	                 if(set.containsKey('k')){
	                     set.put('k', set.get('k')+1);
	                 }else{
	                     set.put('k',1);
	                 }
	                
	            }
	             if(s.charAt(i)=='k'){
	                if(set.containsKey('k')){
	                    int occ = set.get('k');
	                    if(occ==1){
	                        set.remove('k');
	                    }else{
	                        set.put('k',occ-1);
	                    }
	                }else{
	                    return -1;
	                }

		            free++;
		            ans  =Math.max(ans, free);
	                 
	                
	            }
	             
	        }
	        
	        return set.size()==0?ans:-1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minNumberOfFrogs("croakcroak"));
	}

}
