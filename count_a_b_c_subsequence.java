/*
 * 1. You are given a string str.
2. You are required to calculate and print the count of subsequences of the nature a+b+c+.

For abbc -> there are 3 subsequences. abc, abc, abbc
For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc

 */
import java.io.*;
import java.util.*;

public class count_a_b_c_subsequence {
	 public static void main(String[] args) throws Exception {
	        int ans = 0;
	        Scanner sc=  new Scanner(System.in);
	        String str = new String();
	        str = sc.next();
	        int[] arr = new int[str.length()];
	        for(int i=str.length()-1 ; i>=0 ; i--){
	            if(str.charAt(i)=='c' )
	                arr[i] = 1;
	            char x = str.charAt(i);
	            for(int j=i+1;j<str.length() ; j++){
	                char y = str.charAt(j);
	                if(x=='c'){
	                    if(y=='c'){
	                        arr[i]+=arr[j];
	                    }
	                }else if(x=='b'){
	                    if(y=='b' || y=='c')
	                        arr[i] = arr[i] + arr[j];
	                }else if(x=='a'){
	                    if(y=='a' || y=='b'){
	                        arr[i]+=arr[j];
	                        // ans =  arr[i];
	                        // break;
	                    }
	                    // System.out.println(ans+" "+arr[i]+" "+y);
	                }
	            }
	            if(x=='a'){
	                ans = ans + arr[i];
	            }
	        }
	        // for(int i=0 ; i<str.length() ; i++)
	        //     System.out.println(arr[i]);
	        System.out.println(ans);
}
}
