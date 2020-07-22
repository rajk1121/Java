/*
 * 1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.

                               
 */
import java.io.*;
import java.util.*;

public class count_binary_string{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if(n==0){
        System.out.println(0);
        return;
    }
    if(n==1){
        System.out.println(2);
        return;
    }
    if(n==2){
        System.out.println(3);
        return;
    }
    int[] arr = new int[n];
    arr[0] = 1;
    arr[1] = 1;
    int sum[] = new int[n];
    sum[0]=1;
    sum[1]=2;
    int ans = 2;
    for(int i=2 ; i<n ; i++){
        arr[i] = 1 + sum[i-2];
        sum[i] = sum[i-1] + arr[i];
        ans = ans + arr[i];
        // System.out.println(arr[i]+" "+sum[i]);
    }
    System.out.print(ans+1);
    
 }

}