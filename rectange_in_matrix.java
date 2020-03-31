import java.util.*;
/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */
public class rectange_in_matrix {
public static int maximalRectangle(int[][] inmatrix) {
        
        int m = inmatrix.length;
        int n = inmatrix[0].length;
        if(m==0)
            return 0;
        int max =0;
        Stack<Integer> s = new Stack<>();
        for(int i=0 ; i<n ; i++){
            if(s.isEmpty() || inmatrix[0][s.peek()]<inmatrix[0][i]){
                s.push(i);
//                System.out.println(i);
            }
            else{
                while(  !s.isEmpty()&& inmatrix[0][s.peek()]>=inmatrix[0][i] ){
                    int index = s.pop();
                    if(s.isEmpty()){
                        max = Math.max(max, inmatrix[0][index]*(i));
                    }else{
                        max = Math.max(max, inmatrix[0][index]*(i - s.peek() - 1));
                    }
                }
                s.push(i);
            }
        }
        while(!s.isEmpty()){
            int index = s.pop();
             if(s.isEmpty()){
                    max = Math.max(max, inmatrix[0][index]*(index+1));
                }else{
                    max = Math.max(max, inmatrix[0][index]*(index - s.peek()));
                }
         }
//        System.out.println(max);
        for(int i=1 ; i < m ; i++){
            for(int j=0 ; j< n ;j++){
                if(inmatrix[i][j]==1)
                    inmatrix[i][j] = inmatrix[i-1][j]+ 1;
                else
                    inmatrix[i][j] = 0;
            }
            for(int j=0 ; j<n ; j++) {
            	System.out.print(inmatrix[i][j]+" ");
            }
            System.out.println();
            s = new Stack<>();
            for(int j=0 ; j<n ; j++){
//System.out.println(s.size());
//            	if(s.size()>0) {
//            		System.out.println(s.peek());
//            		System.out.println(inmatrix[i][s.peek()]<=inmatrix[i][j]);
//            	}
                if(s.isEmpty() || inmatrix[i][s.peek()]<inmatrix[i][j]){
                    s.push(j);
                }
                else{
                    while(!s.isEmpty() && inmatrix[i][s.peek()]>=inmatrix[i][j]){
                        int index = s.pop();
                        if(s.isEmpty()){
                            max = Math.max(max, inmatrix[i][index]*(j));
                        }else{
                            max = Math.max(max, inmatrix[i][index]*(j - s.peek() - 1));
                        }
                    }
                    s.push(j);
                }
            }
            while(!s.isEmpty()){
                int index = s.pop();
                 if(s.isEmpty()){
                        max = Math.max(max, inmatrix[i][index]*(index+1));
                    }else{
                        max = Math.max(max, inmatrix[i][index]*(index - s.peek()));
                    }
             }
            
        System.out.println(max);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] inmatrix = {
				{1,1}
		};
		/*
		 * [["0","1","1","0","1"],
		 *  ["1","1","0","1","0"],
		 *  ["0","1","1","1","0"],
		 *  ["1","1","1","1","0"],
		 *  ["1","1","1","1","1"],
		 *  ["0","0","0","0","0"]]

		 */
		
		System.out.println(maximalRectangle(inmatrix));
	}

}
