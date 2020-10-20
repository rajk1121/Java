import java.util.*;
public class letter_combination {
	 static String[] arr = {
		        "abc",
		        "def",
		        "ghi",
		        "jkl",
		        "mno",
		        "pqrs",
		        "tuv",
		        "wxyz"
		    };
		    public static List<String> letterCombinations(String digits) {
		        List<String> answer = new ArrayList<>();
		        answer = formulate(digits,0);
		        return answer;
		    }
		    public static List<String> formulate(String digits,int index ){
		        if(digits.length()==0) {
		        	return new ArrayList<>();
		        }
		    	if(index>=digits.length()){
		            List<String> answer = new ArrayList<>();
		            answer.add("");
		            return answer;
		        }
		        List<String> answer = new ArrayList<>();
//		        for(int i=index;index<digits.length();index++){
		            List<String> ianswer = formulate(digits, index+1);
//		            char digit = digits.charAt(i);
		            for(int j=0 ; j<ianswer.size();j++){
		               for(int k=0;k<arr[Integer.parseInt(digits.substring(index, index+1))-2].length();k++) {
		            	   answer.add(arr[Integer.parseInt(digits.substring(index, index+1))-2].charAt(k)+ianswer.get(j));
		               }
		            }
//		        }
		        return answer;
		    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "";
		List<String> answer=letterCombinations(digits);
		System.out.println(answer);

	}

}
