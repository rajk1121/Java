import java.util.*;

public class bakspace_string_compare {
	public static boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack();
        Stack<Character> s2 = new Stack();
        for(int i=0 ; i<S.length() ; i++){
            if(S.charAt(i)=='#'){
                if(!s1.isEmpty())
                    s1.pop();
            }else{
                s1.push(S.charAt(i));
            }
        }
        for(int i=0 ; i<T.length() ; i++){
            if(T.charAt(i)=='#'){
                if(!s2.isEmpty())
                    s2.pop();
            }else{
                s2.push(T.charAt(i));
            }
        }
//        System.out.println(5);
        if(s1.isEmpty() && s2.isEmpty())
            return true;
//        System.out.println(8);
        if(s1.isEmpty() || s2.isEmpty())
            return false;
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.peek()!=s2.peek())
                break;
            s1.pop();
            s2.pop();
        }
//        System.out.println("j");
        if(s1.isEmpty() && s2.isEmpty())
            return true;
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(backspaceCompare("a##c", "#a#c"));
	}

}
