import java.util.Scanner;
import java.util.HashMap;

public class foobar3_b {
	 public static int solution(int n) {
	        // Your code here
//		 int ans = 0;
		 if(n<=4)
			 return 1;
		 int[] dp = new int[n+1];
		 HashMap<Integer, HashMap<Integer, Integer>> set = new HashMap<>();
		 
		 dp[2] = 1;
		 dp[1] = 1;
		 for(int i=3 ; i<=n ; i++) {
			 HashMap<Integer, Integer> nSet = new HashMap<>();
			 int j = i-1;
			 int ans = 0;
			 while(j>i-j) {
				 nSet.put(j, dp[i-j]);
				 ans = ans + dp[i-j];
				 j--;
			 }
			 if(i%2==0 && i/2==j) {
				 nSet.put(j, dp[i-j] - 1);
				 ans = ans + dp[j] - 1;
				 j--;
			 }
			 while(j>3) {
				 int k = j;
				 int ians = 0;
				 while(set.get(i-j).containsKey(k-1)) {
					 
					 ians = ians + set.get(i-j).get(k-1);
					 k--;
				 }
				 ans = ans + ians;
				 nSet.put(j, ians);
				 j--;
			 }
			 set.put(i, nSet);
//			 System.out.println(nSet);
			 dp[i] = ans + 1;
//			 System.out.println(i+"------------------>"+ans);
		 }
//		 System.out.println(dp[n]);
		 return dp[n]-1;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));
	}

}
