import java.util.*;
class adjComparator implements Comparator<pairNode>{
    public int compare(pairNode one, pairNode t){
//         System.out.println("fbdfbdfx" + " "+ one.n+" "+t.n);
        
        if(one==null || t==null ||one.n>t.n ){
            return 1;
        }else if(one.n==t.n)
            return 0;
        else return -1;
    }
}
class pairNode{
	int p ;
	int n ;
	pairNode(int x, int l){
		this.p = x;
		this.n = l;
	}
}
public class course_schedule_II {
    
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
    	if(numCourses==0){
            return new int[0];  
         }
        HashMap<Integer, List<Integer>> set = new HashMap<>();
        
        int[] child = new int[numCourses];
        
        HashMap< List<Integer>, Integer> parent = new HashMap<>();
        for(int i=0 ; i<prerequisites.length ;i++){
            if(set.containsKey(prerequisites[i][0])){
                List<Integer> t = set.get(prerequisites[i][0]);
                t.add(prerequisites[i][1]);
                if(!set.containsKey(prerequisites[i][1])){
                    set.put(prerequisites[i][1], new ArrayList<>());
                    
                }
                
            }else{
                List<Integer> t = new ArrayList<>();
                t.add(prerequisites[i][1]);
                set.put(prerequisites[i][0], t);
                if(!set.containsKey(prerequisites[i][1])){
                    set.put(prerequisites[i][1], new ArrayList<>());
                }
                
            }
            
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<numCourses; i++){
           if(set.get(i)!=null)
        	   adj.add(set.get(i));
           else {
        	   set.put(i, new ArrayList<>());
        	   adj.add(set.get(i));
           }
        }

        HashMap<Integer, Integer> set2 = new HashMap<>();
        if(isCyclic(adj, set2, set))
            return new int[0];
        
        boolean[] visited = new boolean[numCourses];
        
        int[] ans = new int[numCourses];
       
        List<pairNode> list = new ArrayList<>();
        for(int i=0; i<numCourses ; i++) {
        	pairNode x = new pairNode(i, set2.get(i));
        	list.add(x);
        }
        Collections.sort(list, new adjComparator());
               for(int i=0 ; i<list.size() ;i++){

        	ans[i] = list.get(i).p;
        }
        return ans;
    }
  
	private static boolean isCyclic(List<List<Integer>> adj, HashMap<Integer, Integer> set2, HashMap<Integer, List<Integer>> set){ 
          
        boolean[] visited = new boolean[adj.size()]; 
        boolean[] recStack = new boolean[adj.size()]; 
          
          
        for (int i = 0; i < adj.size(); i++) 
            if (isCyclicUtil(i, visited, recStack, adj, set2, set)) 
                return true; 
  
        return false; 
    } 
     private static boolean isCyclicUtil(int i, boolean[] visited, 
                                      boolean[] recStack, List<List<Integer>> adj,  HashMap<Integer, Integer> set2, HashMap<Integer, List<Integer>> set){ 
//          
    	 if(set.get(i).size()==0) {
     		visited[i]=true;
     		set2.put(i, 0);
     		return false;
     	}
     	int c = 0;
     	for(int j=0 ; j<set.get(i).size() ; j++) {
     		
     	}
        if (recStack[i]) 
            return true; 
  
        if (visited[i]) 
            return false; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
//        if(children!=null){  
        for(int j=0 ; j<set.get(i).size() ; j++) {
                if (isCyclicUtil(set.get(i).get(j), visited, recStack, adj, set2, set))
                    return true; 
                
         		c = c + set2.get(set.get(i).get(j));
//            }
        }         
        recStack[i] = false; 

     	c = c + set.get(i).size();
     	set2.put(i, c);
        return false; 
    } 
     public static void main(String[] args) {
 		// TODO Auto-generated method stub
    	 int[][] prerequisites =  {{0,1}};
    	 int[] a = findOrder(2, prerequisites);
    	 for(int i=0 ; i<a.length;i++) {
    		 System.out.println(a[i]);
    	 }
 	}
}


	

