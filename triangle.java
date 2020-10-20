import java.util.*;
public class triangle {
	 public static int minimumTotal(List<List<Integer>> triangle) {
//	        int max = 0;
	        List<Integer> maxList = new ArrayList<>();
//	        System.out.println(triangle.size());
	        for(int j= 0 ; j < triangle.get(triangle.size()-1).size() ; j++) {
	        	maxList.add(triangle.get(triangle.size()-1).get(j));
	        }
//	        System.out.println(triangle.size());
	        for(int i= triangle.size()-2; i>=0 ;i--) {
	        	for(int j=0 ;j<triangle.get(i).size() ; j++) {
//	        		System.out.println(triangle.get(i).get(j)+  " "+ maxList.get(j) + " "+   maxList.get(j+1));
	        		maxList.set(j, Math.min(triangle.get(i).get(j) + maxList.get(j), triangle.get(i).get(j) + maxList.get(j+1)));
	        	}
	        	
//	        	System.out.println();
	        	maxList.remove(maxList.size()-1);
	        }
	        return maxList.get(0);
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> i = new ArrayList<>();
		i.add(-1);
		triangle.add(i);
		i =new ArrayList<>();
		i.add(2);
		i.add(3);
		triangle.add(i);
		i = new ArrayList<>();
		i.add(1);
		i.add(-1);
		i.add(-3);
		triangle.add(i);
		System.out.println(minimumTotal(triangle));
	}

}
