import java.util.*;
import java.math.*;
public class nonDivisibleSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> s = new ArrayList<>();
		int n= sc.nextInt();
		int k =sc.nextInt();
		for(int i=0;i<n; i++) {
			s.add(sc.nextInt());
		}
		int [] rem = new int[k];
	    for(int i=0 ; i<s.size() ;i++){
	        rem[s.get(i)%k]++;
	    }
	    int ans=Math.min(rem[0], 1);
	    int limit=0;
	    if(k%2==0) {
	    	rem[k/2]=Math.min(rem[k/2], 1);
	    }
	    for(int i=1 ; i<=k/2 ;i++){
	        ans=ans+Math.max(rem[i], rem[k-i]);
	    }
	    System.out.println(ans);
//	    return ans;
	}

}
