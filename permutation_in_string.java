/*
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False

 */
import java.util.*;
public class permutation_in_string {
	public static boolean checkInclusion(String s2, String s1) {
        boolean seq = false;
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
                        if(set1.size()==0)
                            return true;
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
                    if(set1.size()==0)
                        return true;
                    seq = true;
                    
                }
            }
        }
        return false;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkInclusion("ccc","cbac"));
	}

}
