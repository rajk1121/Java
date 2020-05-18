/*
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.
 */
import java.util.*;
public class all_anagrams_in_string {
	 public static List<Integer> findAnagrams(String s1, String s2) {
         boolean seq = false;
     List<Integer> ans = new ArrayList<>();
     HashMap<Character, Integer> set2 = new HashMap<>();
     HashMap<Character, Integer> set1 = new HashMap<>();
     for(int i=0 ; i<s2.length() ; i++){
         if(set2.containsKey(s2.charAt(i))){
             set2.put(s2.charAt(i), set2.get(s2.charAt(i))+1);
         }else{
             set2.put(s2.charAt(i), 1);   
         }
     }
     System.out.println(set2);
     int start = 0;
     set1.putAll(set2);

     System.out.println(set1);
     for(int i=0 ; i<s1.length(); i++){
         char x = s1.charAt(i);
         if(seq){
             if(set2.containsKey(x)){
                 if(set1.containsKey(x)){
                     int occ = set1.get(x);
                     if(occ==1)
                         set1.remove(x);
                     else
                         set1.put(x, occ-1);
                     if(set1.size()==0){
                         ans.add(start);
                         if(i+1<s1.length()) {
                        	 if(s1.charAt(i+1)==s1.charAt(start)) {

                         		set1.put(s1.charAt(start), 1);
                        		start = start+1;
                        	 }
                         }
                     }
                 }else{
                     int j=start;
                     while(true){
                         if(s1.charAt(j)==s1.charAt(i)){
                             break;
                         }
                         if(set1.containsKey(s1.charAt(j))){
                             set1.put(s1.charAt(j), set1.get(s1.charAt(j))+1);
                         }else{
                             set1.put(s1.charAt(j), 1);
                         }
                         j++;
                     }
                     start = j+1;
                 }   
             }else{
                 set1 = new HashMap<>();
                 set1.putAll(set2);
                 seq = false;
             }
         }else{
             if(set2.containsKey(x)){
                 start = i;
                 int occ = set1.get(x);
                 if(occ==1)
                     set1.remove(x);
                 else
                     set1.put(x, occ-1);
                 if(set1.size()==0){
                     ans.add(start);
                     if(i+1<s1.length()) {
                    	 if(s1.charAt(i+1)==s1.charAt(start)) {

                     		set1.put(s1.charAt(start), 1);
                    		start = start+1;
                    	 }
                     }
                 }
                 seq = true;
                 
             }
         }
     }
     return ans;
     
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findAnagrams("acdcaeccde", "c"));

	}

}
