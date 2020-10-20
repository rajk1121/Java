import java.util.*;
public class leaderboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int []scores = new int[n];
		for(int i=0;i<n;i++) {
			scores[i]=sc.nextInt();
		}
		int m= sc.nextInt();
		int []alice= new int[m];
		for(int i=0;i<m;i++) {
			alice[i]=sc.nextInt();
		}
		int rank=1;
        int max = scores.length;
        int ans[] = new int[alice.length];
        int i=1;
        boolean found=false;
        for(int j=0 ;j<alice.length; j++){
            rank=0;
            int ascore= alice[j];
            if(scores.length==1){
                
                if(ascore<scores[0]){
                    ans[j]=2;
                }else{
                    ans[j]=1;
                }
            }else{
                found=false;
                i=0;
                while(i<max-1){
                  if(ascore<scores[i] ){
                	  if(scores[i]==scores[i+1]) {
                      rank++;
                      i+=2;
                	  }else {
                		  rank++;
                		  i+=1;
                	  }
                  }else if(ascore>=scores[i]){
                      rank++;
                      found=true;
                      i++;
                      break;
                  }  
                }
                if(found){
                    ans[j]=rank;
                    
                }
                else if(ascore<scores[i] ) {
                	rank++;
                	i++;
                }else {
                	rank++;
                	found=true;
                }
                if(found){
                    ans[j]=rank;
                    
                }else{
                    ans[j]=rank+1;
                }
                max=i;
            }
        }
        for( i=0; i<ans.length;i++) {
        	System.out.println(ans[i]);
        }
//        return ans;

	}

}
