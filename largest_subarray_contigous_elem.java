import java.util.*;

public class largest_subarray_contigous_elem {
	public static int solution(int[] arr) {
		// write your code here
		int ans = 0;
		for(int i=0 ; i<arr.length ; i++){
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            HashSet<Integer> set = new HashSet<>();
            for(int j=i ; j<arr.length ; j++){
                if(set.contains(arr[j]))
                    break;
                set.add(arr[j]);
                min = Math.min(arr[j], min);
                max = Math.max(arr[j], max);
                if(max - min + 1 == set.size())
                    ans = Math.max(ans, j - i+1);
            }
        }
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
