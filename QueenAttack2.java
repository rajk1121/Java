import java.util.*;
public class QueenAttack2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		int n= sc.nextInt();
//		System.out.println(n);
		int k=sc.nextInt();
//		System.out.println(k);
		int q_row = sc.nextInt();
//		System.out.println(q_row);
		int q_col = sc.nextInt();
//		System.out.println(q_col);
		int[][] obstacle = new int[k][2];
		for(int i=0 ; i<k ; i++) {
			obstacle[i][0]=sc.nextInt();
			obstacle[i][1] = sc.nextInt();
		}
		
		int total = 0;
		total=total+q_col-1;
		total=total+n-q_row;
		total=total+q_row-1;
		total=total+n-q_col;
		total=total+Math.min(q_row, q_col)-1;
		total=total+n-Math.max(q_row, q_col);
		total=total+Math.min(q_col-1, n-q_row);
		total=total+Math.min(q_row-1,n-q_col);
//		System.out.println(total);
		int LErow=0;
		int LEcol=0;
		int RErow=0;
		int REcol=0;
		int TEcol=0;
		int TErow=0;
		int BEcol=0;
		int BErow=0;
		int BLrow=0;
		int BLcol=0;
		int BRrow=0;
		int BRcol=0;
		int TLrow=0;
		int TLcol=0;
		int TRrow=0;
		int TRcol=0;
		int i=k;
		for(k=0 ;k<i ; k++) {
			if(obstacle[k][1]==q_col) {
//				System.out.println(obstacle[k][0]+"***"+obstacle[k][1]+" TOP BOTTOM");
				if(obstacle[k][0]>q_row && (TErow-q_row>obstacle[k][0]-q_row || TErow==0)) {
//					total = total-(n-(obstacle[k][0]))-1;
					TErow=obstacle[k][0];
					System.out.println(obstacle[k][0]+"***"+obstacle[k][1]+" TOP BOTTOM");
					TEcol = q_col;
//					System.out.println(total);
				}else if(obstacle[k][0]<q_row && (q_row-BErow>q_row-obstacle[k][0] || BErow==0)) {
					BErow=obstacle[k][0];
					BEcol = q_col;

					System.out.println(obstacle[k][0]+"***"+obstacle[k][1]+" TOP BOTTOM");
//					total=total-(obstacle[k][0]-1)-1;
//					System.out.println(total);
				}
			}else if(obstacle[k][0]==q_row){
				if(obstacle[k][1]>q_col &&(REcol-q_col> obstacle[k][1]-q_col || REcol==0)) {
//					total=total-(n-(obstacle[k][1]))-1;
					REcol=obstacle[k][1];
					System.out.println(obstacle[k][0]+"***"+obstacle[k][1]+" LEFT RIGHT");
					
					RErow=obstacle[k][0];
//					System.out.println(total);
				}else if(obstacle[k][1]<q_col && (q_col-LEcol>q_col-obstacle[k][1]|| LEcol==0)) {
//					total=total-(obstacle[k][1]-1)-1;
					System.out.println(obstacle[k][0]+"***"+obstacle[k][1]+" LEFT RIGHT");
					LEcol = obstacle[k][1];
					LErow = q_row;
//					System.out.println(obstacle[k][0]+"***"+obstacle[k][1]+" DIAGONAL");
//					System.out.println(total);
				}
			}else if(Math.abs(obstacle[k][0]-q_row) == Math.abs(obstacle[k][1]-q_col)) {

//				System.out.println(obstacle[k][0]+"***"+obstacle[k][1]+" DIAGONAL");
				if(obstacle[k][0]>q_row && obstacle[k][1]<q_col && obstacle[k][0]-q_row==q_col-obstacle[k][1] && (q_col-TLcol>q_col-obstacle[k][1] || TLcol==0) && (TLrow-q_row> obstacle[k][0]-q_row || TLcol==0)) {
//					total = total -( Math.min(n-obstacle[k][0], obstacle[k][1]-1))-1;
					TLrow=obstacle[k][0];
					TLcol = obstacle[k][1];
					System.out.println(obstacle[k][0]+"***"+obstacle[k][1]+" TOP LEFT");
//					System.out.println(total);
				} else if(obstacle[k][0]>q_row && obstacle[k][1]>q_col && obstacle[k][0]-q_row== obstacle[k][1]-q_col &&((TRcol-q_col>obstacle[k][1]-q_col) || TRcol==0) && ((TRrow-q_row>obstacle[k][0]-q_row) || TRrow==0)) {
//					total = total -(n- Math.max(obstacle[k][0], obstacle[k][1]))-1;
					TRrow = obstacle[k][0];
					TRcol= obstacle[k][1];
					System.out.println(obstacle[k][0]+"***"+obstacle[k][1]+" TOP RIGHT");
//					System.out.println(total);
				} else if(obstacle[k][0]<q_row && obstacle[k][1]>q_col && obstacle[k][0]-q_row==q_col-obstacle[k][1] && (q_row-BRrow>q_row-obstacle[k][0] || BRrow==0) && (BRcol-q_col>obstacle[k][1]-q_col||BRcol==0)) {
//					total = total -(Math.min(obstacle[k][0]-1, n-obstacle[k][1]))-1;
					BRcol = obstacle[k][1];
					BRrow = obstacle[k][0];
					System.out.println(obstacle[k][0]+"***"+obstacle[k][1]+" BOTTOM RIGHT");
//					System.out.println(total);
				} else if(obstacle[k][0]<q_row && obstacle[k][1]<q_col && obstacle[k][0]-q_row== obstacle[k][1]-q_col &&(q_col-BLcol>q_col-obstacle[k][1] || BLcol==0) && (q_row-BLrow> q_row-obstacle[k][0]|| BLrow==0)) {
//					total = total - (Math.min(obstacle[k][0], obstacle[k][1]))-1;
					BLrow=obstacle[k][0];
					System.out.println(obstacle[k][0]+"***"+obstacle[k][1]+" BOTTOM LEFT");
					BLcol = obstacle[k][1];
//					System.out.println(total);
				}
				
			}
		}

		int inter =0;
		inter+=LEcol!=0?LEcol:0;
//		System.out.println(inter);
//		System.out.println(TErow);
		inter+=TErow!=0?n-TErow+1:0;
//		System.out.println(inter);
		inter+=BErow!=0?BErow:0;
//		System.out.println(inter);
		inter+=REcol!=0?n-REcol+1:0;
//		System.out.println(inter);
		inter+=BLrow!=0&&BLcol!=0?Math.min(BLrow,BLcol):0;
//		System.out.println(inter);
		inter+=TRrow!=0&&TRcol!=0?n-Math.max(TRrow, TRcol)+1:0;
//		System.out.println(inter);
		inter+=TLcol!=0&TLrow!=0?Math.min(TLcol, n-TLrow+1):0;
//		System.out.println(inter);
		inter+=BRrow!=0&&BRcol!=0?Math.min(BRrow,n-BRcol+1):0;
//		System.out.println(inter);
		System.out.println(total-inter);
	}

}
