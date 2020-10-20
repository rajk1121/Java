import java.util.*;
public class happy_numbers {

	public static boolean find() {
		int n = 1258;
		HashMap<Integer, Integer> set = new HashMap<>();
        
        // int sum = 0;
        while(n!=1){
        	set.put(n,1);
        	
            int num = 0;
            while(n!=0){
                int rem = n%10;
                num = num+(rem*rem);
                n=n/10;
            }
            n = num;
            if(set.containsKey(n))
                return false;
            
//            System.out.println(num);
        }
        return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(find());
	}

}
