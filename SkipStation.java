import java.util.*;
public class SkipStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=  new Scanner(System.in);
		int t=  sc.nextInt();
		for(int i=0 ; i<t ; i++) {
			int n = sc.nextInt();
			n = n+2;
			int[] arr1 = new int[n+2];
			int[] arr2 = new int[n+2];
			int[] arr3 = new int[n+2];
			if(n>=5) {
				arr1[n-2]=1;
				arr1[n-3]=1; arr2[n-3]=1;
				arr1[n-4]=2; arr2[n-4]=1; arr3[n-4]=1;
				for(int j=n-5 ; j>=0 ; j--) {
					arr1[j] = arr1[j+1] + arr2[j+1] + arr3[j+1];
					arr2[j] = arr1[j+2] + arr2[j+2] + arr3[j+2];
					arr3[j] = arr1[j+3] + arr2[j+3] + arr3[j+3];
				}
				System.out.println(arr1[0]+arr2[0]+arr3[0]);
			}else {
				if(n==4) {
					System.out.println(4);
				}else if(n==3) {
					System.out.println(2);
				}else {
					System.out.println(1);
				}
			}
		}
	}

}
