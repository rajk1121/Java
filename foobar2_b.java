import java.util.*;
public class foobar2_b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = 0;
		int ans = 0;
		for(int i=0 ; i<str.length() ; i++) {
			char x = str.charAt(i);
			if(x=='>') {
				len++;
			}else if(x=='<') {
				ans = ans + (len)*2;
			}
		}
		System.out.println(ans);

	}

}
