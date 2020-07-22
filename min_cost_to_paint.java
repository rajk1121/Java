/*
 * 1. You are given a number n, representing the number of houses.
2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.

 */
import java.io.*;
import java.util.*;

public class min_cost_to_paint {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        int[][]colors = new int[n][3];
        for(int i=0;  i<n ; i++){
            colors[i][0] = sc.nextInt();
            colors[i][1] = sc.nextInt();
            colors[i][2] = sc.nextInt();
        }
        int[][] dp = new int[n][3];
        dp[n-1][0] = colors[n-1][0];
        dp[n-1][1] = colors[n-1][1];
        dp[n-1][2] = colors[n-1][2];
        for(int i=n-2; i>=0 ; i--){
            dp[i][0] =colors[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1] =colors[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2] =colors[i][2] + Math.min(dp[i+1][0],dp[i+1][1]);
        }
        int ans = Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
        System.out.println(ans);
    }
}
