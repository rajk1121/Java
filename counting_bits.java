
public class counting_bits {
	  public int[] countBits(int num) {
	        
	        int[] answer = new int[num+1];
	        if(num==0)
	            return answer;
	        if(num==1){
	            answer[0] = 0;
	            answer[1] =1;
	            return answer;
	        }
	        answer[0]=0;
	        answer[1]=1;
	        for(int i=2; i<num+1 ; i++){
	            if(i%2==0){
	                answer[i] = answer[i/2];
	            }else{
	                answer[i] = answer[i/2]+1;
	            }
	        }
	        return answer;
	    }
}
