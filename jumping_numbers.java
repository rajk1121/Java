import java.util.*;
public class jumping_numbers {
/*
 * Given a number x, print all the jumping numbers below or equal to x. A number is called a jumping number if for a number all the adjacent digits differ by 1. All single digit numbers are also jumping numbers.
Eg. 432345, 32, 543, 989, 12, 21 are jumping numbers whereas 843, 485, 9348 are not.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		 Queue<Integer> q = new LinkedList<>();
	        // q.add(0);
	        System.out.print(0+" ");
	        q.add(1);
	        q.add(2);
	        q.add(3);
	        q.add(4);
	        q.add(5);
	        q.add(6);
	        q.add(7);
	        q.add(8);
	        q.add(9);
	        while(q.size()!=0){
	            int number = q.remove();
	            if(number<n){
	                System.out.print(number+" ");
	                int rem = number%10;
	                if(rem==0){
	                    number = number*10 + 1;
	                    q.add(number);
	                }
	               if(rem==1){
	                    number = number*10;
	                    q.add(number);
	                    number = number + 2;
	                    q.add(number);
	                }if(rem==2){
	                    number = number*10 + 1;
	                    q.add(number);
	                    number/=10;
	                    number = number*10 + 3;
	                    q.add(number);
	                }if(rem==3){
	                    number = number*10 + 2;
	                    q.add(number);
	                    number/=10;
	                    number = number*10 + 4;
	                    q.add(number);
	                    
	                }if(rem==4){
	                    
	                    number = number*10 + 3;
	                    q.add(number);
	                    number/=10;
	                    number = number*10 + 5;
	                    q.add(number);
	                }if(rem==5){
	                    
	                    number = number*10 + 4;
	                    q.add(number);
	                    number/=10;
	                    number = number*10 + 6;
	                    q.add(number);
	                }if(rem==6){
	                    
	                    number = number*10 + 5;
	                    q.add(number);
	                    number/=10;
	                    number = number*10 + 7;
	                    q.add(number);
	                }if(rem==7){
	                    
	                    number = number*10 + 6;
	                    q.add(number);
	                    number/=10;
	                    number = number*10 + 8;
	                    q.add(number);
	                }if(rem==8){
	                    number = number*10 + 7;
	                    q.add(number);
	                    number/=10;
	                    number = number*10 + 9;
	                    q.add(number);
	                    
	                }if(rem==9){
	                    number = number*10 + 8;
	                    q.add(number);
	                    
	                }
	            }
	        }
	}

}
