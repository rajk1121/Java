/*
 * A String is said to be a ZAP string if it contains either 'a' or 'z' or 'p'. Given a String S, count the number of ZAP substrings in the given string S. Two substrings are different, if it contains characters which occurs at different positions in the given string.
S contains only lower case latin letters, i.e. characters a to z.
Input Format :

String S

Output Format :

Single Integer representing the number of good substrings

Constraints :
Sample Input 1 :

abcd

Sample Output 1 :

4

Sample Input 2 :

azazazp

Sample Output 2 :

28

Sample Input 3 :

arpznca

Sample Output 3 :

24

Sample Input 4 :

aaa

Sample Output 4 :

6


 */
import java.util.*;
public class ZAP {
	 public static int count_Zap_Strings(String S)
	    {
	        int total=0;
	        int[] dp = new int[S.length()];
	        if(S.charAt(S.length()-1)=='z' || S.charAt(S.length()-1)=='p' || S.charAt(S.length()-1)=='a')
	        	dp[S.length()-1] = 1;
	        else
	        	dp[S.length()-1] = 0;
	        for(int i=S.length()-2 ; i>=0 ; i--) {
	        	 if(S.charAt(i)=='z' || S.charAt(i)=='p' || S.charAt(i)=='a') {
	        		 dp[i] = S.length()-1 - (i-1) ;
	        	 }
	 	        	
	 	        else{
	 	        	dp[i] = dp[i+1];
	 	        }
	        }
	        for(int i=0 ; i<dp.length ; i++)
	        	total+=dp[i];
	        return total;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(count_Zap_Strings(str));
		sc.close();
	}

}
