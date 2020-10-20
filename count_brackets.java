/*
1. You are given a number n, representing the number of opening brackets ( and closing brackets )
2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
e.g.
for 1, answer is 1 -> ()
for 2, answer is 2 -> ()(), (())
for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))
*/
import java.io.*;

import java.util.*;

public class count_brackets{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if(n==0){
        System.out.println(0);
        return;
    }
    int N = 2*n;
    int k = n;
    long ans = 1;
    for(int i=0 ; i<k ; i++){
        ans = ans * (N - i);
        ans = ans / (i+1);
    }
    System.out.println(ans/(n+1));
 }

}