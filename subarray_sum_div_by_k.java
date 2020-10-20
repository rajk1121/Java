import java.util.*;
public class subarray_sum_div_by_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = {10,-10,-10,10,-7,-8,-6,6,9,-10};
		int k= sc.nextInt();
		System.out.println(function(arr, k));
	}
	public static int function(int[] arr, int k) {
		int ans=0;
		int prefix[] = new int[arr.length+1];
		prefix[0]=0;
		for(int i=1 ; i<prefix.length; i++) {
			prefix[i]=prefix[i-1]+arr[i-1];
			System.out.println(prefix[i]);
		}
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0 ; i<prefix.length;i++) {
			if(prefix[i]<0){
			if(prefix[i]%k==0) {
				ans=ans+hm.get(0);
				int im = hm.get(0)+1;
				hm.put(0,im );
				
			}
			else if(hm.containsKey(k+(prefix[i])%k)) {
					ans+=hm.get(k+(prefix[i])%k);
					int im = hm.get(k+(prefix[i]%k))+1;
					hm.put(k+(prefix[i])%k, im);
				}else {
					hm.put(k+(prefix[i])%k, 1);
				}
			}else {
				if(hm.containsKey(prefix[i]%k)) {
					ans+=hm.get(prefix[i]%k);
					int im = hm.get(prefix[i]%k)+1;
					hm.put(prefix[i]%k, im);
				}else {
					hm.put(prefix[i]%k, 1);
				}
			}
		}
		
		return ans;
	}

}
