import java.util.*;
//Given a collection of numbers that might contain duplicates, return all possible unique permutations
public class permutation_II {
	public static List<List<Integer>> per_II(int[] nums , int si, int ei, List<Integer> isol, HashMap<Integer, Integer> set, HashMap<List<Integer>, Integer> realset) {
		List<List<Integer>> solution = new ArrayList<>();
		if(si>ei || isol.size()>nums.length-1 && !realset.containsKey(isol)) {
			List<Integer> isolution = new ArrayList<>();
			isolution.addAll(isol);
			realset.put(isolution, 1);
			solution.add(isolution);
			return solution;
			
		}
		for(int i=si ; i<=ei ; i++) {
			if(set.containsKey(i)){
				continue;
			}
			List<List<Integer>> ianswer = new ArrayList<>();
			isol.add(nums[i]);
			set.put(i, 1);
			if(i==si) {
				ianswer = per_II(nums, si+1, ei, isol, set,realset);
			}
			else {

				ianswer = per_II(nums, si, ei, isol, set, realset);
			}
			for(int j=0 ; j<ianswer.size();j++) {
				solution.add(ianswer.get(j));
			}
			isol.remove(isol.size()-1);
			set.remove(i);
		}
		
		
		return solution;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2};
		Arrays.sort(nums);

		HashMap<Integer,Integer> set = new HashMap<>();
		HashMap<List<Integer>,Integer> realset = new HashMap<>();
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> isol =  new ArrayList<>();
		for(int i=0 ; i<nums.length ; i++) {
			List<List<Integer>> ianswer = new ArrayList<>();
			
			if(i==0) {
				isol.add(nums[i]);
				set.put(i, 1);
				ianswer = per_II(nums, 1, nums.length-1, isol, set,realset);
				isol.remove(isol.size()-1);
				set.remove(i);
			}else if(nums[i]!=nums[i-1]) {

				isol.add(nums[i]);
				set.put(i, 1);
				ianswer = per_II(nums, 0, nums.length-1, isol, set, realset);
				isol.remove(isol.size()-1);
				set.remove(i);
			}
			for(int j=0 ; j<ianswer.size() ; j++) {
				answer.add(ianswer.get(j));
			}
		}
		System.out.println(answer);
	}

}
