import java.util.*;
public class long_palind_ssubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean[][] arr = new boolean[str.length()][str.length()];
		int ri=0,i=0;
		int rj=0,j=0;
		int longest=Integer.MIN_VALUE;
		for(int k=0 ; k<str.length();k++) {
			arr[k][k]=true;
		}
		for(int k=0; k<str.length()-1;k++) {
//			System.out.println(str.charAt(k)+"  "+str.charAt(k+1));
			if(str.charAt(k)==str.charAt(k+1)) {
				arr[k][k+1]=true;
				ri=k;
//				System.out.println("**");
				rj=k+1;
				longest=2;
			}
		}
		for(int k=2;k<str.length();k++) {
			
			for(int x=0 ; x+k<str.length();x++) {
				System.out.println(x+1 +" "+(x+k-1));
				System.out.println(arr[x+1][x+k-1] );
				if(arr[x+1][x+k-1] && str.charAt(x)==str.charAt(x+k)) {
					arr[x][x+k]=true;
					int ilong=k+1;
					if(ilong>longest) {
						longest=ilong;
						ri=x;
						rj=x+k;
					}
				}
			}
		}
		System.out.println(str.substring(ri,rj+1));
	}

}
