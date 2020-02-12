//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
import java.util.*;
public class continous_subarray_equal_to_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	int n=  sc.nextInt();
	int k = sc.nextInt();
	int []arr = new int[n];
	for(int i=0 ; i<n ; i++) {
		arr[i]=  sc.nextInt();
		
	}
	int []prefix = new int[n+1];
	prefix[0] = 0;
	for (int i=0 ; i<n ; i++) {
		prefix[i+1] = arr[i]+prefix[i];
	}
	

	int count =0;
	HashMap<Integer, Integer>check = new HashMap<>();
	for(int i=0 ; i<n+1 ; i++) {
		if(check.containsKey(prefix[i]-k)) {
			int val = check.get(prefix[i]-k);
			count+=val;
		}
		if(check.containsKey(prefix[i])) {
			int val = check.get(prefix[i])+1;
			check.put(prefix[i], val);
			
		}else {
			check.put(prefix[i], 1);
		}
	}
//	for(int i=1 ; i<n+1 ; i++) {
//		if(prefix[i]-k==0) {
//			if(check.containsKey(0)) {
//				System.out.println("////");
//				count = count+check.get(prefix[i]-k)-1;
//			}
//		}
//		else if(check.containsKey(prefix[i]-k)) {
//			count = count+check.get(prefix[i]-k);
//		}
//	}
	System.out.println(count);
	}

}
