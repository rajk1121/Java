import java.util.*;
public class distinct_BST {
	public static void main(String[] args) {
  		int  n=50;
		int answer=0;
		int[] dp = new int[n+1];
		for(int i=1 ; i<=n ; i++) {
			int ans1,ans2;
			ans1= calculate(1, i-1, dp);
			if(ans1==0)
				ans1=1;
				
			ans2= calculate(i+1, n, dp);
			if(ans2==0)
				ans2=1;
			answer = answer+(ans1*ans2);
		}
		
//		for(int i=0 ; i<dp.length ; i++) {
//			System.out.println(dp[i]);
//		}
		System.out.println(answer);
	}

	private static int calculate( int left, int right, int[] n) {
		
		// TODO Auto-generated method stub
//		if(i-left-1<=2) {
//			return i-left;
//		}
//		if(right-i-1<=2) {
//			return right-i;
//		}
		if(left>right)
			return 0;
//		System.out.println(left+"  "+right);
		if(right-left+1==3) {
			n[3]= 5;
			return 5;
		}
		if(right-left+1<=2) {
			n[right-left+1] = right-left+1;
			return right-left+1;
		}
		int answer=0;
		if(n[right-left+1]!=0) {
			return n[right-left+1];
		}
		for(int i=left ; i<=right ; i++) {
			int ans1,ans2;
			ans1= calculate(left, i-1, n);
			if(ans1==0)
				ans1=1;
				
			ans2= calculate(i+1, right,n );
			if(ans2==0)
				ans2=1;
			answer = answer+(ans1*ans2);
			
			
		}
//		if(right-left+1==4) {
//			System.out.println(answer+" /////////");
//		}
		n[right-left+1] = answer;
		return answer;
	}	
}
