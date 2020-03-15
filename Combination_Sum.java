import java.util.*;
public class Combination_Sum {
//	static List<List<Integer>> solution = new ArrayList();
	 public static List<List<Integer>>  combinationSum(int[] candidates, int target,List<Integer> isol, int sum, List<List<Integer>> solution, int index) {
		 if(index>candidates.length || sum>target) {
			 return null;
		 }
		 if(sum==target) {
			 List<Integer> isoo = new ArrayList<>();
//			 isoo = isol;
			 isoo.addAll(isol);
			 solution.add(isoo);
//			 System.out.println(solution);
//			 System.out.println(isol);
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
//			 System.out.println(solution);
//			 System.out.println(isol.get(isol.size()-1));
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
