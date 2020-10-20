/*
 * 1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.

 */
import java.io.*;
import java.util.*;

public class paint_house_many_colors {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][k];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<k ; j++){
                arr[i][j]= sc.nextInt();
            }
        }
        int[][] dp = new int[n][k];
        for(int i=0 ; i<k ; i++)
            dp[n-1][i]= arr[n-1][i];
        for(int i=n-2 ; i>=0 ; i--){
            for(int j=0 ; j<k ; j++){
                int ans = Integer.MAX_VALUE;
                for(int m = 0; m<k ; m++){
                    if(m!=j){
                        ans= Math.min(ans, arr[i][j] + dp[i+1][m]);
                    }
                }
                dp[i][j] = ans;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0 ; i<k ; i++)
            ans = Math.min(ans, dp[0][i]);
        System.out.println(ans);
        
    }
}
