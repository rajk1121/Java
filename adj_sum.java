/*
 * Given a list of integers, write a programme that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative. In other words, out of all subsets, which do not contain adjacent numbers of a given array (excluding the empty subset), find the maximum subset sum.
For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
Follow-up: Can you do this in O(N) time and constant space?
 */
import java.util.*;
public class adj_sum {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[]  arr = new int[n];
        for(int i=0 ; i<n ; i++)
            arr[i] = sc.nextInt();
        if(n==1){
            System.out.println(arr[0]);
            return;
        }
        int fGroup = 0, sGroup= 0;
        int fIndex = 0, sIndex = 1;
        int first = arr[0];
        int second = arr[1];
        for(int i=2 ; i<n ; i++){
            //first group
            if(i==fIndex+1){
                if(first < fGroup+arr[i]){
                    int temp = fGroup;
                    fGroup = first;
                    first = temp + arr[i];
                    fIndex = i;
                }
            }else{
                if(arr[i]>0){
                    fIndex = i;
                    fGroup = first;
                    first = first+arr[i];
                }
            }
            //second group
            if(i==sIndex+1){
                if(second < sGroup+arr[i]){
                    int temp = sGroup;
                    sGroup = second;
                    second = temp + arr[i];
                    sIndex = i;
                }
            }else{
                if(arr[i]>0){
                    sIndex = i;
                    sGroup = second;
                    second = second+arr[i];
                }
            }
        }
        
         System.out.println(Math.max(first, second));
	}

}
