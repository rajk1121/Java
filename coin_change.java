import java.util.*;
public class coin_change {
	 public static int coinChange(int[] coins, int amount) {
	     Arrays.sort(coins);
		 if(coins.length==0)
	    	 return 0;
	     int[] dp = new int[amount+1];
	     Arrays.fill(dp, -1);
	    int ans = find(coins, amount,0,0,0,dp);
//	    for(int i=0 ; i<dp.length ; i++)
//	    	System.out.print(dp[i]+" ");
//	    System.out.println();
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

			if(dp[sum]!=-1 && dp[sum]!=min-count)
				System.out.println(dp[sum]+" "+(min-count)+" "+sum);
			dp[sum] = min-count;
			return min;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {58,92,387,421,194,208,231};
		Arrays.sort(coins);
		System.out.println(coinChange(coins,7798));
	}

}
