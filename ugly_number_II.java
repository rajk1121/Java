import java.util.*;
public class ugly_number_II {
	 static List<Boolean> ugly;
	    public static int nthUglyNumber(int n) {
	        ugly = new ArrayList<>();
	        int i=1;
	        int x =1;
	        ugly.add(false);
	        ugly.add(true);
	        while(i<n){
	            x++;
	            if(isUgly(x)){
	                i++;
	                ugly.add(true);   
	            }else{
	                
	                ugly.add(false);
	            }
	            
	        }
	        
	        return x;
	    }
	    public static boolean isUgly(int number){
	        int x = number;
	        number = GDP(number, 2);
	        if(number<x && ugly.get(number) )
	            return true;
	        number = GDP(number, 3);
	        if(number<x && ugly.get(number) )
	            return true;
	        number = GDP(number, 5);
	        
	        return number==1?true:false;
	    }
	    public static int GDP(int x, int a){
	        while(x%a==0){
	            x = x/a;
	            if(ugly.get(x))
	                x = 1;
	        }
	        return x;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthUglyNumber(100));
	}

}
