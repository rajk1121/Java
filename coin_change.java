import java.util.*;
public class coin_change {
	 public static int coinChange(int[] coins, int amount) {
//	     Arrays.sort(coins);
		 if(coins.length==0)
	    	 return 0;
	     int[] dp = new int[amount+1];
	     Arrays.fill(dp, -1);
	    int ans = find(coins, amount,0,0,0,dp);
	    return ans;
	    }
	private static int find(int[] coins, int amount, int i, int sum, int count, int[] dp) {
//		System.out.println(sum+" "+Integer.MIN_VALUE);
		if(sum<=Integer.MIN_VALUE)
			return -1;
		if(sum==amount)
			return count;
		if(sum>amount)
			return -1;
		int min = Integer.MAX_VALUE;
		int imin = 0;
//		if(dp[sum]!=-1)
//			return count+dp[sum];
		for(int j = i ; j<coins.length ; j++) {
			if(sum+coins[i]<=amount) {
				imin = find(coins, amount, j, sum+coins[j], count+1, dp);
				if(imin==-1)
					continue;
				else {
					min = Math.min(min, imin);
//					if(min==19)
//						System.out.println(sum);
				}
			}else {
				dp[sum] = -1;
				return -1;
				
			}
		}
//			return count+dp[sum];
//		if(min-count==20)
//			System.out.println(sum);
		if(min==Integer.MAX_VALUE) {
			dp[sum] = -1;
			return -1;
		}else {

//			if(dp[sum]!=-1 && dp[sum]!=min-count)
//				System.out.println(dp[sum]+" "+(min-count)+" "+sum+" "+dp[amount-sum]);
			dp[sum] = min-count;
			return min;
		}
	}
public static int  DPcoinChange(int[] coins, int amount){
		if(coins.length==0 || amount==0)
			return 0;
		int[]dp = new int[amount+1];
		Arrays.fill(dp, amount+1);
		dp[0]=0;
		for(int i=1 ; i<=amount; i++) {
			
			for(int j=0 ; j<coins.length ; j++) {
				if(coins[j]<=i) {
//					System.out.println(coins[j]);
					dp[i]= Math.min(dp[i], 1+dp[i-coins[j]]);
//					System.out.println(dp[i]+" "+coins[j]+" "+i);
				}
			}
//			System.out.print(dp[i]+" ");
		}

//	    for(int i=0 ; i<=amount ;i++)
//	        System.out.println(dp[i]);
        return dp[amount]>amount?-1:dp[amount];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {186,419,83,408};
//		int[] coins = {1,2,5};
//		Arrays.sort(coins);
		System.out.println(DPcoinChange(coins,6249));
	}

}
