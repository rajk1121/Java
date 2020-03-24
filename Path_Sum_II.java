import java.util.*;
class Nodes {
Nodes right;
Nodes left;
int val;
Nodes(int x){
	this.val = x;
}
}

public class Path_Sum_II {
    public static List<List<Integer>> pathSum(Nodes root, int sum) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> ians = new ArrayList<>();
        generate(root , sum , 0 , answer , ians);
        return answer;
    }
    public static void generate(Nodes root , int sum ,int totalP, List<List<Integer>> answer , List<Integer> ians){
        
        if(root==null)
            return;
        
        if(root.left==null && root.right==null){
            if(sum==totalP+root.val){
                List<Integer> ans = new ArrayList<>();
                for(int i=0 ; i<ians.size() ; i++){
                    ans.add(ians.get(i));
                }
                ans.add(root.val);
                answer.add(ans);
                return ;
            }
            return;
        }
        ians.add(root.val);
        generate(root.left , sum , totalP+root.val ,answer, ians);
        generate(root.right , sum , totalP+root.val ,answer, ians);
        ians.remove(ians.size()-1);
        return ;
        
        
        
        
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
