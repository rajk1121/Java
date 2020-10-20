/*
    **********    *******************    *    *******************    **********
	**********     *****************    ***    *****************     **********
	**********      ***************    *****    ***************      **********
	**********       *************    *******    *************       **********
	**********        ***********    *********    ***********        **********
	**********         *********    ***********    *********         **********
	**********          *******    *************    *******          **********
	**********           *****    ***************    *****           **********
	**********            ***    *****************    ***            **********
	**********             *    *******************    *             **********

 */
public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		drawPattern(n);
	}
	public static void drawPattern(int n) {
		
		//n stars
		for(int j=0; j<n ; j++) {
			for(int i=0; i<n ; i++)
				System.out.print("*");
			System.out.print("    ");
			//space
			for(int i=0; i<j;  i++)
				System.out.print(" ");
			
			
			//1st triangle
			int totalstars = 2*(n-j)-1;
			for(int i=0 ; i<totalstars;i++)
				System.out.print("*");
			System.out.print("    ");
			//2nd triangle
			int totalstars2 = 2*j + 1;
			for(int i=0 ; i<totalstars2;i++)
				System.out.print("*");
			System.out.print("    ");
			//3rd triangle
			int totalstars3 = 2*(n-j)-1;
			for(int i=0 ; i<totalstars3;i++)
				System.out.print("*");
			//space
			
			for(int i=0; i<j;  i++)
				System.out.print(" ");
			
			
			System.out.print("    ");
			for(int i=0 ; i<n ;i++)
				System.out.print("*");
			System.out.println();
			
		}
	}

}
