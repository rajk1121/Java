/*
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:

Input: 2
Output: 91 
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
             excluding 11,22,33,44,55,66,77,88,99


 */
import java.util.*;
public class Count_Numbers_with_Unique_Digits {
	 public static int countNumbersWithUniqueDigits(int n) {
	        Queue<Integer> q = new LinkedList<>();
	        if(n==0)
	            return 2;
	        q.add(1);
	        q.add(2);
	        q.add(3);
	        q.add(4);
	        q.add(5);
	        q.add(6);
	        q.add(7);
	        q.add(8);
	        q.add(9);
	        // q.add(1);
	        int answer = 1;
	        while(q.size()!=0){
	            boolean[] arr = new boolean[10];
	            int num = q.remove();
//	            System.out.println(num);
	            int x = num;
	            int y = num;
	            if(num>=Math.pow(10,n) || num<0)
	                break;
	            answer++;
	            while(y!=0){
	                arr[y%10] = true;
	                y=y/10;
	            }
	            for(int i=0 ; i<=9 ; i++){
	                if(!arr[i])
	                    q.add(x*10+i);
	            }
	        }
	        return answer;
	        
	    }
	 public static int LOW_COMPLEXITYcountNumbersWithUniqueDigits(int n){
		 int answer=10;
		 if(n==0)
			 return 1;
		 if(n==1)
			 return 10;
		 int previous = 81;
		 int x = 8;
		 for(int i=1 ; i<n ; i++) {
			 answer = answer + previous;
			 previous = previous * x ;
			 x--;
		 }
		 
		 return answer;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(2>Math.pow(10, 2));
		System.out.println(LOW_COMPLEXITYcountNumbersWithUniqueDigits(9));
		System.out.println(countNumbersWithUniqueDigits(9));
	}

}
