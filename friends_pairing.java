/*
 * 1. You are given a number n, representing the number of friends.
2. Each friend can stay single or pair up with any of it's friends.
3. You are required to print the number of ways in which these friends can stay single or pair up.
E.g.
1 person can stay single or pair up in 1 way.
2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12
3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1

                               
 */

import java.io.*;
import java.util.*;

public class friends_pairing {
	public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        if(n==0){
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        for(int i=1 ; i<n ; i++){
            if(i==1){
                dp[i] = 1 + dp[i-1];
            }else{
                
                dp[i] = dp[i-1] + (i*dp[i-2]);
            }
        }
        System.out.println(dp[n-1]);
    }
}
