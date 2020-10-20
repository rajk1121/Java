import java.util.*;
public class palindromeInteger {
	public static boolean tell(int x) {
		 if(x<0){
	            return false;
	        }
	        if(x==0){
	            return true;
	        }
	        int refx = x;
	        int size=0;
	        
	        while(refx!=0){
	            refx = refx/10;
	            size++;
	        }
	        if(size%2==0){
	            int pow=10;
	            int rev = 0;
	            int isize = size/2;
	            while(size>isize){
	                int rem = x%10;
	                rev=  rem+rev*pow;
	                x/=10;
	                size--;
	            }
	            if(rev == x){
	                return true;
	            }else{
	                return false;
	            }
	        
	        }else{
	            int pow=10;
	            int rev = 0;
	            int isize = size/2;
	            while(size>isize+1){
	                int rem = x%10;
	                rev=  rem+rev*pow;
	                x/=10;
	                size--;
	                
	            }
	            if(rev == x/10){
	                return true;
	            }else{
	                return false;
	            }
	        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2222222;
		System.out.println(tell(x));
	}

}
