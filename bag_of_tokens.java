import java.util.*;
public class bag_of_tokens {
	 public static int bagOfTokensScore(int[] tokens, int P) {
	        Arrays.sort(tokens);
	        int ans = 0;
	        int t = 0;
	        int low = 0;
	        int high = tokens.length - 1;
	        while(low<=high){
	            while(low < tokens.length && P - tokens[low]>=0){
	                P = P - tokens[low];
	                low++;
	                t++;
	                ans = Math.max(ans, t);
	            }
	            if(low<=high){
	                t--;
	                P = P + tokens[high];
	                high--;
	            }else {
	            	break;
	            }
	        
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tokens= {100,200,300,400,500,600};
		int P = 500;
		System.out.println(bagOfTokensScore(tokens, P));
	}

}
