//package PRACTICE;

import java.util.*;

public class rotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M= sc.nextInt();
		int N=sc.nextInt();
		int r=sc.nextInt();
		int [][]matrix =new int[M][N];
		for(int i=0 ; i<M; i++) {
			for(int j=0 ; j<N;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}

		int even=0;
		if(N%2==0){
			even = N;
		}
		else {
			even=M;
		}
//		r = r%(2*M + 2*N);
		for(int number =0; number<r ; number++) {

			int rm=M-1;
			int rn=N-1;
		for(int i=0 ; i<even/2;i++) {
				int x=0;
				int l=i;
				int k=i;
				int first = matrix[l][k];
				int value = 2*(rm+1-l)+2*(rn-1-k);
				k++;
				int dir=0;
				while(x<value) {
					if(dir==0) {
						matrix[l][k-1]=matrix[l][k];
						if(k==rn) {
							dir=1;
							l++;
						}else {

							k++;
						}
					}
					else if(dir==1) {
						matrix[l-1][k]=matrix[l][k];
						if(l==rm) {
							dir=2;
//							l--;
						}else {
							l++;
						}
//						k++;
					}
					else if(dir==2) {
						k--;
						matrix[l][k+1]=matrix[l][k];
						if(k==i) {
							dir=3;
							
						}
					}
					else if(dir==3) {
						l--;
						System.out.println(x+" "+l+" "+k);
						matrix[l+1][k]=matrix[l][k];
						if(l==i) {
							matrix[l+1][k]=first;
						}
					}
					x++;
				}
				rm--;
				rn--;
			}
		  }
		for(int x=0 ; x<M; x++) {
			for(int y=0 ; y<N ; y++) {
				System.out.print(matrix[x][y]+" ");
			}
			System.out.println("");
		}
			
		}
		
	}


