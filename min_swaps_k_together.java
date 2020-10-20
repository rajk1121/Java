
import java.util.*;
public class min_swaps_k_together {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0 ; i<n ; i++)
		        arr[i] = sc.nextInt();
		    int k =sc.nextInt();
		    int cnt = 0;
		    for(int i=0; i <n ; i++){
		        if(arr[i]<=k)
		            cnt++;
		    }
		  //  System.out.println(cnt);
		    int ans = n;
		    int x = 0;
		    while(x<=n-cnt){
		        int bad = 0;
		        for(int i=x ; i<x+cnt ; i++){
		            if(arr[i]>k){
		                bad++;
		            }
		        }
		  //  System.out.println(bad);
		        ans = Math.min(ans, bad);
		        x++;
		    }
		    System.out.println(ans);
		    t--;
		}
	}
}
