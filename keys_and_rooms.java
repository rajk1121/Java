/*
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0). 

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:  
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.

 */
import java.util.*;
public class keys_and_rooms {
	  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
	        if(rooms.size()==0)
	            return true;
	        HashSet<Integer> set = new HashSet<>();
	        boolean visited[] = new boolean[rooms.size()];
	        int n = rooms.size();
	         mark(visited, rooms, 0, set);
	        if(set.size()==n){
	            return true;
	            
	        }
	        return false;
	    }
	    public void mark(boolean[] visited, List<List<Integer>> rooms, int i, HashSet<Integer> set){
	        if(visited[i])
	            return;
	        set.add(i);
	        visited[i] = true;
	        for(int j=0 ; j<rooms.get(i).size() ; j++){
	            mark(visited, rooms, rooms.get(i).get(j), set);
	        }
	        return;
	    }
}
