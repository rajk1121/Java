import java.util.*;
public class last_stone_weight {
			public static int lastStoneWeight(int[] stones) {
				if(stones.length==0)
					return 0;
				if(stones.length==1) {
					return stones[0];
				}
				PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
				for(int i=0 ; i<stones.length; i++)
					q.add(stones[i]);
				while(q.size()>1) {
					int f = q.remove();
					int s = q.remove();
					if(f!=s) {
						q.add(Math.abs(f-s));
					}
				}
				if(q.size()==0)
					return 0;
				
				return q.remove();
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {2,7,4,1,8};
		System.out.println(lastStoneWeight(stones));

	}

}
