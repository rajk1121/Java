import java.util.*;
public class column_finder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		String str = "";
		while(n!=0) {
			int rem = n%26;
			if(rem==0) {
				str = arr[25]+str;
				n--;
			}else {
				str = arr[rem-1]+str;
			}
			n=n/26;
		}
		
		System.out.println(str);
		sc.close();
	}

}
