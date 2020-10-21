import java.util.*;
public class max_consecutive_ones_ii {
	 public static int solution(int[] arr, int k){
	        // write your code here
	        int ans = 0;
	        int i=-1, j=-1;
	        int count = 0;
	        while(true){
	            if(count<k){
	                while(j<arr.length-1){
	                   j++;
	                   if(arr[j]==0){
	                      count++;
	                      if(count>k){
	                        j--;
	                        count--;
	                        break;
	                          
	                      }
	                   }
	                }
	            }
	            ans = Math.max(ans, j-i);
	            if(count==k){
	                while(i<arr.length - 1){
	                    i++;
	                    if(arr[i]==0){
	                        count--;
	                        break;
	                    }
	                }
	            }
	            if(j==arr.length - 1)
	                break;
	        }
	        return ans;
	    }
	    
		public static void main(String[] args) {
			Scanner scn = new Scanner(System.in);
	        int n = scn.nextInt();
	        int[] arr = new int[n];
	        for(int i = 0 ; i  < n; i++){
	            arr[i] = scn.nextInt();
	        }
	        int k = scn.nextInt();
	        System.out.println(solution(arr,k));
		}
}
