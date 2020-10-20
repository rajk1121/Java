import java.util.*;
public class count_substrings_all_unique_char {
	public static int solution(String str) {
		// write your code here
		int ans = 0;
		int i=-1, j=0;
		HashMap<Character, Integer> set = new HashMap<>();
		while(j<str.length()){
		    char x = str.charAt(j);
		  //  System.out.println(ans + " "+i+" "+j);
		    if(set.containsKey(x)){
		        i++;
		      //  ans = ans + (2 + (j - i - 1))*(j - i)/2;
		        ans = ans + (j-i)*(j-i+1)/2;
		        while(str.charAt(i) != x ){
		            if(set.get(str.charAt(i))==1){
		                set.remove(str.charAt(i));
		            }else{
		                set.put(str.charAt(i), set.get(str.charAt(i))-1);
		            }
		            i++;
		            
		        }
		        ans = ans - (j-i)*(j-i-1)/2;
		        set.remove(x);
		    }else{
		        j++;
		        set.put(x, 1);
		    }
		    
		  //  System.out.println(set);
		  //  System.out.println(ans + " "+i+" "+j);
		}
		i++;
		ans = ans + (j-i)*(j-i+1)/2;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}
}
