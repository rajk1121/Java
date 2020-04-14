/*
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :

Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3 

Output: [1]

Example 2 :

Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5 

Output: [3, 4]
 */
import java.util.*;
public class Minimum_height_trees {

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		HashMap<Integer,HashSet<Integer>> vtces = new HashMap<>();
		int[] child =new int[n];
        for(int i=0;i<edges.length ; i++){
            if(vtces.containsKey( edges[i][1])){
                vtces.get(edges[i][1]).add(edges[i][0]);
                if(!vtces.containsKey(edges[i][0])){
                    HashSet<Integer> temp = new HashSet<>();
	                temp.add(edges[i][1]);    
	                vtces.put(edges[i][0], temp);   
                }else{
                	HashSet<Integer> tempm =vtces.get(edges[i][0]);
                tempm.add(edges[i][1]);    
                vtces.put(edges[i][0], tempm);  
                }
            }else{
                HashSet<Integer> temp = new HashSet<>();
                temp.add(edges[i][0]);
                vtces.put(edges[i][1], temp);
                if(!vtces.containsKey(edges[i][0])){

                    HashSet<Integer> tempm = new HashSet<>();
                    tempm.add(edges[i][1]);
                vtces.put(edges[i][0], tempm);   
                }else{
                    HashSet<Integer> tempm =vtces.get(edges[i][0]);
                tempm.add(edges[i][1]);    
                vtces.put(edges[i][0], tempm);  
                }
            }
            child[edges[i][0]]++;
            child[edges[i][1]]++;
        }
        System.out.println(vtces);
        HashMap<Integer, Integer> paths = new HashMap<>();
        if(vtces.size()==n) {
        	List<Integer> ans = new ArrayList<>();
        	for(int i=0 ; i<n ; i++) {
        		if(child[i]==1)
        			ans.add(i);
        	}
        	while(n>2) {
        		n = n-ans.size();
        		int m = ans.size();
        		for(int i=0 ; i<m ; i++) {
        			int node = ans.remove(0);
        			HashSet<Integer> neighbors = vtces.get(node);
        			for(int neigh: neighbors) {
        				vtces.get(neigh).remove(node);
        				child[neigh]--;
        				if(child[neigh]==1) {
        					ans.add(neigh);
        				}
        			}
        			child[node] = 0;
        			
        		}
        	}
        	return ans;
        	
        }else if(n<=2) {
        	List<Integer> ansc = new ArrayList<>();
        	for(int i=0;i<n;i++)
        		ansc.add(i);
        	return ansc;
        }else {
        	 return new ArrayList<>(); 	
        }
        
       
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {{0,1},{1,2},{2,4},{1,3},{4,6},{3,5}};
				System.out.println(findMinHeightTrees(7, edges));
	}

}
