import java.util.*;
//Given a number ‘n’, find the smallest number ‘p’ such that if we multiply all digits of ‘p’, we get ‘n’. The result ‘p’ should have minimum two digits.
public class Smallest_No_multiply_to_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=  new Scanner(System.in);
		int k=sc.nextInt();
		int pow=1;
		int ans=0;
		for(int i=9 ;i>=2;i--) {
			if(k%i==0 && k!=1) {
				k=k/i;
				ans =ans+ i*pow;
				pow= pow*10;
				i++;
			}
		}
		if(k!=1) {
			System.out.println("Not possible");
			return ;
		}
		System.out.println(ans);
	}

}
