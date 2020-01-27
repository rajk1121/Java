import java.util.*;
import java.math.*;
public class encryption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String();
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		String[] arr= s.split("\\s");
		StringBuilder sb=  new StringBuilder();
		for(String s1: arr) {
			System.out.println(s1);
			sb.append(s1);
		}
		String ns = sb.toString();
		int length=ns.length();
		
		int col =(int) Math.ceil(Math.sqrt(length));
		int row = (int)Math.floor(Math.sqrt(length));
		System.out.println(col+" "+row+" "+ns);
		sb = new StringBuilder();
		for(int i=0 ; i<col; i++) {
			for(int j=i; j<ns.length();j=j+col) {
//				System.out.print(ns.charAt(j));
				sb.append(ns.charAt(j));
			}
//			System.out.println();
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
