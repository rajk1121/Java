
import java.util.*;
class cycle_in_directed_graph_Or_course_schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       if(prerequisites.length==0){
           return true;
       }
        HashMap<Integer, List<Integer>> set = new HashMap<>();
        for(int i=0 ; i<prerequisites.length ;i++){
            if(set.containsKey(prerequisites[i][0])){
                List<Integer> t = set.get(prerequisites[i][0]);
                t.add(prerequisites[i][1]);
                
            }else{
                List<Integer> t = new ArrayList<>();
                t.add(prerequisites[i][1]);
                set.put(prerequisites[i][0], t);
            }
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<numCourses; i++){
            adj.add(set.get(i));
        }
        Stack<Integer> s = new Stack();
        boolean[] visited = new boolean[numCourses];
        s.add(prerequisites[0][0]);
        for(int i=0; i<adj.size();i++){
            if(isCyclic(adj))
                return false;
        }
        
        return true;
    }
    private boolean isCyclic(List<List<Integer>> adj){ 
          
        // Mark all the vertices as not visited and 
        // not part of recursion stack 
        boolean[] visited = new boolean[adj.size()]; 
        boolean[] recStack = new boolean[adj.size()]; 
          
          
        for (int i = 0; i < adj.size(); i++) 
            if (isCyclicUtil(i, visited, recStack, adj)) 
                return true; 
  
        return false; 
    } 
     private boolean isCyclicUtil(int i, boolean[] visited, 
                                      boolean[] recStack, List<List<Integer>> adj){ 
          
        if (recStack[i]) 
            return true; 
  
        if (visited[i]) 
            return false; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
        List<Integer> children = adj.get(i); 
        if(children!=null){  
            for (Integer c: children) 
                if (isCyclicUtil(c, visited, recStack, adj)) 
                    return true; 
        }         
        recStack[i] = false; 
  
        return false; 
    } 
  }