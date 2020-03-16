import java.util.*;
public class permutation {
	 public static List<List<Integer>> per(int[] nums, int si, int ei,List<Integer> isol,HashMap<Integer,Integer> set){
	 
		 List<List<Integer>> solution = new ArrayList<>();
		 if(si>ei || isol.size()>nums.length-1) {
			 List<Integer> isolu = new ArrayList<>();
			 isolu.addAll(isol);
			 solution.add(isolu);
			 return solution;
		 }
		 for(int i=si ; i<=ei ; i++) {
			 if( set.containsKey(nums[i])) {
				 continue;
			 }
//			 List<Integer> answer = new ArrayList();
			 List<List<Integer>> isolution = new ArrayList<>();
			 isol.add(nums[i]);
			 set.put(nums[i], 1);
			 if(i==si) {
//				 if(mi==si) {
					 isolution = per(nums, si+1, ei, isol,set);
//				 }else {
//					 isolution = per(nums, si+1, ei, isol, number+1, set);
//				 }
			 }else {
				  isolution = per(nums, si,  ei, isol,set);
				 
			 }
			 for(int j=0 ; j<isolution.size();j++) {
				 solution.add(isolution.get(j));
			 }
			 isol.remove(isol.size()-1);
			 set.remove(nums[i]);
		 }
		 return solution;   
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,2,3};
		HashMap<Integer,Integer> set = new HashMap<>();
		System.out.println(per(nums,0,nums.length-1,new ArrayList<>(),set));

	}

}
