//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. 
/* For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
import java.util.*;

public class generate_parantheses {
	static ArrayList<String> set = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		generateParenthesis(n,n,"");
		System.out.println(set.size());
		System.out.println("*////////////////////////////");
	}
	public static void generateParenthesis(int open, int close, String str) {
		// TODO Auto-generated method stub
		if(open==0 && close==0) {
//			System.out.println(str);
			set.add(str);
			return ;
		}
		if(open>0) {
			String istr = str+"(";
			generateParenthesis(open-1, close, istr);	
		}
		if(close>open) {
			String istr = str+")";
			generateParenthesis(open, close-1, istr);
		}
		
	}

}
