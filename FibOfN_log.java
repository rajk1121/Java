import java.util.*;
public class FibOfN_log {
	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int mat[][]=  {
				{1,1},
				{1,0}
		};
		while(N!=1) {
			mat = Multiply(mat);
			N=N/2;
		}

		for(int i=0; i<2;i++) {
			for(int k=0;k<2;k++) {
				System.out.print(mat[i][k]+" ");
			}
			System.out.println();
		}
		
	}

	private static int[][] Multiply(int[][] mat) {
		// TODO Auto-generated method stub
		int matrix[][] = new int[2][2];
		for(int i=0; i<2;i++) {
			for(int j=0;j<2;j++) {
				matrix[i][j]=0;
				for(int k=0 ; k<2 ; k++) {
					matrix[i][j]=matrix[i][j]+mat[i][k]*mat[k][j];
				}
			}
		}
		return matrix;
	}

}
