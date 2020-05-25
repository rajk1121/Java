/*
 * 
You have maps of parts of the space station, each starting at a prison exit and ending at the door to an escape pod. The map is represented as a matrix of 0s and 1s, where 0s are passable space and 1s are impassable walls. The door out of the prison is at the top left (0,0) and the door into an escape pod is at the bottom right (w-1,h-1). 

Write a function solution(map) that generates the length of the shortest path from the prison door to the escape pod, where you are allowed to remove one wall as part of your remodeling plans. The path length is the total number of nodes you pass through, counting both the entrance and exit nodes. The starting and ending positions are always passable (0). The map will always be solvable, though you may or may not need to remove a wall. The height and width of the map can be from 2 to 20. Moves can only be made in cardinal directions; no diagonal moves are allowed.
Input:
Solution.solution({{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}})
Output:
    7

Input:
Solution.solution({{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}})
Output:
    11
 */
import java.util.Queue;
import java.util.LinkedList;
public class foobar_3c {
	public static int solution(int[][] map) {
        // Your code here
		int[][] dpUpDown = new int[map.length][map[00].length];
		boolean[][] visited = new boolean[map.length][map[0].length];
		int ans = Integer.MAX_VALUE;
		visited[0][0] = true;
		Queue<String> q = new LinkedList<>();
		q.add("0 0");
		dpUpDown[0][0] = 1;
		while(q.size()!=0) {
			String x = q.remove();
			int i = Integer.parseInt(x.split(" ")[0]);
			int j = Integer.parseInt(x.split(" ")[1]);

//			System.out.println(i+" "+j);
			if(map[i][j]==1)
				continue;
			if(isValid(i+1, j, map, visited)) {
				visited[i+1][j] = true;
				dpUpDown[i+1][j] = dpUpDown[i][j]+1;
				q.add((i+1)+" "+j);
			}if(isValid(i-1, j, map, visited)) {
				visited[i-1][j] = true;
				dpUpDown[i-1][j] = dpUpDown[i][j]+1;
				q.add((i-1)+" "+j);
			}if(isValid(i, j+1, map, visited)) {
				visited[i][j+1] = true;
				dpUpDown[i][j+1] = dpUpDown[i][j]+1;
				q.add((i)+" "+(j+1));
			}if(isValid(i, j-1,	 map, visited)) {
				visited[i][j-1] = true;
				dpUpDown[i][j-1] = dpUpDown[i][j]+1;
				q.add((i)+" "+(j-1));
			}
		}
		int[][] dpDownUp = new int[map.length][map[0].length];
		dpDownUp[map.length-1][map[0].length-1] = 1;
		int m = map.length-1;
		int n = map[0].length-1;
		visited = new boolean[m+1][n+1];
		visited[m][n] = true;
		q.add(m+" "+n);
		while(q.size()!=0) {
			String x = q.remove();
			int i = Integer.parseInt(x.split(" ")[0]);
			int j = Integer.parseInt(x.split(" ")[1]);
			if(map[i][j]==1)
				continue;
			if(isValid(i+1, j, map, visited)) {
				visited[i+1][j] = true;
				dpDownUp[i+1][j] = dpDownUp[i][j]+1;
				q.add((i+1)+" "+j);
			}if(isValid(i-1, j, map, visited)) {
				visited[i-1][j] = true;
				dpDownUp[i-1][j] = dpDownUp[i][j]+1;
				q.add((i-1)+" "+j);
			}if(isValid(i, j+1, map, visited)) {
				visited[i][j+1] = true;
				dpDownUp[i][j+1] = dpDownUp[i][j]+1;
				q.add((i)+" "+(j+1));
			}if(isValid(i, j-1,	 map, visited)) {
				visited[i][j-1] = true;
				dpDownUp[i][j-1] = dpDownUp[i][j]+1;
				q.add((i)+" "+(j-1));
			}
		}
//		for(int i=0 ; i<=m ; i++) {
//			for(int j=0 ; j<=n  ; j++) {
//				System.out.print(dpUpDown[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("*********************");
//		for(int i=0 ; i<=m ; i++) {
//			for(int j=0 ; j<=n  ; j++) {
//				System.out.print(dpDownUp[i][j]+" ");
//			}
//			System.out.println();
//		}
		for(int i=0 ; i<=m;  i++) {
			for(int j=0 ; j<=n ; j++) {
				if(dpDownUp[i][j]!=0 && dpUpDown[i][j]!=0) {
					ans =Math.min(ans, dpDownUp[i][j] + dpUpDown[i][j]);
				}
			}
		}
		
		return ans-1;
    }
	
	public static boolean isValid(int i, int j, int[][] map,boolean[][] visited) {
		
		return (i>=map.length || i<0 || j>=map[0].length || j<0 || visited[i][j]) ? false :  true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};
		System.out.println(solution(map));
	}

}
