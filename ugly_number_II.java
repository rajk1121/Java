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
		System.out.println(nthUglyNumber(200));
		System.out.println(DPnthUglyNumber(200));
	}
	 public static long DPnthUglyNumber(int n) {
		 if(n==1) return 1;
		int[] uglyNo = new int[n];
		int x =0;
		uglyNo[0]= 1;
		int i2=0,i3=0,i5=0;
		int m2 = uglyNo[i2]*2,m3=uglyNo[i3]*3,m5=uglyNo[i5]*5;
		for(int i=1 ; i<n ;i++) {
			int min = Math.min(m2, Math.min(m3, m5));
			uglyNo[i] = min;
//			System.out.println(min);
			if(min==m2) {
				i2++;
				m2 = uglyNo[i2]*2;
				
			} if(min==m3) {
				i3++;
				m3 = uglyNo[i3]*3;
				
			} if(min==m5) {
				i5++;
				m5 = uglyNo[i5]*5;
				
			}
		}
		 return uglyNo[n-1];
	 }

}
