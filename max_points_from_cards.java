/*
 * There are several cards arranged in a row, and each card has an associated number of points The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

 

Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

Example 2:

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.

Example 3:

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.

Example 4:

Input: cardPoints = [1,1000,1], k = 1
Output: 1
Explanation: You cannot take the card in the middle. Your best score is 1. 

Example 5:

Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
Output: 202

 */
import java.util.*;
public class max_points_from_cards {
    public static int maxScore(int[] nums, int k) {
        int n = nums.length;
         int[] left = new int[n];
         int[] right = new int[n];
         left[0] = nums[0];
         right[n-1] = nums[n-1];
         for(int i=1 ; i<n  ;i++)
             left[i] = left[i-1]+nums[i];
         for(int i=n-2; i>=0 ; i--)
             right[i] = right[i+1]+nums[i];
         int ans = Math.max(left[k-1],right[n-k]);
         
         int gap= n-k;
         for(int i=k-2 ; i>=0 ; i--){
             ans = Math.max(left[i]+right[i+gap+1], ans);
         }
         return ans;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {100,40,17,9,73,75};
		System.out.println(maxScore(nums, 3));
	}

}
