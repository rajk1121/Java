/*
 * Given a sentence text (A sentence is a string of space-separated words) in the following format:

    First letter is in upper case.
    Each word in text are separated by a single space.

Your task is to rearrange the words in text such that all words are rearranged in an increasing order of their lengths. If two words have the same length, arrange them in their original order.

Return the new text following the format shown above.

 

Example 1:

Input: text = "Leetcode is cool"
Output: "Is cool leetcode"
Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of length 4.
Output is ordered by length and the new first word starts with capital letter.

 */
import java.util.*;
class listCompx implements Comparator<String>{
    public int compare(String x, String y){
        return x.length() - y.length();
    }
}
public class rearrange_in_array_words {
	  public String arrangeWords(String text) {
	        
	        List<String> list = new ArrayList<>();
	        String[] arr = text.split(" ");
	        if(arr.length==0)
	            return "";
	        list.add(arr[0].substring(0,1).toLowerCase() + arr[0].substring(1));
	        for(int i=1; i<arr.length ; i++)
	            list.add(arr[i]);
	        
	        String ans = "";
	        Collections.sort(list, new listCompx());
	        // ans = ans + list.get(0);
	        ans = ans + list.get(0).substring(0,1).toUpperCase();
	        ans= ans + list.get(0).substring(1);
	        for(int i=1 ; i<list.size() ; i++){
	            ans = ans+" "+list.get(i);
	        }
	        return ans;
	    }
}
