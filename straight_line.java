
public class straight_line {
	public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length==1)
            return true;
        boolean infinite = false;
        double m  = 0.0d;
        if(coordinates[0][0]==coordinates[1][0])
            infinite = true;
        else{
//        	System.out.println(coordinates[1][1]+" "+coordinates[0][1]);
//        	System.out.println(coordinates[1][0]+" "+coordinates[0][0]);
             m = (coordinates[1][1] - coordinates[0][1])*1.0/(coordinates[1][0] - coordinates[0][0]);
             
//            System.out.println(m+" "+infinite);    
        }
        
        for(int i=2 ; i<coordinates.length ; i++){
            if(infinite){
                if(coordinates[i][0]!=coordinates[0][0])
                    return false;
            }
            else{
            	if(coordinates[i][0] - coordinates[i-1][0] == 0)
            		return false;
                double dm = (coordinates[i][1] - coordinates[i-1][1])/(coordinates[i][0] - coordinates[i-1][0]);
            if(dm != m)
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
		System.out.println(checkStraightLine(nums));
//		int x = 4;
//		int y = 5;
//		double z = (x*1.0/y);
//		System.out.println(z);
	}

}
