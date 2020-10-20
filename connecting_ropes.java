import java.util.*;
public class connecting_ropes {
	 static int ConnectRopes(int length[], int n) 
		{ 
		    // Your code goes here
		   PriorityQueue<Integer> q = new PriorityQueue();
		   for(int i=0 ; i<n ; i++){
		       q.add(length[i]);
		   }
		   int answer = 0;
		   answer = answer+q.peek();
		   q.remove();
		   if(q.size()==0){
		       return answer;
		   }
		   answer = answer+q.peek();
		   q.remove();
		   if(q.size()==0){
		       return answer;
		   }
//		   System.out.println(q.size());
		   q.add(answer);
//		   System.out.println(q.size());
		   while(q.size()>=2){
			   int temp1 = q.peek();
			   q.remove();
			   int temp2 = q.peek();
			   q.remove();
			   int sum = temp1+temp2;
		       answer= answer+sum;
//		       q.remove();
		       q.add(sum);
		   }
		   if(q.size()==1) {
			   return answer;
		   }
		   if(q.size()!=0) {

			   answer+=q.peek();
			   q.remove();
		   }
		   if(q.size()!=0) {

			   answer+=q.peek();
			   q.remove();
		   }
		   return answer;
		} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] length = {1,2,3};
		System.out.println(ConnectRopes(length, length.length));
	}

}
