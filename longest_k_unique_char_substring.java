import java.util.*;
public class longest_k_unique_char_substring {
	public static int solution(String str, int k) {
		// write your code here
		int i=-1, j=-1, ans = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(true){
		    boolean f1 = false;
		    if(map.size()<k){
		        f1 = true;
		        while(j<str.length() - 1){
		            j++;
		            char x = str.charAt(j);
		            if(map.containsKey(x)){
		                map.put(x, map.get(x) + 1);
		            }else{
		                if(map.size() == k){
		                    j--;
		                    break;
		                }else{
		                    map.put(x, 1);
		                }
		            }
		        }
		    }   
		    if(map.size()==k)
			    ans = Math.max(ans, j - i);
		    if(f1){
		        while(i<str.length() - 1){
		            i++;
		            char x = str.charAt(i);
		            int f = map.get(x);
		            if(f==1){
		                map.remove(x);
		              //  i--;
		                break;
		            }else{
		                map.put(x, f - 1);
		            }
		        }
		    }
		    if(j==str.length() - 1)
		        break;
		    
		}
		return ans==0 ? -1 : ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t>0){
            String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
            t--;
        }
	}
}
