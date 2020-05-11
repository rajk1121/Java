import java.util.*;
public class flood_fill {

	 public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        if(image.length==0 || image[0].length==0)
	            return image;
	        HashSet<String> set  = new HashSet<>();
	        Queue<String> q = new LinkedList<>();
	        q.add(sr+" "+sc);
	        int color = image[sr][sc];
	        while(q.size()!=0){
	            String str = q.remove();
	            set.add(str);
	            // System.out.println(str);
	            String[] arr = str.split(" ");
	            int r = Integer.parseInt(arr[0]);
	            int c = Integer.parseInt(arr[1]);
	            image[r][c] = newColor;
	            if(isValid(r-1, c,image,color, set)){
	                q.add((r-1)+" "+c);
	            }
	            if(isValid(r, c-1,image, color, set)){
	                q.add(r+" "+(c-1));
	            }
	            if(isValid(r, c+1,image, color, set)){
	                q.add((r)+" "+(c+1));
	            }if(isValid(r+1, c,image,color, set)){
	                q.add((r+1)+" "+c);
	            }
	        }
	        return image;
	    }
	    public boolean isValid(int row, int col ,int[][] image, int color, HashSet<String> set){
	     if(row<0 || col<0 || row>=image.length || col>=image[0].length || set.contains(row+" "+col))
	         return false;
	     if(image[row][col]!=color)
	         return false;
	    
	        return true;
	    }

}
