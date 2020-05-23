import java.math.*;
public class foobar3_a {
	public static String solution(String x, String y) {
        BigInteger X = new BigInteger(x);
        BigInteger Y = new BigInteger(y);
        BigInteger ans = new BigInteger("0");
//        int z = X.compareTo(Y);
        BigInteger one = new BigInteger("1");
//        System.out.println(X.compareTo(Y));
        while(X.compareTo(one)==1 && Y.compareTo(one)==1 ){
        	
        	
            if(X.compareTo(Y)==-1){
            	ans = ans.add(Y.divide(X));
            	Y = Y.subtract(X.multiply(Y.divide(X)));
            }else if(Y.compareTo(X)==-1){
            	 ans = ans.add(X.divide(Y));
                X = X.subtract(Y.multiply(X.divide(Y)));
            }else{
                break;
            }
//            System.out.println(X+" "+Y);
        }
        System.out.println("ddeded");
        if(X.compareTo(one)==0)
        	ans = ans.add(Y.subtract(X));
        if(Y.compareTo(one)==0)
        	ans = ans.add(X.subtract(Y));
        if(X.compareTo(one) == 0 || Y.compareTo(one)==0)
           return String.valueOf(ans);
       
       return "Impossible";
        
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("111", "2"));
	}

}
