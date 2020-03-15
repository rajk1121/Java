import java.util.*;
//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

//Each number in candidates may only be used once in the combination.
public class combination_sum_II {
	static HashMap<String,Integer> set = new HashMap<>();
	 public static List<List<Integer>>  combinationSum(int[] candidates, int target,List<Integer> isol, int sum, List<List<Integer>> solution, int index) {
		 if(index>candidates.length || sum>target) {
			 return solution;
		 }
		 if(sum==target) {
			 
			 String str = "";
			 for(int i=0 ; i<isol.size();i++) {
				 str=str+isol.get(i);
			 }
			 if(set.containsKey(str)) {
				 return solution;
			 }else {
				 List<Integer> isoo = new ArrayList<>();
				 isoo.addAll(isol);
				 solution.add(isoo);
				 set.put(str, 1);
			 }
			 return solution;
				 
			 
//			 System.out.println(solution);
			 
		 }
		 while(index<candidates.length) {
			 isol.add(candidates[index]);
			 if(sum+candidates[index]>target) {
				 isol.remove(isol.size()-1);
				 return solution;
			 }
			 combinationSum(candidates, target, isol, sum+candidates[index],solution, ++index);
			 
			 isol.remove(isol.size()-1);
		 }
		 return solution ;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,2,2,2,3,6,7};
		int target= 7;
		List<Integer> isol=new ArrayList<>();
		List<List<Integer>> solution = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(candidates, target,isol  ,0,solution, 0);
		System.out.println(solution);
		
	}

}
