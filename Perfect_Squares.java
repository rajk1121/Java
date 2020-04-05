import java.util.*;
public class Perfect_Squares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(find(3));
	}
	public static int find(int n) {
		
		if(n==0)
			return 0;
		if(n%Math.sqrt(n)==0) {
			return 1;
		}
		int max= 0;
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1]=1;
		arr[2]=2;
		for(int i=3 ; i<=n ; i++) {
			if(i%Math.sqrt(i)==0) {
				arr[i] =1;
				max = i;
			}else {
				int min = Integer.MAX_VALUE;
				for(int j=1 ; j<Math.ceil(Math.sqrt(i)) ; j++) {
					if(j*j>=i)
						break;
					min = Math.min(arr[j*j]+arr[i-j*j], min);
					
				}
				arr[i] = min;
				
			}
			
			
		}
		return arr[n];
		
	}

}
