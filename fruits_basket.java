/*
 * In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

    Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
    Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.

Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?

 

Example 1:

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].

Example 2:

Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].

Example 3:

Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].

Example 4:

Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.

 */
public class fruits_basket {
	  public int totalFruit(int[] tree) {
	        if(tree.length==1){
	            return 1;
	        }
	        int one = tree[0];
	        int i=0;
	        while(i<tree.length && tree[i]==one){
	            i++;
	        }
	        if(i>=tree.length){
	            return tree.length;
	        }
	        int two = tree[i];
	        int focc = 0;
	        int tocc = i;
	        
	        int max = tocc - focc + 1;
	        int imax = max;
	        // System.out.println(max);
	        int l = i;
	        i++;
	        for( ; i<tree.length ; i++){
	            if(tree[i] == one || tree[i] == two){
	                if(tree[i]!=tree[i-1])
	                    l = i;
	                imax++;
	                max = Math.max(max, imax);
	                // System.out.println(max + " " + i);
	            }else{
	                one = tree[i-1];
	                two = tree[i];
	                focc = tocc;
	                tocc = i;
	                imax = i - l + 1;
	                l=i;
	                max = Math.max(max, imax);
	                // System.out.println(max + " " + i+" "+imax);
	            }
	        }
	        return max;
	    }
}
