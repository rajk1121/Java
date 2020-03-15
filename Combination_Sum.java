import java.util.*;
//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
public class Combination_Sum {
	 public static List<List<Integer>>  combinationSum(int[] candidates, int target,List<Integer> isol, int sum, List<List<Integer>> solution, int index) {
		 if(index>candidates.length || sum>target) {
			 return null;
		 }
		 if(sum==target) {
			 List<Integer> isoo = new ArrayList<>();
			 isoo.addAll(isol);
			 solution.add(isoo);
			 return solution;
		 }
		 while(index<candidates.length) {
			 isol.add(candidates[index]);
			 combinationSum(candidates, target, isol, sum+candidates[index],solution, index);
			 if(index<candidates.length-1 && candidates[index]==candidates[index+1]) {
				 index+=2;
			 }else {
				 index++;
			 }
			 isol.remove(isol.size()-1);
		 }
		 return solution ;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,2,3,6,7};
		int target= 7;
		List<Integer> isol=new ArrayList<>();
		List<List<Integer>> solution = new ArrayList<>();
		combinationSum(candidates, target,isol  ,0,solution, 0);
		System.out.println(solution);
		
	}

}
