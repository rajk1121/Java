/*
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

    NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
    For example, for this problem, following are some good questions to ask :

        Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?

        A : For the purpose of this question, YES
        Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
        A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

*/
import java.util.*;
public class add_one_to_digits_in_list {
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        Collections.reverse(A);
        int c = 0;
        int p = A.get(0);
        int n = (p+1)%10;
        A.set(0, n);
        c = p==9?1:0;
        for(int i=1 ; i<A.size() ; i++){
            if(c==0){
                c = 0;
            }else{
                 p = A.get(i);
                 n = (p+1)%10;
                A.set(i, n);
                c = p==9?1:0;
            }
        }
        if(c==1){
            A.add(1);
        }
        Collections.reverse(A);
        int i = 0;
        while(A.size()>0 && A.get(i)==0){
            A.remove(0);
        }
        return A;
    }
}
