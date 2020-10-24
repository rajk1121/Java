import java.util.*;
public class count_of_subarrays_with_sum_divisible_by_k_official {
	 public static int solution(int[] arr, int k) {
	        // write your code here
	        HashMap<Integer, Integer> map = new HashMap<>();
	        map.put(0, 1);
	        int sum = 0, ans = 0;
	        for(int i=0; i<arr.length ; i++){
	            sum = ((sum+arr[i])%k + k)%k;
	            if(map.containsKey(sum)){
	                ans = ans + map.get(sum);
	                map.put(sum, map.get(sum)+1);
	            }else{
	                map.put(sum, 1);
	            }
	        }
	        return ans;
	    }
	    
	    public static void main(String[] args) {
	        Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = scn.nextInt();
	        }
	        int k = scn.nextInt();
	        System.out.println(solution(arr, k));
	    }
}
