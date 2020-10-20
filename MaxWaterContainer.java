import java.util.*;
public class MaxWaterContainer {
 /*Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.*/
	//https://leetcode.com/problems/container-with-most-water/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] height = new int[n];
		for(int j=0 ; j<n ; j++) {
			height[j] = sc.nextInt();
		}
        int j=height.length-1;
        int ans=0;
        int imax=0;
        while(i<j){
            imax = Math.abs(Math.min(height[i],height[j])*(j-i));
            if(imax>ans){
                ans = imax;
            }
            if(height[i]>=height[j]){
                j--;
            }else{
                i++;
            }
        }
        System.out.println(ans);
	}

}
