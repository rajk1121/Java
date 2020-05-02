import java.util.*;
public class basic_calculator_II {
	public static int calculate(String s) {
		 Stack<Integer> number = new Stack();
	        Stack<Character> sign = new Stack();
	        int i=0;
	        char type = ' ';
	        while(i<s.length() && s.charAt(i)==' ')
	            i++;
	        int j=i;
	        while(i<s.length() && s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9)
	            i++;
	        number.push(Integer.parseInt(s.substring(j, i)));
	        while(i<s.length() && s.charAt(i)==' ')
	            i++;
	        while(i<s.length()) {
	        	if(s.charAt(i)=='+' || s.charAt(i)=='-') {
	        		if(number.size()==2) {
	        			int num1 = number.pop();
	        			int num2 = number.pop();
	        			char psign = sign.pop();
//	        			System.out.println(num1+" "+num2+" "+sign);
	        			if(psign=='+')
	        				number.push(num1+num2);
	        			else
	        				number.push(num2-num1);
	        			
	        		}
	        		sign.push(s.charAt(i));
	        		i++;
        			while(i<s.length() && s.charAt(i)==' ')
        	            i++;
        	        j=i;
        	        while(i<s.length() && s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9)
        	            i++;
//        	        System.out.println(i+" "+j);
        	        number.push(Integer.parseInt(s.substring(j, i)));
        	        
	        	}else {
	        		char op = s.charAt(i);
	        		int num1 = number.pop();
	        		i++;
	        		while(i<s.length() && s.charAt(i)==' ')
        	            i++;
        	        j=i;
        	        while(i<s.length() && s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9)
        	            i++;
        	        number.push(Integer.parseInt(s.substring(j, i)));
        	        int num2 = number.pop();
//        	        System.out.println(num1+" "+num2+" "+);
        	        if(op=='/')
        	        	number.push(num1/num2);
        	        else
        	        	number.push(num1*num2);
	        	}
	        	 while(i<s.length() && s.charAt(i)==' ')
	 	            i++;
	        }
	        
	        while(!sign.isEmpty()) {
	        	int num1 = number.pop();
	        	int num2 = number.pop();
	        	if(sign.pop()=='+')
	        		number.push(num1+num2);
	        	else
	        		number.push(num2-num1);
	        }
	        return number.pop();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "   282 -   1   *2 * 13-30-2*2*2/2-95/5*2+55+804+3024      ";
//		System.out.println(Integer.parseInt(s.substring(4,5)));
		System.out.println(calculate(s));
	        
	}

}
