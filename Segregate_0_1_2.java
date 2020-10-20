import java.util.*;
public class Segregate_0_1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		int N=sc.nextInt();
		int[] arr = new int[N];
		for(int i=0 ; i<N;i++) {
			arr[i]=sc.nextInt();
		}
		int low=0,mid=0;
		int high = arr.length-1;
		while(mid<=high) {
			if(arr[mid]==0) {
				int temp = arr[low];
				arr[low]=arr[mid];
				arr[mid]=temp;
				low++;
				mid++;
			}
			else if(arr[mid]==1) {
				mid++;
			}else if(arr[mid]==2) {
				int temp = arr[mid];
				arr[mid]=arr[high];
				arr[high]=temp;
				high--;
			}
		}
		for(int i=0 ; i<N;i++) {
			System.out.println(arr[i]);
		}
	}

}
