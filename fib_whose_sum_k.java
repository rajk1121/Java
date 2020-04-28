/*
 * Given the number k, return the minimum number of Fibonacci numbers whose sum is equal to k, whether a Fibonacci number could be used multiple times.

The Fibonacci numbers are defined as:

    F1 = 1
    F2 = 1
    Fn = Fn-1 + Fn-2 , for n > 2.

It is guaranteed that for the given constraints we can always find such fibonacci numbers that sum k.

 

Example 1:

Input: k = 7
Output: 2 
Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ... 
For k = 7 we can use 2 + 5 = 7.

Example 2:

Input: k = 10
Output: 2 
Explanation: For k = 10 we can use 2 + 8 = 10.

Example 3:

Input: k = 19
Output: 3 
Explanation: For k = 19 we can use 1 + 5 + 13 = 19.

 */
import java.util.*;
public class fib_whose_sum_k {
	public static int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        int one = 1, two=1;
        while(one+two<=k){
            list.add(one+two);
            two = one+two;
            one = list.get(list.size()-2);
        }
        
        list.add(one+two);
        System.out.println(list);
        int ans =0;
        int index = list.size()-2;
        while(true){
        	
        	ans++;
        	k = k-list.get(index);
        	if(k==0)
        		break;
        	while(list.get(index)>k)
        		index--;
        }
        return ans;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(2147483647> 645157245);
		System.out.println(findMinFibonacciNumbers(1000000000));
	}

}
