import java.util.*;
class MinStack{
	ArrayList<Integer> stack;
    int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        min = 0;
    }
    
    public void push(int x) {
        // stack.add(x);
        if(stack.size()==0){
            min =x;
            stack.add(0);
        }else{
            if(x<min){
                stack.add(x-min);
                min = x;
            }else{
                stack.add(x-min);
            }
        }
    }
    
    public void pop() {
        int t = stack.remove(stack.size()-1);
        if(t<0){
            // int e = min;
            min = min-t;
            // return e;
        }else if(t>0 && min == Integer.MIN_VALUE) {
        	min=Integer.MAX_VALUE-t+1;
        }
        
    }
    
    public int top() {
        int t = stack.get(stack.size()-1);
        if(t<0){
            return min;
        }else if( min==Integer.MIN_VALUE && t>0) {
        	return min;
        }
        else{
            return min+t;
        }
    }
    
    public int getMin() {
        return this.min;
    }

}
public class min_stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack s = new MinStack();
		s.push(2147483646);
		s.push(2147483646);
		s.push(2147483647);
		System.out.println(s.top());
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		s.push(2147483647);
		System.out.println(s.top());
		System.out.println(s.getMin());
		s.push(-2147483648);
//		System.out.println(s.stack.get(s.stack.size()-1));
//		System.out.println(s.min+"  ***");
		System.out.println(s.top());
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
		

	}

}
