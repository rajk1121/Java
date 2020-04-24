/*
 * In a given grid, each cell can have one of three values:

    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 
 */
import java.util.*;

class RottenNode {
	int i, j;

	public RottenNode(int x, int y) {
		i = x;
		j = y;
	}
}

class rotten_oranges {
	public static int orangesRotting(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] visited = new boolean[row][col];
		Queue<RottenNode> q = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 2) {
					RottenNode n = new RottenNode(i, j);
					q.add(n);
				} else if (grid[i][j] == 1) {
					set.add(i + " " + j);
				}

			}
		}

		int ans = find(visited, grid, q, set);
		if (set.size() == 0)
			return ans;
		return -1;
	}

	public static int find(boolean[][] visited, int[][] graph, Queue<RottenNode> q, HashSet<String> sets) {

		boolean found = false;
		int r = q.size();
		int ans = 0;
		HashSet<String> marked = new HashSet();
		while (q.size() != 0) {
			int total = 0;
			found = false;
			for (int z = 0; z < r; z++) {
				RottenNode temp = q.remove();
				int i = temp.i;
				int j = temp.j;
				if (visited[i][j])
					continue;
				// System.out.println(i+" "+j);
				visited[i][j] = true;
				if (sets.contains(i + " " + j))
					sets.remove(i + " " + j);
				if (check(i - 1, j, graph, visited, marked)) {
					found = true;
					total++;
					RottenNode x = new RottenNode(i - 1, j);
					q.add(x);
					marked.add((i - 1) + " " + j);
					// System.out.println("hi");
				}
				if (check(i + 1, j, graph, visited, marked)) {
					found = true;
					total++;
					RottenNode x = new RottenNode(i + 1, j);
					q.add(x);
					marked.add((i + 1) + " " + j);
					// System.out.println("hi");
				}
				if (check(i, j - 1, graph, visited, marked)) {
					found = true;
					// System.out.println("hi");
					total++;
					RottenNode x = new RottenNode(i, j - 1);
					q.add(x);
					marked.add(i + " " + (j - 1));
				}
				if (check(i, j + 1, graph, visited, marked)) {
					found = true;
					total++;
					RottenNode x = new RottenNode(i, j + 1);
					q.add(x);
					marked.add(i + " " + (j + 1));
				}
			}
			r = total;
			if (q.size() != 0)
				ans++;
		}
		return ans;
	}

	public static boolean check(int i, int j, int[][] graph, boolean[][] visited, HashSet<String> marked) {
		if (i < 0 || i >= graph.length || j < 0 || j >= graph[0].length)
			return false;
		if (visited[i][j])
			return false;
		if (graph[i][j] == 1 && !marked.contains(i + " " + j))
			return true;
		return false;
	}

	public static void main(String[] ar) {
		int[][] grid = { { 2, 1 }, { 2, 1 }, { 2, 0 }, { 0, 2 }, { 1, 2 } };
		System.out.println(orangesRotting(grid));
	}
}
