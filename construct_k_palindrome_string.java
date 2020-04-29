import java.util.*;
public class construct_k_palindrome_string {
	public boolean canConstruct(String s, int k) {
        if(s.length()==k){
            return true;
        }
        if(s.length()<k){
            return false;
        }else{
            HashMap<Character, Integer> set = new HashMap<>();
            for(int i=0; i<s.length(); i++){
                if(set.containsKey(s.charAt(i))){
                    set.put(s.charAt(i), set.get(s.charAt(i))+1);
                }else{
                    set.put(s.charAt(i), 1);
                }
            }
            if(k==set.size())
                return true;
            int odd= 0;
            int even=0;
            for(Map.Entry<Character, Integer> so: set.entrySet()){
                if(so.getValue()%2==0)
                    even++;
                else
                    odd++;
            }
            if(odd>k)
                return false;
            return true;
        }
    }
}
