import java.util.*;
public class lexicographical_order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(lexicalOrder(100, new ArrayList<>(),1));
		List<Integer> list = new ArrayList<>();
		back(13, list, 0);
		System.out.println(list);
	}
	 public static void back(int n, List<Integer> res, int cur) {
		 for (int i = 0; i < 10; i++) {
	            if (cur == 0 && i == 0) continue;
	            cur *= 10;
	            cur += i;
	            if (cur <= n) {
	                res.add(cur);
	                back(n, res, cur);
	            } else {
	                break;
	            }
	            cur /= 10;
	        }
	        
	    }

}
