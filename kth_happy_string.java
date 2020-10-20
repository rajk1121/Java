import java.util.*;
public class kth_happy_string {
	static int ans = 0; 
	public static String getHappyString(int n, int k) {
	        if(k>Math.pow(2,k-1)*3){
	            return "";
	        }else{
	            String ans = generate(n, k,"");
	            return ans;
	        }
	    }
	    public static String generate(int n, int k, String s){
//	        if(k==0) {
//
//	            System.out.println(s);
//	        	return s;
//	        }
	        if(n==0) {
	        	ans++;
	        	if(ans==k)
	        		return s;
//	            System.out.println(s);
	            return "";
	        }
	        String[] arr = new String[3];
	        arr[0]=  "a";
	        arr[1] = "b";
	        arr[2] = "c";
	        for(int i=0 ; i<3 ; i++){
	            if(s==""){
	                String r = generate(n-1, k, s+arr[i]);
//	                k--;
	                if(r!="")
	                    return r;
	            }else{
	                if(s.charAt(s.length()-1)!=arr[i].charAt(0)){
	                    String r = generate(n-1, k, s+arr[i]);
//	                    k--;
	                    if(r!="")
	                        return r;
	                }
	            }
	        }
	        return "";
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHappyString(10,100));

	}

}
