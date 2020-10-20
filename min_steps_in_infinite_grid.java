/*
 * You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 

You are given a sequence of points and the order in which you need to cover the points. 
Give the minimum number of steps in which you can achieve it. You start from the first point.
 */

import java.util.*;
public class min_steps_in_infinite_grid {
	public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int sx = A.get(0);
        int sy = B.get(0);
        int ans = 0;
        for(int i=1 ; i<A.size() ; i++){
            int ex = A.get(i);
            int ey = B.get(i);
            int dx = sx - ex;
            int dy = sy - ey;
            if(dx==0){
                ans = ans + Math.abs(dy);
            }
            else if(dx>0){
                if(dy==0){
                    ans = ans + Math.abs(dx);
                }
                else if(dy>0){
                    ans = ans + Math.min(Math.abs(dx) , Math.abs(dy)) + Math.max(Math.abs(dy), Math.abs(dx)) - Math.min(Math.abs(dx) , Math.abs(dy));
                }else{
                    
                    ans = ans + Math.min(Math.abs(dx) , Math.abs(dy)) + Math.max(Math.abs(dy), Math.abs(dx)) - Math.min(Math.abs(dx) , Math.abs(dy));
                }
            }else{
                if(dy==0){
                    ans = ans + Math.abs(dx);
                }
                else if(dy>0){
                    ans = ans + Math.min(Math.abs(dx) , Math.abs(dy)) + Math.max(Math.abs(dy), Math.abs(dx)) - Math.min(Math.abs(dx) , Math.abs(dy));
                }else{
                    
                    ans = ans + Math.min(Math.abs(dx) , Math.abs(dy)) + Math.max(Math.abs(dy), Math.abs(dx)) - Math.min(Math.abs(dx) , Math.abs(dy));
                }
            }
            sx = ex;
            sy = ey;
        }
        return ans;
    }
}
