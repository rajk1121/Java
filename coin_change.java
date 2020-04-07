import java.util.*;
public class coin_change {
	 public static int coinChange(int[] coins, int amount) {
	     if(coins.length==0)
	    	 return 0;
	    return find(coins, amount,0,0,0);    	
	    }
	private static int find(int[] coins, int amount, int i, int sum, int count) {
		if(sum==amount)
			return count;
		if(sum>amount)
			return -1;
		int min = Integer.MAX_VALUE;
		int imin = 0;
		for(int j = i ; j<coins.length ; j++) {
			if(sum+coins[i]<=amount) {
				imin = find(coins, amount, j, sum+coins[j], count+1);
				if(imin==-1)
					continue;
				else {
					min = Math.min(min, imin);
				}
			}else
				return -1;
		}
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {227,99,328,299,42,322};
		Arrays.sort(coins);
		System.out.println(coinChange(coins,9847));
	}

}
