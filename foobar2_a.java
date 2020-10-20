import java.util.*;
public class foobar2_a {
    public static String solution(long x, long y) {
        long n = y + (x-1);
		long prev = 1;
		for(long i=2;  i<=n ; i++) {
			prev = prev + (i-1);
		}
		long ans = prev + (x-1);
        String ansS = "" + ans;
        return ansS;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long y = sc.nextLong();
		System.out.println(solution(x, y));
	}

}
