import java.util.*;
public class nuber_of_islands {
    public static int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0 ;i<grid.length ;i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                count++;
                mark(visited, grid,i,j);
            }
            }
        }
        return count;
    }
    public static void mark(boolean[][] visited, char[][] grid,int i, int j){
    	if(j==grid[0].length || i==grid.length || j<0 || i<0)
            return;
        if(grid[i][j]=='0')
            return;
        if(grid[i][j] == '1' && !visited[i][j]){
            visited[i][j] = true;
            mark(visited, grid, i+1, j);
            mark(visited, grid, i, j+1);
            mark(visited, grid, i-1, j);
            mark(visited, grid, i, j-1);
        }else{
            return;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] nums = {{'1','1','1'},{'0','1','0'},{'1','1','1'
			}};

	}

}
