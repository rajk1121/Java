import java.util.*;
public class safe_states {
	 public static List<Integer> eventualSafeNodes(int[][] graph) {
	       boolean[] formCycle = new boolean[graph.length];
	        int n = graph.length;
	        List<Integer> ans = new ArrayList<>();
	        boolean visited[] = new boolean[n];
	        boolean recStack[] = new boolean[n];
	        for(int i=0 ; i<graph.length; i++){
	            if(!visited[i]){
	                boolean is = find(recStack, visited, formCycle, i, graph);
	                if(!is)
	                    ans.add(i);
	            }else{
	                if(!formCycle[i]){
	                    ans.add(i);
	                }
	            }
	        }
	        return ans;
	    }
	    public static boolean find(boolean[] recStack, boolean[] visited, boolean[] formCycle, int i, int[][] graph){
	        if(recStack[i])
	            return true;
	        if(formCycle[i])
	            return true;
	        if(visited[i])
	            return false;
	        
	        recStack[i] = true;
	        visited[i] = true;
	        boolean ans  = false;
	        for(int j=0 ; j<graph[i].length ; j++){
	            ans = ans || find(recStack, visited, formCycle, graph[i][j], graph);
	            if(ans){
	                formCycle[i] = true;
	                recStack[i] = false;
	                return true;
	            }
	        }
	        formCycle[i] = false;
	        recStack[i] = false;
	        return false;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] graph = {{1,2},{2,3},{2,5},{0},{5},{},{}};
		System.out.println(eventualSafeNodes(graph));

	}

}
