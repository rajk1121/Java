import java.util.*;
public class valid_parenthesis_string {
	public static boolean find(String s) {
        Stack<Integer> stack = new Stack();
        Stack<Integer> used_star_stack = new Stack();
        Stack<Integer> star_stack = new Stack();
        int count = 0;
        int used = 0;
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(i);   
            }else if(ch=='*'){
               count++;
               star_stack.push(i);
            }else{
            	if(count==0) {
            		if(!stack.isEmpty())
            			stack.pop();
            		else
            			return false;
            		
            	}
            	else{
            		if(stack.size()==0) {
            			used++;
                		count--;
                		if(star_stack.size()==0)
                			return false;
                		
                		star_stack.pop();
                		used_star_stack.push(i);
            		}else {
            			if(stack.peek()>star_stack.peek()) {
            				stack.pop();
            			}else {
            				used++;
            				count--;
            				used_star_stack.push(i);
            			}
            		}
            	 }
               }
            }
        while(stack.size()!=0 && star_stack.size()!=0) {
        	if(used_star_stack.size()!=0) {
        		if(used_star_stack.peek()>stack.peek()) {
        			used_star_stack.pop();
        			stack.pop();
        		}else {
        			if(star_stack.size()!=0 && star_stack.peek()>stack.peek()) {
        				
                			star_stack.pop();
                			stack.pop();
                		
                	}else {
                		return false;
                	}
        		}
        	}else if(star_stack.size()!=0 && star_stack.peek()>stack.peek()) {
        		star_stack.pop();
    			stack.pop();
        	}else {
        		return false;
        	}
        }
       if(stack.size()==0) {
    	   return true;
       }
       return false;
    
//    if(stack.size()!=0){
//        return false;
//    }else{
//        return true;
//    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "*****))))))))))))(((((((((****)";
		System.out.println(find(str));

	}

}
