import java.util.*;
public class string_shifts {
	 public static String stringShift(String s, int[][] shift) {
	     
		 int rot = 0;
		 for(int i=0;  i<shift.length ;i++) {
			 if(shift[i][0]==1) {
				 rot = rot+shift[i][1];
			 }else {

				 rot = rot-shift[i][1];
			 }
		 }
//		 System.out.println(rot);
		 rot = rot%s.length();
		 if(rot>0) {
			 String toReturn = "";
			 toReturn = s.substring(s.length()-rot) + s.substring(0, s.length()-rot);
			 return toReturn;
			 
		 }else if(rot<0) {
			 rot = Math.abs(rot);
			 
			 return s.substring(rot)+s.substring(0, rot);
		 }else {
			 return s;
		 }
		 
		 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdefg";
		int[][] shift= {{1,1},{1,1},{0,2},{1,3},{0,4},{0,7}};
		System.out.println(stringShift(str, shift));
	}

}
