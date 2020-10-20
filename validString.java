import java.util.ArrayList;
import java.util.Scanner;

public class validString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = new int[26];
		 ArrayList<Integer> abc =new ArrayList<>();
		 String s = new String();
		 Scanner sc = new Scanner(System.in);
		 s = sc.next();
		 
		 boolean visited[] = new boolean[26];
	        int std = 97;
	        for(int i=0 ; i<s.length() ; i++){
	            int ch = (int)(s.charAt(i));
	            arr[ch-std]+=1;
	            visited[ch-std]=true;
	        }
	        for(int i=0;i<arr.length;i++) {
	        	if(visited[i]) {
	        		abc.add(arr[i]);
	        	}
	        }
	        if(abc.size()==1) {
				 System.out.println("YES");
				 return;
			 }
	        int maj=Integer.MIN_VALUE;
	        for(int i=0 ; i<abc.size()-1; i++) {
//	        	System.out.println(arr[i]+" "+Math.abs(arr[i]-first)+" "+(char)(i+97));
	        	if(abc.get(i)==abc.get(i+1)) {
	        		maj=abc.get(i);
	        		break;
	        	}
	        	
	        }
	        boolean got=false;
	        if(maj==Integer.MIN_VALUE) {
	        	System.out.println("NO");
	        	return;
	        }
	        for(int i=0 ; i<abc.size(); i++) {
	        	if(maj!=abc.get(i)) {
	        		if(maj-abc.get(i)!=-1) {
	        			System.out.println("NO");
	        			return;
	        		}
	        	}
	        }
	        System.out.println("YES");
	        

	}

}
