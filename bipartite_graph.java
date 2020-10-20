import java.util.*;
public class bipartite_graph {
	 public static boolean isBipartite(int[][] graph) {
	        int max= graph.length;
	        HashSet<Integer> set  = new HashSet<>();
	        int[] color= new int[max+1];
	        boolean visited[] = new boolean[max+1];
	        Arrays.fill(color, -1);
	        for(int i=0 ; i<graph.length ; i++)
	            set.add(i);
	        System.out.println(set);
	        Iterator it = set.iterator();
	        boolean ans = true;
	        while(it.hasNext()){
//	             System.out.println((int)it.next());
	             int x = (int)it.next();
	            if(!visited[x]) {
	            	System.out.println(x);
	            	ans = ans & find(x, visited, color, graph, set, 0);
	            }
//	            System.out.println(set);
//	            break;
	        }
	        
	        return ans;
	    }
	    public static boolean find(int s, boolean[] visited, int[] color,int[][] graph,HashSet<Integer> set, int c){
	        if(visited[s]){
	            if(color[s] == c){
	                return true;
	            }else{
	                return false;
	            }
	        }else{
	            visited[s]=true;
//	            set.remove(s);
//	            System.out.println(set);
	            color[s]=c;
	            // if(s>=graph.length){
	                boolean ans =true;
	                for(int i=0 ; i<graph[s].length; i++){
	                    if(c==0){
	                        ans = ans & find(graph[s][i], visited, color,graph,set, 1);
	                    }else{
	                        
	                        ans = ans & find(graph[s][i], visited, color,graph,set, 0);
	                    }
	                }
	                return ans;
	            // }else{
	            //     return true;
	            // }
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[][] graph = {{},{3},{},{1},{}};
	System.out.println(isBipartite(graph));
	}

}
