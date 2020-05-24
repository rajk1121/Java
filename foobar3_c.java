
public class foobar3_c {
	public static int solution(int[][] map) {
        // Your code here
		int[][] dp = new int[map.length][map[00].length];
		boolean[][] visited = new boolean[map.length][map[0].length];
		int ans = Integer.MAX_VALUE;
		visited[0][0] = true;
		if(isValid(1, 0, map,visited)) {
		ans = Math.min(ans, Sol(map, visited, dp, false, 1, 0));
		}
		if(isValid(0, 1, map,visited)) {
		ans = Math.min(ans, Sol(map, visited, dp, false, 0, 1));
		}
//		for(int i=0 ; i<map.length ; i++) {
//			for(int j=0 ; j<map[0].length ; j++)
//				System.out.print(dp[i][j]+" ");
//			System.out.println();
//		}
		dp[0][0] = ans+1;
		return ans + 1;
    }
	public static int Sol(int[][] map, boolean[][] visited , int[][]dp, boolean removed, int i, int j) {
//		System.out.println(i+" "+j);
		if(i==map.length-1 && j==map[0].length-1) {
			dp[map.length-1][map[0].length-1] = 1;
			return 1;
		}
//		if(removed && map[i][j]==1)
//			return Integer.MAX_VALUE;
		visited[i][j] = true;
		if(map[i][j]==1)
			removed = true;
		int ans = Integer.MAX_VALUE;
		if(isValid(i-1, j, map,visited)) {
			
				ans = Math.min(ans, Sol(map, visited, dp, removed, i-1, j));
		}
		if(isValid(i+1, j, map,visited)) {
			
				ans = Math.min(ans, Sol(map, visited, dp, removed, i+1, j));
		}
		if(isValid(i, j-1, map,visited)) {
			
				ans = Math.min(ans, Sol(map, visited, dp, removed, i, j-1));
		}
		if(isValid(i, j+1, map,visited)) {
			
				ans = Math.min(ans, Sol(map, visited, dp, removed, i, j+1));
					
		}

		visited[i][j] = false;
		if(ans==Integer.MAX_VALUE) {
			dp[i][j] = ans;
			return ans;
		}
		dp[i][j] = ans+1;
		return ans + 1;
	}
	public static boolean isValid(int i, int j, int[][] map,boolean[][] visited) {
		if(i>=map.length || i<0 || j>=map[0].length || j<0 || visited[i][j])
			return false;
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map=   {{0, 0, 0, 0, 0, 0},
						{1, 0, 1, 1, 1, 0},
						{0, 0, 0, 0, 0, 0},
						{0, 1, 1, 1, 1, 1},
						{0, 1, 1, 1, 1, 1},
						{0, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 1, 0},
						{0, 0, 0, 0, 1, 0}};
//		int[][] map = {{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};

		System.out.println(solution(map));
	}

}
