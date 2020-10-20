
public class burst_balloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {8,10,5,4,73,9,2,100};
		System.out.println(maxCoins(nums));
	}
	public static int maxCoins(int[] nums) {
		int n = nums.length;
		if(n==0)
			return 0;
		if(n==1)
			return nums[0];
		int[] newNum = new int[n+2];
		newNum[0]=newNum[n+1] = 1;
		for(int i=0 ; i<n ; i++)
			newNum[i+1] = nums[i];
		int[][] dp= new int[n][n];
		for(int len=1 ; len<=n;  len++) {
			for(int i=1 ; i+len-1<=n ;i++ ) {
				int max = 0;
				for(int k=i ; k<=i+len-1 ; k++) {
					if(i==i+len-1) {
//						System.out.println(newNum[k-1]*newNum[k]*newNum[k+1]);
						max = Math.max(max, 0+0+newNum[k-1]*newNum[k]*newNum[k+1]);
					}else if(k==i) {
//						System.out.println(dp[k][i+len-2]+" "+(newNum[k]*newNum[i-1]*newNum[i+len]));
						max = Math.max(max, 0 + dp[k][i+len-2] + newNum[k]*newNum[i-1]*newNum[i+len]);
					}else if(k==i+len-1) {
//						System.out.println( dp[i-1][k-2]+" "+( newNum[k]*newNum[i-1]*newNum[i+len])+" "+(i-1)+" "+(k-2));
						max = Math.max(max, 0 + dp[i-1][k-2] + newNum[k]*newNum[i-1]*newNum[i+len]);
					}else {
//						System.out.println( dp[k][i+len-2]+" "+dp[k-2][i+len-2]+" "+(newNum[k]*newNum[i-1]*newNum[i+len]));
						max = Math.max(max, dp[k][i+len-2] + dp[i-1][k-2] + newNum[k]*newNum[i-1]*newNum[i+len]);
						
					}
				}
//				System.out.println(i-1+" "+(i+len-2)+" index");
				dp[i-1][i+len-2] = max;
//				System.out.println(max+" final");
			}
		}
        return dp[0][n-1];
    }

}
