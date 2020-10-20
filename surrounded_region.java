import java.util.*;
public class surrounded_region {
	 public static void solve(char[][] board) {
	        int m = board.length;
	        if(m==0)
	            return;
	        int n = board[0].length;
	        boolean[][] safe = new boolean[m][n];
	        boolean[][] visited = new boolean[m][n];
	        Queue<String> q = new LinkedList<>();
	        for(int i=0; i<m ; i++) {
	        	if(board[i][0]=='O') {
	        		q.add(i+" 0");
	        		safe[i][0] = true;
	        		visited[i][0] = true;
	        	}
	        }
	        for(int i=0; i<m ; i++) {
	        	if(board[i][n-1]=='O') {
	        		q.add(i+" "+(n-1));
	        		safe[i][n-1] = true;
	        		visited[i][n-1] = true;
	        	}
	        }
	        for(int i=0; i<n ; i++) {
	        	if(board[0][i]=='O') {
	        		q.add("0 "+i);
	        		safe[0][i] = true;
	        		visited[0][i] = true;
	        	}
	        }
	        for(int i=0; i<n ; i++) {
				if(board[m-1][i]=='O') {
					q.add((m-1)+" "+i); 
					safe[m-1][i] = true;
					visited[m-1][i] = true;
	        	}
	        }
	        while(q.size()!=0) {
	        	String s = q.remove();
	        	int i =Integer.parseInt( s.split(" ")[0]);
	        	int j = Integer.parseInt(s.split(" ")[1]);
	        	if(isValid(i+1, j, board, visited)) {
	        		visited[i+1][j] = true;
	        		safe[i+1][j] = true;
	        		q.add((i+1)+" "+j);
	        	}
	        	if(isValid(i-1, j, board, visited)) {
	        		visited[i-1][j] = true;
	        		safe[i-1][j] = true;
	        		q.add((i-1)+" "+j);
	        	}
	        	if(isValid(i, j-1, board, visited)) {
	        		visited[i][j-1] = true;
	        		safe[i][j-1] = true;
	        		q.add((i)+" "+(j-1));
	        	}
	        	if(isValid(i, j+1, board, visited)) {
	        		visited[i][j+1] = true;
	        		safe[i][j+1] = true;
	        		q.add(i+" "+(j+1));
	        	}
	        }
	        for(int i=0 ; i<m ; i++) {
	        	for(int j=0 ; j<n ; j++) {
	        		if(board[i][j]=='O' && !safe[i][j])
	        			board[i][j] = 'X';
	        	}
	        }
	        
	       
	    }
	 public static boolean isValid(int i, int j, char[][] board, boolean[][] visited) {
		 
		 if(i<0 || i==board.length | j<0 || j>board[0].length)
			 return false;
		 if(visited[i][j])
			 return false;
		 if(board[i][j] == 'O')
			 return true;
		 return false;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board =   {{'X','O','X','O','X','O','O','O','X','O'},
							{'X','O','O','X','X','X','O','O','O','X'},
							{'O','O','O','O','O','O','O','O','X','X'},
							{'O','O','O','O','O','O','X','O','O','X'},
							{'O','O','X','X','O','X','X','O','O','O'},
							{'X','O','O','X','X','X','O','X','X','O'},
							{'X','O','X','O','O','X','X','O','X','O'},
							{'X','X','O','X','X','O','X','O','O','X'},
							{'O','O','O','O','X','O','X','O','X','O'},
							{'X','X','O','X','X','X','X','O','O','O'}};
		solve(board);
		

	}

}
