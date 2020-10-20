import java.util.*;
public class smallest_substr_have_all_its_unique_chars {
	public static int solution(String str){
		// write your code here
		HashMap<Character, Integer> gSet = new HashMap<>();
		for(int i=0;  i<str.length() ; i++){
		    gSet.put(str.charAt(i), gSet.getOrDefault(str.charAt(i), 0)+1);
		}
		int i=-1, j=-1, ans = Integer.MAX_VALUE;
		HashMap<Character, Integer> set = new HashMap<>();
		while(true){
		    boolean f1 = false;
		    boolean f2 = false;
		    while(j<str.length()-1){
		        f1 = true;
		        j++;
		        char x = str.charAt(j);
		        if(set.containsKey(x)){
		            if(set.size()==gSet.size()){
		                j--;
		                break;
		            }
		            set.put(x, set.get(x)+1);
		        }else{
		            if(set.size()==gSet.size()){
		                j--;
		                break;
		            }else if(set.size()<gSet.size()){
		                set.put(x, 1);
		            }
		        }
// 		System.out.println(gSet+" "+set);
		    }
		    
		    while(i<str.length()-1){
		        f2 = true;
		        if(set.size()==gSet.size())
		            ans = Math.min(ans, j-i);
		      //  System.out.println(ans+" "+i+" "+j+" "+set);
		        i++;
		        char x = str.charAt(i);
		        int f = set.get(x);
		        if(f==1){
		            set.remove(x);
		            break;
		        }else{
		            set.put(x, f-1);
		        }
		    }
		    if(!f1 && !f2)
		        break;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}
}
