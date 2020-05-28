import java.util.*;
public class possible_biparttion {
	  public static boolean possibleBipartition(int N, int[][] dislikes) {
		  if(N==1)
	            return true;
	        HashMap<Integer,List<Integer>> set = new HashMap<>();
	        for(int i=0 ; i<dislikes.length ; i++){
	            if(set.containsKey(dislikes[i][0])){
	                set.get(dislikes[i][0]).add(dislikes[i][1]);
	            }else{
	                List<Integer> l = new ArrayList<>();
	                l.add(dislikes[i][1]);
	                set.put(dislikes[i][0], l);
	            }
	            if(set.containsKey(dislikes[i][1])){
	                set.get(dislikes[i][1]).add(dislikes[i][0]);
	            }else{
	                List<Integer> l = new ArrayList<>();
	                l.add(dislikes[i][0]);
	                set.put(dislikes[i][1], l);
	            }
	            
	        }
	        boolean[] visited = new boolean[N];
	        int[] color = new int[N];
	        // color[0] = 0;
	        // Queue<Integer> q = new LinkedList<>();
	        Queue<Integer> q = new LinkedList<>();
		        for(int j=1 ; j<=N ; j++) {
		        	if(visited[j-1])
		        		continue;
		        	q.add(j);
		        	color[j-1] = 0;
		        	while(q.size()!=0){
			            int x = q.remove();
			            visited[x-1] = true;
			            int pColor = color[x-1];
			            if(pColor==1){
			                List<Integer> neighbours = set.get(x);
	                        if(neighbours==null)
	                            continue;
			                for(int i=0 ; i<neighbours.size() ; i++){
			                    if(visited[neighbours.get(i) - 1]){
			                        if(color[neighbours.get(i) - 1]!=0)
			                            return false;
			                    }else{
			                        color[neighbours.get(i) - 1] = 0;
			                        q.add(neighbours.get(i));
			                    }
			                }
			            }else{
			                List<Integer> neighbours = set.get(x);
	                        if(neighbours==null)
	                            continue;
			                for(int i=0 ; i<neighbours.size() ; i++){
			                    if(visited[neighbours.get(i) - 1]){
			                        if(color[neighbours.get(i) - 1]!=1)
			                            return false;
			                    }else{
			                        color[neighbours.get(i) - 1] = 1;
			                        q.add(neighbours.get(i));
			                    }
			                }
			            }
			        }
		        }
		        
	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dislikes = {{1,2},{3,4},{4,5},{3,5}};
		System.out.println(possibleBipartition(5, dislikes));
	}

}
