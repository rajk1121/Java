import java.util.*;
public class binary_rep_to_one {
	 public static int numSteps(String s) {
	        int ans = 0;
	        while(s.length()!=1){
	            if(s.charAt(s.length()-1)=='1'){
	                String a = "1";
	                int fromLeft = 0;
	                String inter= "";
	                while(a.compareTo("0")!=0){
	                    inter = "0"+inter;
	                    fromLeft++;
	                    if(fromLeft==s.length())
	                        break;
	                    a = s.charAt(s.length()-1-fromLeft)+"";
	                }
	                inter = "1"+inter;
	                if(s.length()-1-fromLeft>=0){
	                    s = s.substring(0,s.length()-fromLeft-1)+inter;
	                }else{
	                    s = inter;
	                }
//	                System.out.println(s);
	                ans++;
	            }else{
	                s=s.substring(0, s.length()-1);
	                ans++;
//	                 System.out.println(s);
	            }
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSteps("1101"));
	}

}
