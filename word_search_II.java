import java.util.*;
public class word_search_II {
	public List<String> findWords(char[][] board, String[] word) {
        int m = board.length;
        
        List<String> ans = new ArrayList<>();
        if(m==0)
            return ans;
        int n = board[0].length;
        HashMap<Character, HashSet<String>> set = new HashMap<>();
        for(int i=0;  i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(set.containsKey(board[i][j])){
                    set.get(board[i][j]).add(i+" "+j);
                }else{
                    HashSet<String> hs = new HashSet<>();
                    hs.add(i+" "+j);
                    set.put(board[i][j], hs);
                }
            }
        }
        HashSet<String> global = new HashSet<>();
        for(int k=0 ; k<word.length ; k++){
            String toFind = word[k];
            // System.out.println(global);
            // System.out.println(toFind);
            if(set.get(toFind.charAt(0))!=null && !global.contains(toFind)){
                HashSet<String> hs = set.get(toFind.charAt(0));
                Iterator it = hs.iterator();
                global.add(toFind);
                while(it.hasNext()){
                    String x= (String)it.next();
                    int i = Integer.parseInt(x.split(" ")[0]);
                    int j = Integer.parseInt(x.split(" ")[1]);
                    
                    boolean[][] visited = new boolean [m][n];
                    if(tell(board, toFind, 0,i,j, visited)){
                        ans.add(toFind);
                        break;
                    }
                }
            }
            
        }
        // System.out.print(ans);
        return ans;
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
