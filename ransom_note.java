/*
 *  Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters. 
 */
import java.util.*;
public class ransom_note {
	public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> set = new HashMap<>();
        for(int i=0 ; i<magazine.length() ; i++){
            if(set.containsKey(magazine.charAt(i))){
                set.put(magazine.charAt(i), set.get(magazine.charAt(i))+1);
            }else{
                set.put(magazine.charAt(i), 1);
            }
        }
        for(int i=0 ; i<ransomNote.length() ; i++){
            if(set.containsKey(ransomNote.charAt(i))){
                if(set.get(ransomNote.charAt(i))==1){
                    set.remove(ransomNote.charAt(i));
                }else{
                    set.put(ransomNote.charAt(i), set.get(ransomNote.charAt(i))-1);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
