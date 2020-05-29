/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

 */
public class word_search {
	  public boolean exist(char[][] board, String word) {
	        int m = board.length;
	        if(m==0)
	            return true;
	        int n = board[0].length;
	        boolean[][] visited = new boolean [m][n];
	        for(int i=0 ; i<m ; i++){
	            for(int j=0 ; j<n ; j++){
	                if(board[i][j]==word.charAt(0)){
	                    if(tell(board, word, 0,i,j, visited))
	                        return true;
	                }
	            }
	        }
	        return false;
	    }
	    public boolean tell(char[][] board, String word, int index,int i, int j, boolean[][] visited){
	        if(visited[i][j])
	            return false;
	        if(index==word.length()-1 && board[i][j]==word.charAt(index)){
	            return true;
	        }
	        if(index==word.length()-1)
	            return false;
	        if(word.charAt(index)!=board[i][j])
	            return false;
	        visited[i][j] = true;
	        if(isValid(i+1, j, visited, board, word)){
	            if(tell(board, word, index+1, i+1,j, visited))
	                return true;
	        }
	        if(isValid(i-1, j, visited, board, word)){
	            if(tell(board, word, index+1, i-1,j, visited))
	                return true;
	        }
	        if(isValid(i, j+1, visited, board, word)){
	            if(tell(board, word, index+1, i,j+1, visited))
	                return true;
	        }
	        if(isValid(i, j-1, visited, board, word)){
	            if(tell(board, word, index+1, i,j-1, visited))
	                return true;
	        }
	        visited[i][j] = false;
	        return false;
	    }
	    public boolean isValid(int i, int j, boolean[][] visited, char[][] board, String word){
	        if(i>=0 && i<board.length && j>=0 && j<board[0].length)
	            return true;
	        return false;
	    }
}
