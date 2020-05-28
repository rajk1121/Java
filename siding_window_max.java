/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 */

import java.util.*;
public class siding_window_max {

	public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        q.add(0);
		List<Integer> ans = new ArrayList<>();
        for(int i=1 ; i<k; i++) {
			while(!q.isEmpty() && nums[i]>nums[q.getLast()]) {
				q.removeLast();
			}

			q.addLast(i);
		}
//        System.out.println(q);
        for(int i=k ; i<nums.length ; i++) {
        	ans.add(nums[q.getFirst()]);
        	if(i-q.getFirst()==k)
        		q.removeFirst();
        	if(q.isEmpty())
        		q.add(i);
        	else {
        		while(!q.isEmpty()&& nums[i]>nums[q.getLast()]) {
//        			System.out.println(q.getLast());
    				q.removeLast();
    			}

    			q.addLast(i);
        	}
        	System.out.println(ans);
        }
        ans.add(nums[q.getFirst()]);
        System.out.println(ans);
//        int[] ians = ans.toArray();
//        for(int i=0 ; i<ans.)
		return new int[0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=  {1,3,1,2,0,5};
		System.out.println(maxSlidingWindow(nums, 3));
	}

}
