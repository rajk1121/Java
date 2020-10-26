import java.util.;
public class max_diff_bw_2_elements {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0 ; i<n ; i++)
		        arr[i] = sc.nextInt();
		    int min = arr[0];
		    int i=1, ans = Integer.MIN_VALUE;
		    while(i<n){
		        if(min>arr[i]){
		            min = arr[i];
		        }else{
		            ans = Math.max(ans, arr[i] - min);
		        }
		        i++;
		    }
		    System.out.println(ans==Integer.MIN_VALUE ? -1 : ans);
		    t--;
		}
	}
}
