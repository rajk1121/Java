
public class rotate_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matrix = {
		                   {1,2,3,4},
		                   {5,6,7,8},
		                   {9,10,11,12},
		                   {13,14,15,16}
	};
//		int[][] matrix= {{1,2},
//						 {3,4}};
		 int en = matrix[0].length-1;
	        int em=en;
	        int sn=0;
	        int sm=0;
	        while( sm<em && sn<en){
	            int i=sn;
	            int next=0;
	            int current=0;
	            
	            int j=0;
	            int dir=0;
	            while(j<en-sn){
	                
	                if(dir==0){
	                    next = matrix[sn+j][em];
	                    current = matrix[sn][sm+j];
	                    matrix[sn+j][em] = current;
	                    current = next;
	                    dir=1;
	                
	                }else if(dir==1){
	                    next = matrix[en][em-j];
	                    matrix[en][em-j] = current;
	                    current=next;
	                    dir=2;
	                    
	                }else if(dir==2){
	                    next = matrix[en-j][sm];
	                    matrix[en-j][sm] = current;
	                    current=next;
	                    dir=3;
	                }else if(dir==3){
	                    matrix[sn][sm+j] = current;
	                    dir=0;
	                    j++;
	                }
	               
	            }
	            sn++;
	            sm++;
	            en--;
	            em--;
	        }
	        for(int k= 0; k<matrix.length;k++) {
	        	for(int l=0;  l<matrix.length;l++) {
	        		System.out.print(matrix[k][l]+" ");
	        	}
	        	System.out.println();
	        	
	        }
            System.out.println("*************");
	}

}
