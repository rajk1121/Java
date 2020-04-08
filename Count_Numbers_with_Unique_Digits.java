import java.util.*;
public class Count_Numbers_with_Unique_Digits {
	 public static int countNumbersWithUniqueDigits(int n) {
	        Queue<Integer> q = new LinkedList<>();
	        if(n==0)
	            return 2;
	        q.add(1);
	        q.add(2);
	        q.add(3);
	        q.add(4);
	        q.add(5);
	        q.add(6);
	        q.add(7);
	        q.add(8);
	        q.add(9);
	        // q.add(1);
	        int answer = 1;
	        while(q.size()!=0){
	            boolean[] arr = new boolean[10];
	            int num = q.remove();
//	            System.out.println(num);
	            int x = num;
	            int y = num;
	            if(num>=Math.pow(10,n) || num<0)
	                break;
	            answer++;
	            while(y!=0){
	                arr[y%10] = true;
	                y=y/10;
	            }
	            for(int i=0 ; i<=9 ; i++){
	                if(!arr[i])
	                    q.add(x*10+i);
	            }
	        }
	        return answer;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(2>Math.pow(10, 2));
		System.out.println(countNumbersWithUniqueDigits(10));
	}

}
