import java.util.*;
public class coin_change_II {
	  public static int change(int amount, int[] coins) {
		  if(coins.length==0 && amount==0)
	            return 1;
	        if(coins.length==0 && amount!=0)
	            return 0;
	        
	        int[] dp = new int[amount+1];
	        Arrays.sort(coins);
	        for(int i=0 ; i<=amount; i++){
	            if(i%coins[0]==0)
	                dp[i] = 1;
	        }
	        for(int i=1 ; i<coins.length ; i++){
	            for(int j=0 ; j<=amount ; j++){
	               if(j>=coins[i]){
	                   dp[j] = dp[j] + dp[j - coins[i]];
	               }
	            }
	        }
	        return dp[amount];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,2,5};
		System.out.println(change(5, coins));
	}

}
