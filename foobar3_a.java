import java.math.*;
public class foobar3_a {
	public static String solution(String x, String y) {
        BigInteger X = new BigInteger(x);
        BigInteger Y = new BigInteger(y);
        BigInteger ans = new BigInteger("0");
//        int z = X.compareTo(Y);
        BigInteger one = new BigInteger("1");
        while(X.compareTo(one)==1 && Y.compareTo(one)==1 ){
        	
        
            if(X.compareTo(Y)<0){
                Y = Y.subtract(X.multiply(Y.divide(X)));
            }else if(Y.compareTo(X)<0){
                X = X.subtract(Y.multiply(X.divide(Y)));
            }else{
                break;
            }
            ans = ans.add(one);
//            System.out.println(X+" "+Y);
        }
        if(X.compareTo(one)==0)
        	ans = ans.add(Y.subtract(X));
        if(Y.compareTo(one)==0)
        	ans = ans.add(X.subtract(Y));
        if(X.compareTo(one) == 0 || Y.compareTo(one)==0)
           return ans.toString();
       
       return "Impossible";
        
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("1", "2"));
	}

}
