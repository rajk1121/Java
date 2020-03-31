/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

 */
public class decode_waays {
	 public int numDecodings(String s) {
	        
	        if(s.length()<=1){
	            if(s.length()==1 && s.charAt(0)!='0'){
	                return 1;
	            }else
	                return 0;
	        }
	        if(s.charAt(0)=='0')
	            return 0;
	        int last;
	        if(s.charAt(s.length()-1)=='0')
	            last = 0;
	        else
	            last = 1;
	        int second_last = last;
	        // if(s.charAt(s.length()-2)!='0' && last==0)
	        //     second_last++;
	        // else
	        //     second_last= last;
	        int i = s.length()-2;
	        
	        if((s.charAt(i) - '0')*10 + s.charAt(i+1) - '0' <= 26 && s.charAt(i)!='0')
	            second_last++;
	        else if(s.charAt(i)=='0')
	            second_last = 0;
	        i--;
	        if(i<0)
	            return second_last;
	        int third_last = 0;
	        if((s.charAt(i) - '0')*10 + s.charAt(i+1) - '0' <= 26  && s.charAt(i)!='0'){
	                third_last =  last +  second_last;
	        }else if(s.charAt(i)=='0'){
	            third_last = 0 ;
	        }else{
	            third_last = second_last;
	        }
	        i--;
	        
	            last = second_last;
	            second_last = third_last;
	        while(i>=0){
	            if(last==0 && second_last == 0)
	                return 0;
	            if(s.charAt(i+1)=='0'&&(s.charAt(i)-'0'>=3))
	                return 0;
	            if(s.charAt(i)=='0'){
	                i--;
	                third_last = 0;
	                 last = second_last;
	            second_last = third_last;
	                continue;
	            }
	                
	            if((s.charAt(i) - '0')*10 + s.charAt(i+1) - '0' <= 26 ){
	                third_last =  last + second_last;
	            }else{
	                third_last = second_last ;
	            }
	           i--; 
	            
	            last = second_last;
	            second_last = third_last;
	            
	            // System.out.println(third_last);
	        }
	        return third_last;
	        
	    }
}
