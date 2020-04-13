import java.util.*;
class adjComparator implements Comparator<pairNode>{
    public int compare(pairNode one, pairNode t){
        // System.out.println("fbdfbdfx" + " "+ one+" "+t);
        
        if(one==null || t==null ||one.n>t.n ){
            return -1;
        }else if(one.n>t.n)
            return 0;
        else return 1;
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
//         if(prerequisites.length==0){
//           int[] a =  new int[numCourses];
//             for(int i=0 ; i<numCourses;i++)
//                 a[i]=i;
//             return a;
//        }
        HashMap<Integer, List<Integer>> set = new HashMap<>();
        
        int[] child = new int[numCourses];
        
        HashMap< List<Integer>, Integer> parent = new HashMap<>();
        for(int i=0 ; i<prerequisites.length ;i++){
        	System.out.println(prerequisites[i][0]+" "+prerequisites[i][1]);
            if(set.containsKey(prerequisites[i][1])){
                List<Integer> t = set.get(prerequisites[i][1]);
                t.add(prerequisites[i][0]);
                if(!set.containsKey(prerequisites[i][0])){
                    set.put(prerequisites[i][0], new ArrayList<>());
//                    child[prerequisites[i][0]] = 1;
                    
                }
                child[prerequisites[i][1]] += child[prerequisites[i][0]]; 
                System.out.println(prerequisites[i][1] + " " + child[prerequisites[i][1]]);
                
            }else{
                List<Integer> t = new ArrayList<>();
                t.add(prerequisites[i][0]);
                set.put(prerequisites[i][1], t);
//                parent.put(t,prerequisites[i][1]);

                child[prerequisites[i][1]] = 1;
                if(!set.containsKey(prerequisites[i][0])){
                    set.put(prerequisites[i][0], new ArrayList<>());
                }
                else
                	child[prerequisites[i][1]] += child[prerequisites[i][0]];

                System.out.println(prerequisites[i][1] + " " + child[prerequisites[i][1]]);
                
            }
            
        }
        System.out.println(set);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<numCourses; i++){
           if(set.get(i)!=null)
        	   adj.add(set.get(i));
           else {
        	   set.put(i, new ArrayList<>());
        	   adj.add(set.get(i));
           }
        }
        if(isCyclic(adj))
            return new int[0];
        
         System.out.println(adj+" before");
        
        System.out.println(set+" before");
         adj = new ArrayList<>();
       
        int[] ans = new int[numCourses];
        List<pairNode> list = new ArrayList<>();
        for(int i=0 ; i<numCourses;i++){
            if(set.containsKey(i)){
            	pairNode temp = new pairNode(i, child[i]);
            	list.add(temp);
            }
        }
        for(int i=0 ; i<numCourses;i++) {
        	System.out.print(child[i]+" ");
        }
        Collections.sort(list, new adjComparator());
//        for(int i=0 ; i<list.size() ; i++)
//        	System.out.println(list.get(i).p);
//        System.out.println(list.size()+" ///"+list.get(0));
        for(int i=0 ; i<list.size() ;i++){

//        	System.out.println(i+"//"+list.get(i).p );
        	ans[i] = list.get(i).p;
        }
//        System.out.println(adj);
        return ans;
    }
    private static boolean isCyclic(List<List<Integer>> adj){ 
          
        // Mark all the vertices as not visited and 
        // not part of recursion stack 
        boolean[] visited = new boolean[adj.size()]; 
        boolean[] recStack = new boolean[adj.size()]; 
          
          
        for (int i = 0; i < adj.size(); i++) 
            if (isCyclicUtil(i, visited, recStack, adj)) 
                return true; 
  
        return false; 
    } 
     private static boolean isCyclicUtil(int i, boolean[] visited, 
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
     public static void main(String[] args) {
 		// TODO Auto-generated method stub
    	 int[][] prerequisites =  {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
    	 int[] a = findOrder(7, prerequisites);
    	 for(int i=0 ; i<a.length;i++) {
    		 System.out.println(a[i]);
    	 }
 	}
}


	

