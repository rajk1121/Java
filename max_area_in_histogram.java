import java.util.*;
public class max_area_in_histogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int T=  sc.nextInt();
		while(T>0){
		    int N = sc.nextInt();
		    int arr[] = new int[N];
		    for(int i=0  ; i<N; i++){
		        arr[i] = sc.nextInt();
		        
		    }
		    Stack<Integer> s1 = new Stack<>();
//		    s1.push(0);
		    int i=0;
		    int max=Integer.MIN_VALUE;
		    while(i<N) {
		    	if(s1.empty() || arr[s1.peek()]<=arr[i]) {
//		    		System.out.println(i);
		    		s1.push(i);
		    		i++;
		    	}else {
//		    		while(!s1.empty() && arr[s1.peek()]>arr[i] ) {
		    			Integer peek = (Integer)s1.peek();
//		    			System.out.println(peek.intValue()+"////");
//		    			System.out.println();
		    			Integer tosindex = (Integer)s1.pop();
//		    			System.out.println(tosindex.intValue()+"********");
		    			if(s1.empty()) {
		    				int imax = arr[tosindex]*i;
		    				if(imax>max) {
		    					max=imax;
		    				}
		    			}else {
//			    			Integer pelek = (Integer)s1.peek();
//			    			System.out.println(pelek.intValue()+"////");
		    				
		    				int imax = arr[tosindex]*(i-s1.peek().intValue()-1);
		    				if(imax>max) {
		    					max=imax;
		    				}
		    			}
//		    		}
//		    		System.out.println(i);
//		    		s1.push(i);
//
//	    			i++;
		    	}
		    }
		    if(!s1.empty()) {
		    	while(!s1.empty()) {
		    		Integer tosindex = s1.pop();

	    			int imax = 0;
		    		if(s1.empty()) {
		    			imax = arr[tosindex]*(i);
		    		}else {
		    			imax = arr[tosindex]*(i-s1.peek()-1);
		    		}
		    		if(imax>max) {
		    			max= imax;
		    		}
		    	}
		    }
		    System.out.println(max);
		    
		    
		    T--;
		}
	}

}
