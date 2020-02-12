import java.util.*;
import java.util.ArrayList;
//Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.


public class RainWater_Trapping_2 {

	private ArrayList<Node> data;
	private boolean isMin;
	boolean[][] visited;
	public class Node{
		int i;
		int j;
		int value;
		public Node(int x,int y,int val) {
			this.i=x;
			this.j=y;
			this.value=val;
		}
	}
	
	public RainWater_Trapping_2() {
		// TODO Auto-generated constructor stub
		this(false);
	}
	public void delete() {
		this.data.remove(this.data.size()-1);
	}
	public RainWater_Trapping_2(boolean isMin) {
		this.isMin = isMin;
		this.data = new ArrayList<>();
	}
	
	public RainWater_Trapping_2(Node[] items, boolean isMin) {
		this(isMin);

		for (Node item : items) {
			this.data.add(item);
		}

		for (int i = this.data.size() / 2 - 1; i >= 0; i--) {
			this.downheapify(i);
		}

	}

    
	public int size() {
		return this.data.size();
	}

	public Node getHP() {
		return this.data.get(0);
	}

	public void add(int i, int j, int val) {
		Node item = new Node(i,j,val);
		this.data.add(item);
		this.upheapify(this.data.size() - 1);

	}

	private void upheapify(int ci) {
		if (ci == 0) {
			return;
		}
		int pi = (ci - 1) / 2;
		if (!isLarger(pi, ci)) {
			this.swap(pi, ci);
			this.upheapify(pi);
		}
	}

	private boolean isLarger(int i, int j) {
		Node ithitem = this.data.get(i);
		Node jthitem = this.data.get(j);

		if (this.isMin) {
			return ithitem.value-jthitem.value < 0;
		} else {
			return ithitem.value-jthitem.value > 0;
		}
	}

	public void swap(int i, int j) {
		Node ithitem = this.data.get(i);
		Node jthitem = this.data.get(j);

		this.data.set(i, jthitem);
		this.data.set(j, ithitem);
	}

	public void display() {
		this.display(0);
	}

	private void display(int index) {

		int lci = 2 * index + 1;
		int rci = 2 * index + 2;
		String str = "";
		if (lci < this.data.size()) {
			Node lc = this.data.get(lci);
			str = str + lc + "=>";
		} else {
			str = str + "END=>";
		}

		str = str + this.data.get(index);

		if (rci < this.data.size()) {
			Node rc = this.data.get(rci);
			str = str + "<=" + rc;
		} else {
			str = str + "<=END";
		}
		System.out.println(str);
		if (lci < this.data.size()) {
			this.display(lci);
		}

		if (rci < this.data.size()) {
			this.display(rci);
		}
	}

	public Node remove() {
		Node rv = this.data.get(0);
		this.swap(0, this.data.size() - 1);
		this.data.remove(this.data.size() - 1);
		this.downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mi = pi;
		if (lci < this.data.size() && isLarger(lci, mi)) {
			mi = lci;
		}

		if (rci < this.data.size() && isLarger(rci, mi)) {
			mi = rci;
		}
		if (mi != pi) {
			this.swap(mi, pi);
			this.downheapify(mi);
		}
	}
	private int RainWater(int [][] heights) {
		// TODO Auto-generated method stub
		int ans =0;
		
		while(this.size()!=0) {
			Node del = this.remove();
			if(del.i-1>0 && !this.visited[del.i-1][del.j] ) {
				if(del.value>heights[del.i-1][del.j]) {
					ans = ans + (del.value-heights[del.i-1][del.j]);
					this.add(del.i-1, del.j, del.value);

					this.visited[del.i-1][del.j] = true;
				}else  {
					this.add(del.i-1, del.j, heights[del.i-1][del.j]);
				}
			}
//			if(!this.visited[del.i][del.j-1]) {
//				
//			}
//			if(!this.visited[del.i][del.j+1]) {
//				
//			}
			if(del.i+1<heights.length-1 && !this.visited[del.i+1][del.j]) {
				if(del.value>heights[del.i+1][del.j]) {
					ans = ans + (del.value-heights[del.i+1][del.j]);
					this.add(del.i+1, del.j, del.value);
					this.visited[del.i+1][del.j] = true;
				}else  {
					this.add(del.i+1, del.j, heights[del.i+1][del.j]);
				}
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		RainWater_Trapping_2 h1 = new RainWater_Trapping_2(true);
		int m = sc.nextInt();
		int n= sc.nextInt();
		h1.visited = new boolean[m][n];
		int [][] heights = new int[m][n];
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ;j<n ; j++) {
				heights[i][j] = sc.nextInt();
				if(i==0 || j==0 ||i==m -1||j==n-1) {
					if (i==0 && j==0 || i==0 && j==n-1 || i==m-1 && j==n-1 || i==m-1 &&j==0) {
						System.out.println(heights[i][j]+" "+i+" "+j);
						continue;
					
					}else {
						h1.add(i, j, heights[i][j]);
					}
					h1.visited[i][j] = true;
					
				}
			}
		}
		int ans =h1.RainWater(heights);
		System.out.println(ans);
		
		
	}
	

}


