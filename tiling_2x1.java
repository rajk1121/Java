/*
 * 1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
2. You've an infinite supply of 2 * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.

 */

import java.io.*;
import java.util.*;

public class tiling_2x1 {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n+1];
        dp[n-1] = 1;
        if(n==1){
            System.out.println(dp[0]);
            return;
        }
        dp[n-2] = 2;
        for(int i=n-3 ; i>=0 ; i--){
           dp[i] = dp[i+2] + dp[i+1];
        }
        System.out.println(dp[0]);
    }
}
