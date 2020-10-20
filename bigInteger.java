import java.util.*;
import java.math.*;
public class bigInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger ans = new BigInteger("1");
        for(int i=2; i<=n ; i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        System.out.println(ans);
        return;

	}

}
